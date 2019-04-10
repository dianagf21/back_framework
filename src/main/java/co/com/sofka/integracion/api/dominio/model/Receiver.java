package co.com.sofka.integracion.api.dominio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "WMB_FW_RECEIVER_MST")

public class Receiver {
	
	@Id
	@Column(name="RECEIVER_ID")
	private Integer receiverId;
	
	@Column(name="RECEIVER_NAME")
	private String receiverName;
	
	@Column(name="RECEIVER_DESC")
	private String receiverDesc;
	
	@Column(name="RECEIVER_ENDPOINT")
	private String receiverEndpoint;
	
	@Column(name="CONTROLLER_ID")
	private Integer controllerId;
	
	@Column(name="XSLT_IN")
	private String xsltIn;
	
	@Column(name="XSLT_OUT")
	private String xsltOut;
	
	@Column(name="OPERATION_NAME")
	private String operationName;
	
	@Column(name="LEGACY_REGISTER_ID")
	private Integer legacyRegisterId;
	
	@Column(name="RECEIVER_CONTROLLER_IMPL_TYPE")
	private String receiverControllerImplType;
	
	@Column(name="ENABLE_MSG_AUDIT")
	private String enableMsgAudit;
	
	@Column(name="AUDIT_STORE_DAYS")
	private Integer auditStoreDays;
	
	@Column(name="UNQ_TXN_ID_DEF")
	private String unqTxnIdDef;
	
	@Column(name="TIMEOUT")
	private Integer timeout;
	
	@Column(name="GATEWAY_ENDPOINT")
	private String gatewayEndpoint;
	
	@Column(name="EXECUTION_GROUP")
	private String executionGroup;
	
	@Column(name="NOTIFICATION_EMAIL")
	private String notificationEmail;
	
	@Column(name="VIRTUAL_CONTROLLER_ENDPOINT")
	private String virtualControllerEndpoint;
	
	@Column(name="VIRTUAL_AIF_ENDPOINT")
	private String virtualAifEndpoint;
	
	@Column(name="ENABLE_SERVICE_CALLBACK")
	private String enableServiceCallback;
	
	@Column(name="CALLBACK_CONTROLLER_ENDPOINT")
	private String callbackControllerEndpoint;
	
	@Column(name="ENABLE_AUDIT")
	private String enableAudit;
	
	@Column(name="ENABLE_STORE_FORWARD")
	private String enableStoreForward;
	
	@Column(name="STORE_FORWARD_BATCH_COUNT")
	private Integer storeForwardBatchCount;
	
	@Column(name="ENABLE_GATEWAY_INLINE")
	private String enableGatewayInline;

	public Receiver() {
		super();
	}
	public Receiver(Integer receiverId,String receiverName,String receiverDesc,String receiverEndpoint,Integer controllerId,String xsltIn,
			String xsltOut,String operationName,Integer legacyRegisterId,String receiverControllerImplType,String enableMsgAudit,Integer auditStoreDays,
			String unqTxnIdDef,Integer timeout,String gatewayEndpoint,String executionGroup, String notificationEmail,String virtualControllerEndpoint,String virtualAifEndpoint,
			String enableServiceCallback,String callbackControllerEndpoint, String enableAudit, String enableStoreForward, Integer storeForwardBatchCount,String enableGatewayInline) {
		super();
		this.receiverId=receiverId;
		this.receiverName=receiverName;
		this.receiverDesc=receiverDesc;
		this.receiverEndpoint=receiverEndpoint;
		this.controllerId=controllerId;
		this.xsltIn=xsltIn;
		this.xsltOut=xsltOut;
		this.operationName=operationName;
		this.legacyRegisterId=legacyRegisterId;
		this.receiverControllerImplType=receiverControllerImplType;
		this.enableMsgAudit=enableMsgAudit;
		this.auditStoreDays=auditStoreDays;
		this.unqTxnIdDef=unqTxnIdDef;
		this.timeout=timeout;
		this.gatewayEndpoint=gatewayEndpoint;
		this.executionGroup=executionGroup;
		this.notificationEmail=notificationEmail;
		this.virtualControllerEndpoint=virtualControllerEndpoint;
		this.virtualAifEndpoint=virtualAifEndpoint;
		this.enableServiceCallback=enableServiceCallback;
		this.callbackControllerEndpoint=callbackControllerEndpoint;
		this.enableAudit=enableAudit;
		this.enableStoreForward=enableStoreForward;
		this.storeForwardBatchCount=storeForwardBatchCount;
		this.enableGatewayInline=enableGatewayInline;
		
	}
	public Integer getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverDesc() {
		return receiverDesc;
	}
	public void setReceiverDesc(String receiverDesc) {
		this.receiverDesc = receiverDesc;
	}
	public String getReceiverEndpoint() {
		return receiverEndpoint;
	}
	public void setReceiverEndpoint(String receiverEndpoint) {
		this.receiverEndpoint = receiverEndpoint;
	}
	public Integer getControllerId() {
		return controllerId;
	}
	public void setControllerId(Integer controllerId) {
		this.controllerId = controllerId;
	}
	public String getXsltIn() {
		return xsltIn;
	}
	public void setXsltIn(String xsltIn) {
		this.xsltIn = xsltIn;
	}
	public String getXsltOut() {
		return xsltOut;
	}
	public void setXsltOut(String xsltOut) {
		this.xsltOut = xsltOut;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public Integer getLegacyRegisterId() {
		return legacyRegisterId;
	}
	public void setLegacyRegisterId(Integer legacyRegisterId) {
		this.legacyRegisterId = legacyRegisterId;
	}
	public String getReceiverControllerImplType() {
		return receiverControllerImplType;
	}
	public void setReceiverControllerImplType(String receiverControllerImplType) {
		this.receiverControllerImplType = receiverControllerImplType;
	}
	public String getEnableMsgAudit() {
		return enableMsgAudit;
	}
	public void setEnableMsgAudit(String enableMsgAudit) {
		this.enableMsgAudit = enableMsgAudit;
	}
	public Integer getAuditStoreDays() {
		return auditStoreDays;
	}
	public void setAuditStoreDays(Integer auditStoreDays) {
		this.auditStoreDays = auditStoreDays;
	}
	public String getUnqTxnIdDef() {
		return unqTxnIdDef;
	}
	public void setUnqTxnIdDef(String unqTxnIdDef) {
		this.unqTxnIdDef = unqTxnIdDef;
	}
	public Integer gettimeout() {
		return timeout;
	}
	public void settimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public String getgatewayEndpoint() {
		return gatewayEndpoint;
	}
	public void setgatewayEndpoint(String gatewayEndpoint) {
		this.gatewayEndpoint = gatewayEndpoint;
	}
	public String getExecutionGroup() {
		return executionGroup;
	}
	public void setExecutionGroup(String executionGroup) {
		this.executionGroup = executionGroup;
	}
	public String getNotificationEmail() {
		return notificationEmail;
	}
	public void setNotificationEmail(String notificationEmail) {
		this.notificationEmail = notificationEmail;
	}
	public String getVirtualControllerEndpoint() {
		return virtualControllerEndpoint;
	}
	public void setVirtualControllerEndpoint(String virtualControllerEndpoint) {
		this.virtualControllerEndpoint = virtualControllerEndpoint;
	}
	public String getVirtualAifEndpoint() {
		return virtualAifEndpoint;
	}
	public void setVirtualAifEndpoint(String virtualAifEndpoint) {
		this.virtualAifEndpoint = virtualAifEndpoint;
	}
	public String getEnableServiceCallback() {
		return enableServiceCallback;
	}
	public void setEnableServiceCallback(String enableServiceCallback) {
		this.enableServiceCallback = enableServiceCallback;
	}
	public String getCallbackControllerEndpoint() {
		return callbackControllerEndpoint;
	}
	public void setCallbackControllerEndpoint(String callbackControllerEndpoint) {
		this.callbackControllerEndpoint = callbackControllerEndpoint;
	}
	public String getEnableAudit() {
		return enableAudit;
	}
	public void setEnableAudit(String enableAudit) {
		this.enableAudit = enableAudit;
	}
	public String getEnableStoreForward() {
		return enableStoreForward;
	}
	public void setEnableStoreForward(String enableStoreForward) {
		this.enableStoreForward = enableStoreForward;
	}
	public Integer getStoreForwardBatchCount() {
		return storeForwardBatchCount;
	}
	public void setStoreForwardBatchCount(Integer storeForwardBatchCount) {
		this.storeForwardBatchCount = storeForwardBatchCount;
	}
	public String getEnableGatewayInline() {
		return enableGatewayInline;
	}
	public void setEnableGatewayInline(String enableGatewayInline) {
		this.enableGatewayInline = enableGatewayInline;
	}
	
	 
}

