package co.com.sofka.integracion.api.entrypoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.integracion.api.dominio.model.Aif;
import co.com.sofka.integracion.api.repository.AifService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/framework")
public class AifController {
	private static Logger log = LoggerFactory.getLogger(AifController.class);
	
	
	public AifService aifService;
	
	public AifController(AifService aifService) {
		this.aifService=aifService;
	}
	
	@GetMapping("listarAif")
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los proyectos fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Aif>> getAif(){
		log.debug("REST request listar todos los aif");
		return ResponseEntity.ok(aifService.getAifs());		
	}
	
	@PostMapping(value = "crearAif", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "crea un registro Aif", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aif creado", response = Aif.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Aif> addAif( @RequestBody Aif data){
		Aif aif = new Aif(data.getAifId(),data.getAifCode(), data.getAifDesc(), data.getAifImplEndpoint(), data.getLegacyRegisterId(),data.getIsDefault());
		aifService.addAif(aif);
		return new ResponseEntity<Aif>(aif, HttpStatus.OK);
	}
	
	@GetMapping(value = "consultarAif/{aifId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar receiver por aifId", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "aif encontrado", response = Aif.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Aif> getAif( @PathVariable("aifId") Integer aifId){
		 log.debug("REST request getAif id : {}", aifId);
		return ResponseEntity.ok(aifService.getAif(aifId));
	}
	@PutMapping(value = "actualizarAif", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "actualizar receiver", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "receiver actualizado", response = Aif.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Aif> getAifActualizar(@RequestBody Aif data ){
		Aif aif= new Aif(data.getAifId(), data.getAifCode(), data.getAifDesc(), data.getAifImplEndpoint(), data.getLegacyRegisterId(), data.getIsDefault());
		aifService.updateAif(aif);
		return new ResponseEntity<Aif>(aif, HttpStatus.OK);
	}
	@DeleteMapping(value = "borrarAif/{aifId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "elimina un receiver", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "aif eliminado", response = Aif.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteAif( @PathVariable("aifId") Integer aifId){
		log.debug("REST request getAif id : {}", aifId);
		Aif aif = aifService.getAif(aifId);
		aifService.deleteAif(aif);
	}
}
