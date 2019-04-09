package co.com.sofka.integracion.api.dominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WMB_FW_AIF_MST")
public class Aif {
	@Id
	private Integer aifId;
	private String aifCode;
	private String aifDesc;
	private String aifImplEndpoint;
	private Integer legacyRegisterId;
	private String isDefault;
	
	public Aif() {
		super();
	}
	
	public Aif(Integer aifId,String aifCode, String aifDesc, String aifImplEndpoint,Integer legacyRegisterId,String isDefault) {
		this.aifId=aifId;
		this.aifCode=aifCode;
		this.aifDesc=aifDesc;
		this.aifImplEndpoint=aifImplEndpoint;
		this.legacyRegisterId=legacyRegisterId;
		this.isDefault=isDefault;
	}
	
	public Integer getAifId() {
		return aifId;
	}
	public void setAifId(Integer aifId) {
		this.aifId = aifId;
	}
	public String getAifCode() {
		return aifCode;
	}
	public void setAifCode(String aifCode) {
		this.aifCode = aifCode;
	}
	public String getAifDesc() {
		return aifDesc;
	}
	public void setAifDesc(String aifDesc) {
		this.aifDesc = aifDesc;
	}
	public String getAifImplEndpoint() {
		return aifImplEndpoint;
	}
	public void setAifImplEndpoint(String aifImplEndpoint) {
		this.aifImplEndpoint = aifImplEndpoint;
	}
	public Integer getLegacyRegisterId() {
		return legacyRegisterId;
	}
	public void setLegacyRegisterId(Integer legacyRegisterId) {
		this.legacyRegisterId = legacyRegisterId;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	
	
}
