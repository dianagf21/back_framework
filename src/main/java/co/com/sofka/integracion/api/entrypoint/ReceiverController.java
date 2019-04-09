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

import co.com.sofka.integracion.api.dominio.model.Receiver;
import co.com.sofka.integracion.api.repository.ReceiverService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/framework")

public class ReceiverController {
	private static Logger log = LoggerFactory.getLogger(ReceiverController.class);
	
	private ReceiverService receiverService;
	
	public ReceiverController(ReceiverService receiverService) {
		this.receiverService=receiverService;
	}
	
	
	@GetMapping("listarReceiver")
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los receiver fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Receiver>> getReceiver(){
		log.debug("REST request listar todos los Receiver");
		return ResponseEntity.ok(receiverService.getReceivers());		
	}
	
	@GetMapping(value = "consultar/{receiverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar receiver por receiverId", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "receiver encontrado", response = Receiver.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Receiver> getReceiver( @PathVariable("receiverId") Integer receiverId){
		 log.debug("REST request getReceiver id : {}", receiverId);
		return ResponseEntity.ok(receiverService.getReceiver(receiverId));
	}
	
	@PostMapping(value = "crearReceiver", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "crea un registro receiver", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Receiver creado", response = Receiver.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Receiver> addReceiver( @RequestBody Receiver data){
		Receiver receiver=new Receiver(data.getReceiverId(), data.getReceiverName(), data.getReceiverDesc(), data.getReceiverEndpoint(),data.getControllerId(), data.getXsltIn(), data.getXsltOut(),
										data.getOperationName(), data.getLegacyRegisterId(), data.getReceiverControllerImplType(), data.getEnableMsgAudit(),data.getAuditStoreDays(), data.getUnqTxnIdDef(),
										data.gettimeout(), data.getgatewayEndpoint(),data.getExecutionGroup(), data.getNotificationEmail(), data.getVirtualControllerEndpoint(), data.getVirtualAifEndpoint(),
										data.getEnableServiceCallback(), data.getCallbackControllerEndpoint(), data.getEnableAudit(), data.getEnableStoreForward(), data.getStoreForwardBatchCount(),data.getEnableGatewayInline());
		receiverService.addReceiver(receiver);
		return new ResponseEntity<Receiver>(receiver, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "borrar/{receiverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "elimina un receiver", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "receiver eliminado", response = Receiver.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteReceiver( @PathVariable("receiverId") Integer receiverId){
		log.debug("REST request getReceiver id : {}", receiverId);
		Receiver receiver = receiverService.getReceiver(receiverId);
		receiverService.deleteReceiver(receiver);
	}
	
	@PutMapping(value = "actualizarReceiver", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "actualizar receiver", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "receiver actualizado", response = Receiver.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Receiver> getReceiverActualizar(@RequestBody Receiver data ){
		Receiver receiver=new Receiver(data.getReceiverId(), data.getReceiverName(), data.getReceiverDesc(), data.getReceiverEndpoint(),data.getControllerId(), data.getXsltIn(), data.getXsltOut(),
				data.getOperationName(), data.getLegacyRegisterId(), data.getReceiverControllerImplType(), data.getEnableMsgAudit(),data.getAuditStoreDays(), data.getUnqTxnIdDef(),
				data.gettimeout(), data.getgatewayEndpoint(),data.getExecutionGroup(), data.getNotificationEmail(), data.getVirtualControllerEndpoint(), data.getVirtualAifEndpoint(),
				data.getEnableServiceCallback(), data.getCallbackControllerEndpoint(), data.getEnableAudit(), data.getEnableStoreForward(), data.getStoreForwardBatchCount(),data.getEnableGatewayInline());
		receiverService.updateReceiver(receiver);
		return new ResponseEntity<Receiver>(receiver, HttpStatus.OK);
	}
	
	
}
