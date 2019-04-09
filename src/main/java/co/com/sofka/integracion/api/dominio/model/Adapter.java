package co.com.sofka.integracion.api.dominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WMB_FW_ADAPTER_MST")
public class Adapter {
	@Id
	private Integer adapterId;
	private String adapterCode;
	private String adapterDesc;
	private String adapterEndpoint;
	private String adapterDefCommunicatorIn;
	private String adapterDefCommunicatorOut;
	
	public Integer getAdapterId() {
		return adapterId;
	}
	public void setAdapterId(Integer adapterId) {
		this.adapterId = adapterId;
	}
	public String getAdapterCode() {
		return adapterCode;
	}
	public void setAdapterCode(String adapterCode) {
		this.adapterCode = adapterCode;
	}
	public String getAdapterDesc() {
		return adapterDesc;
	}
	public void setAdapterDesc(String adapterDesc) {
		this.adapterDesc = adapterDesc;
	}
	public String getAdapterEndpoint() {
		return adapterEndpoint;
	}
	public void setAdapterEndpoint(String adapterEndpoint) {
		this.adapterEndpoint = adapterEndpoint;
	}
	public String getAdapterDefCommunicatorIn() {
		return adapterDefCommunicatorIn;
	}
	public void setAdapterDefCommunicatorIn(String adapterDefCommunicatorIn) {
		this.adapterDefCommunicatorIn = adapterDefCommunicatorIn;
	}
	public String getAdapterDefCommunicatorOut() {
		return adapterDefCommunicatorOut;
	}
	public void setAdapterDefCommunicatorOut(String adapterDefCommunicatorOut) {
		this.adapterDefCommunicatorOut = adapterDefCommunicatorOut;
	}
	
	
}
