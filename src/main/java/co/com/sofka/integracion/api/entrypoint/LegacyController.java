package co.com.sofka.integracion.api.entrypoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.integracion.api.dominio.model.Aif;
import co.com.sofka.integracion.api.dominio.model.Legacy;
import co.com.sofka.integracion.api.repository.LegacyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/framework")
public class LegacyController {
	private static Logger log = LoggerFactory.getLogger(LegacyController.class);
	private LegacyService legacyService;
	
	public LegacyController (LegacyService legacyService) {
		this.legacyService=legacyService;
	}
	
	@GetMapping("listarLegacy")
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los legacy fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Legacy>> getLegacys(){
		log.debug("REST request listar todos los legacy");
		return ResponseEntity.ok(legacyService.getLegacys());		
	}
	
	@PostMapping(value = "crearLegacy", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "crea un registro Legacy", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Legacy creado", response = Legacy.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Legacy> addLegacy( @RequestBody Legacy data){
		Legacy legacy = new Legacy(data.getLegacyRegisterId(), data.getlegacyApplicationId(), data.getLegacyOperationName(),data.getAdapterId(),data.getXsltIn(), data.getXsltOut(),
				data.getLegacyEndpoint(), data.getEnableRetryFlg(),data.getRetryCount(),data.getRetryDelay(),data.getLegacyServiceName(),data.getenableMsgAudit(), data.getSoapAction(), 
				data.gettimeout(), data.getCommunicatorIn(), data.getCommunicatorOut(),data.getAdapterIn(), data.getAuthUser(), data.getAuthPassword(), data.getGenCustomHeaders());
		legacyService.addLegacy(legacy);
		return new ResponseEntity<Legacy>(legacy, HttpStatus.OK);
	}
	@GetMapping(value = "consultarLegacy/{legacyRegisterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar Legacy por legacyRegisterId", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "legacyRegisterId encontrado", response = Aif.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Legacy> getLegacy( @PathVariable("legacyRegisterId") Integer legacyRegisterId){
		 log.debug("REST request getLegacy id : {}", legacyRegisterId);
		return ResponseEntity.ok(legacyService.getLegacy(legacyRegisterId));
	}
}
