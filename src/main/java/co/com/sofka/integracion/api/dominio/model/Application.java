package co.com.sofka.integracion.api.dominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WMB_FW_APPLICATION_MST")
public class Application {
	@Id
	private Integer applicationId;
	private String applicationCode;
	private String applicationDesc;
	private Integer defSuccessCode;
	private String defSuccessDesc;
	private Integer defErrorCode;
	private String defErrorDesc;
	
	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicationCode() {
		return applicationCode;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
	public String getApplicationDesc() {
		return applicationDesc;
	}
	public void setApplicationDesc(String applicationDesc) {
		this.applicationDesc = applicationDesc;
	}
	public Integer getDefSuccessCode() {
		return defSuccessCode;
	}
	public void setDefSuccessCode(Integer defSuccessCode) {
		this.defSuccessCode = defSuccessCode;
	}
	public String getDefSuccessDesc() {
		return defSuccessDesc;
	}
	public void setDefSuccessDesc(String defSuccessDesc) {
		this.defSuccessDesc = defSuccessDesc;
	}
	public Integer getDefErrorCode() {
		return defErrorCode;
	}
	public void setDefErrorCode(Integer defErrorCode) {
		this.defErrorCode = defErrorCode;
	}
	public String getDefErrorDesc() {
		return defErrorDesc;
	}
	public void setDefErrorDesc(String defErrorDesc) {
		this.defErrorDesc = defErrorDesc;
	}
	
	
}
