package co.com.sofka.integracion.api.entrypoint;

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
import co.com.sofka.integracion.api.dominio.model.Controller;
import co.com.sofka.integracion.api.dominio.model.ControllerAif;
import co.com.sofka.integracion.api.dominio.model.Legacy;
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
            @ApiResponse(code = 200, message = "receiver encontrado", response = Servicio.class),
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
            @ApiResponse(code = 200, message = "aifId encontrado", response = Servicio.class),
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
            @ApiResponse(code = 200, message = "receiver encontrado", response = Servicio.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Servicio> getServicio( @PathVariable("receiverId") Integer receiverId){
		 log.debug("REST request getReceiver id : {}", receiverId);
		return ResponseEntity.ok(ServicioService.getServicio(receiverId));
	}
	
	@PostMapping(value = "crearServicio", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "crea un registro receiver", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Servicio creado", response = Servicio.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Servicio> addServicio( @RequestBody Legacy legacyData, Aif aifData, Controller controllerData, Receiver receiverData){
		Legacy legacy=new Legacy(legacyData.getLegacyRegisterId(), legacyData.getlegacyApplicationId(), legacyData.getLegacyOperationName(),legacyData.getAdapterId(),legacyData.getXsltIn(), legacyData.getXsltOut(),
				legacyData.getLegacyEndpoint(), legacyData.getEnableRetryFlg(),legacyData.getRetryCount(),legacyData.getRetryDelay(),legacyData.getLegacyServiceName(),legacyData.getenableMsgAudit(), legacyData.getSoapAction(), 
				legacyData.gettimeout(), legacyData.getCommunicatorIn(), legacyData.getCommunicatorOut(),legacyData.getAdapterIn(), legacyData.getAuthUser(), legacyData.getAuthPassword(), legacyData.getGenCustomHeaders());
		
		Aif aif= new Aif(aifData.getAifId(), aifData.getAifCode(), aifData.getAifDesc(), aifData.getAifImplEndpoint(), aifData.getLegacyRegisterId(), aifData.getIsDefault());
		
		Controller controller= new Controller(controllerData.getControllerId(), controllerData.getControllerCode(), controllerData.getControllerEndpoint(), controllerData.getControllerDesc(), controllerData.getIsDefault());
		
		Receiver receiver= new Receiver(receiverData.getReceiverId(), receiverData.getReceiverName(), receiverData.getReceiverDesc(), receiverData.getReceiverEndpoint(),receiverData.getControllerId(), receiverData.getXsltIn(), receiverData.getXsltOut(),
				receiverData.getOperationName(), receiverData.getLegacyRegisterId(), receiverData.getReceiverControllerImplType(), receiverData.getEnableMsgAudit(),receiverData.getAuditStoreDays(), receiverData.getUnqTxnIdDef(),
				receiverData.gettimeout(), receiverData.getgatewayEndpoint(),receiverData.getExecutionGroup(), receiverData.getNotificationEmail(), receiverData.getVirtualControllerEndpoint(), receiverData.getVirtualAifEndpoint(),
				receiverData.getEnableServiceCallback(), receiverData.getCallbackControllerEndpoint(), receiverData.getEnableAudit(), receiverData.getEnableStoreForward(), receiverData.getStoreForwardBatchCount(),receiverData.getEnableGatewayInline());
		ServicioService.addServicio(legacy, aif, controller,receiver);
		return new ResponseEntity<Servicio>(HttpStatus.OK);
	}
}
