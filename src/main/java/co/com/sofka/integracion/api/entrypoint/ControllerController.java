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

import co.com.sofka.integracion.api.dominio.model.Controller;
import co.com.sofka.integracion.api.repository.ControllerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/frameworkC")

public class ControllerController {
	private static Logger log = LoggerFactory.getLogger(ReceiverController.class);
	
	private ControllerService controllerService;
	
	public ControllerController(ControllerService controllerService) {
		this.controllerService=controllerService;
	}
	
	
	@GetMapping("listarController")
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los proyectos fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Controller>> getController(){
		log.debug("REST request listar todos los Controller");
		return ResponseEntity.ok(controllerService.getController());		
	}
	
	@PostMapping(value = "crearController", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "crea un registro receiver", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Controller creado", response = Controller.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Controller> addController( @RequestBody Controller data){
		Controller controller=new Controller(data.getControllerId(), data.getControllerCode(), data.getControllerEndpoint(), data.getControllerDesc(), data.getIsDefault());
		controllerService.addController(controller);
		return new ResponseEntity<Controller>(controller, HttpStatus.OK);
	}
	
	@GetMapping(value = "consultarController/{controllerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar receiver por controllerId", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Controller encontrado", response = Controller.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Controller> getController( @PathVariable("controllerId") Integer controllerId){
		 log.debug("REST request getController id : {}", controllerId);
		return ResponseEntity.ok(controllerService.getController(controllerId));
	}
	
	@PutMapping(value = "actualizarController", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "actualizar Controller", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Controller actualizado", response = Controller.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Controller> getControllerActualizar(@RequestBody Controller data ){
		Controller controller=new Controller(data.getControllerId(), data.getControllerCode(), data.getControllerEndpoint(), data.getControllerDesc(), data.getIsDefault());
		controllerService.updateController(controller);
		return new ResponseEntity<Controller>(controller, HttpStatus.OK);
	}
	@DeleteMapping(value = "borrar/{controllerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "elimina un controller", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "controller eliminado", response = Controller.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteController( @PathVariable("controllerId") Integer controllerId){
		log.debug("REST request getController id : {}", controllerId);
		Controller controller = controllerService.getController(controllerId);
		controllerService.deleteController(controller);
	}
}


