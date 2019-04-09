package co.com.sofka.integracion.api.dominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WMB_FW_CONTROLLER_MST")
public class Controller {
	
	@Id
	private Integer controllerId;
	private String controllerCode;
	private String controllerEndpoint;
	private String controllerDesc;
	private String isDefault;
	
	public Controller() {
		super();
	}
	
	public Controller(Integer controllerId,String controllerCode,String controllerEndpoint,String controllerDesc,String isDefault) {
		super();
		this.controllerId=controllerId;
		this.controllerCode=controllerCode;
		this.controllerEndpoint=controllerEndpoint;
		this.controllerDesc=controllerDesc;
		this.isDefault=isDefault;
	}
	
	public Integer getControllerId() {
		return controllerId;
	}
	public void setControllerId(Integer controllerId) {
		this.controllerId = controllerId;
	}
	public String getControllerCode() {
		return controllerCode;
	}
	public void setControllerCode(String controllerCode) {
		this.controllerCode = controllerCode;
	}
	public String getControllerEndpoint() {
		return controllerEndpoint;
	}
	public void setControllerEndpoint(String controllerEndpoint) {
		this.controllerEndpoint = controllerEndpoint;
	}
	public String getControllerDesc() {
		return controllerDesc;
	}
	public void setControllerDesc(String controllerDesc) {
		this.controllerDesc = controllerDesc;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	
	
}
