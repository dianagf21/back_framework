package co.com.sofka.integracion.api.dominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WMB_FW_LEGACYREGISTER_MST")
public class Legacy {
	@Id
	private Integer legacyRegisterId;
	private Integer legacyApplicationId;
	private String legacyOperationName;
	private Integer adapterId;
	private String xsltIn;
	private String xsltOut;
	private String legacyEndpoint;
	private String enableRetryFlg;
	private Integer retryCount;
	private Integer retryDelay;
	private String legacyServiceName;
	private String enableMsgAudit;
	private String soapAction;
	private Integer timeout;
	private String communicatorIn;
	private String communicatorOut;
	private String adapterIn;
	private String authUser;
	private String authPassword;
	private String genCustomHeaders;
	
	public Legacy () {
		super();
	}
	
	public Legacy (Integer legacyRegisterId,Integer legacyApplicationId,String legacyOperationName,Integer adapterId, 
			String xsltIn, String xsltOut,String legacyEndpoint,String enableRetryFlg,Integer retryCount, Integer retryDelay,String legacyServiceName,
			String enableMsgAudit, String soapAction, Integer timeout, String communicatorIn, String communicatorOut, String adapterIn,
			String authUser,String authPassword, String genCustomHeaders ) {
		super();
		this.legacyRegisterId=legacyRegisterId;
		this.legacyApplicationId=legacyApplicationId;
		this.legacyOperationName=legacyOperationName;
		this.adapterId=adapterId;
		this.xsltIn=xsltIn;
		this.xsltOut=xsltOut;
		this.legacyEndpoint=legacyEndpoint;
		this.enableRetryFlg=enableRetryFlg;
		this.retryCount=retryCount;
		this.retryDelay=retryDelay;
		this.legacyServiceName=legacyServiceName;
		this.enableMsgAudit=enableMsgAudit;
		this.soapAction=soapAction;
		this.timeout=timeout;
		this.communicatorIn=communicatorIn;
		this.communicatorOut=communicatorOut;
		this.adapterId=adapterId;
		this.authUser=authUser;
		this.authPassword=authPassword;
		this.genCustomHeaders=genCustomHeaders;
	}
	
	public Integer getLegacyRegisterId() {
		return legacyRegisterId;
	}
	public void setLegacyRegisterId(Integer legacyRegisterId) {
		this.legacyRegisterId = legacyRegisterId;
	}
	public Integer getlegacyApplicationId() {
		return legacyApplicationId;
	}
	public void setlegacyApplicationId(Integer legacyApplicationId) {
		this.legacyApplicationId = legacyApplicationId;
	}
	public String getLegacyOperationName() {
		return legacyOperationName;
	}
	public void setLegacyOperationName(String legacyOperationName) {
		this.legacyOperationName = legacyOperationName;
	}
	public Integer getAdapterId() {
		return adapterId;
	}
	public void setAdapterId(Integer adapterId) {
		this.adapterId = adapterId;
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
	public String getLegacyEndpoint() {
		return legacyEndpoint;
	}
	public void setLegacyEndpoint(String legacyEndpoint) {
		this.legacyEndpoint = legacyEndpoint;
	}
	public String getEnableRetryFlg() {
		return enableRetryFlg;
	}
	public void setEnableRetryFlg(String enableRetryFlg) {
		this.enableRetryFlg = enableRetryFlg;
	}
	public Integer getRetryCount() {
		return retryCount;
	}
	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
	public Integer getRetryDelay() {
		return retryDelay;
	}
	public void setRetryDelay(Integer retryDelay) {
		this.retryDelay = retryDelay;
	}
	public String getLegacyServiceName() {
		return legacyServiceName;
	}
	public void setLegacyServiceName(String legacyServiceName) {
		this.legacyServiceName = legacyServiceName;
	}
	public String getenableMsgAudit() {
		return enableMsgAudit;
	}
	public void setnableMsgAudit(String enableMsgAudit) {
		this.enableMsgAudit = enableMsgAudit;
	}
	public String getSoapAction() {
		return soapAction;
	}
	public void setSoapAction(String soapAction) {
		this.soapAction = soapAction;
	}
	public Integer gettimeout() {
		return timeout;
	}
	public void settimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public String getCommunicatorIn() {
		return communicatorIn;
	}
	public void setCommunicatorIn(String communicatorIn) {
		this.communicatorIn = communicatorIn;
	}
	public String getCommunicatorOut() {
		return communicatorOut;
	}
	public void setCommunicatorOut(String communicatorOut) {
		this.communicatorOut = communicatorOut;
	}
	public String getAdapterIn() {
		return adapterIn;
	}
	public void setAdapterIn(String adapterIn) {
		this.adapterIn = adapterIn;
	}
	public String getAuthUser() {
		return authUser;
	}
	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}
	public String getAuthPassword() {
		return authPassword;
	}
	public void setAuthPassword(String authPassword) {
		this.authPassword = authPassword;
	}
	public String getGenCustomHeaders() {
		return genCustomHeaders;
	}
	public void setGenCustomHeaders(String genCustomHeaders) {
		this.genCustomHeaders = genCustomHeaders;
	}
	
	
}
