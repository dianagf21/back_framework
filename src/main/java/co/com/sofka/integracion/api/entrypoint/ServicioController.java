package co.com.sofka.integracion.api.entrypoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.integracion.api.dominio.model.Receiver;
import co.com.sofka.integracion.api.dominio.model.Servicio;
import co.com.sofka.integracion.api.repository.ServicioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/framework")
public class ServicioController {
	private static Logger log = LoggerFactory.getLogger(ServicioController.class);
	
	private ServicioService ServicioService;
	 
	public ServicioController (ServicioService servicioService ) {
		this.ServicioService = servicioService;
	}
	
	@GetMapping(value = "consultarServicio1/{receiverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar receiver por receiverId", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "receiver encontrado", response = Receiver.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Servicio> getReceiverController( @PathVariable("receiverId") Integer receiverId){
		 log.debug("REST request getReceiver id : {}", receiverId);
		return ResponseEntity.ok(ServicioService.getReceiverController(receiverId));
	}
	
	@GetMapping(value = "consultarServicio2/{aifId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar receiver por AifId", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "aifId encontrado", response = Receiver.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Servicio> getAifLegacy( @PathVariable("aifId") Integer aifId){
		 log.debug("REST request getaif id : {}", aifId);
		return ResponseEntity.ok(ServicioService.getAifLegacy(aifId));
	}
	
	@GetMapping(value = "consultarServicio/{receiverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar receiver por receiverId", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "receiver encontrado", response = Receiver.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Servicio> getServicio( @PathVariable("receiverId") Integer receiverId){
		 log.debug("REST request getReceiver id : {}", receiverId);
		return ResponseEntity.ok(ServicioService.getServicio(receiverId));
	}
	
}
