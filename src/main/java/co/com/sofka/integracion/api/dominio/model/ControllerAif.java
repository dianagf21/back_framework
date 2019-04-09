package co.com.sofka.integracion.api.dominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WMB_FW_CONTROLLER_AIF_MST")
public class ControllerAif {
	@Id
	private Integer controllerAifId;
	private Integer controllerId;
	private Integer aifId;
	
	public Integer getControllerAifId() {
		return controllerAifId;
	}
	public void setControllerAifId(Integer controllerAifId) {
		this.controllerAifId = controllerAifId;
	}
	public Integer getControllerId() {
		return controllerId;
	}
	public void setControllerId(Integer controllerId) {
		this.controllerId = controllerId;
	}
	public Integer getAifId() {
		return aifId;
	}
	public void setAifId(Integer aifId) {
		this.aifId = aifId;
	}
	
}
