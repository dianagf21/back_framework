package co.com.sofka.integracion.api.repository;

import java.util.List;

import co.com.sofka.integracion.api.dominio.model.Servicio;

public interface ServicioService {
	//public ControllerAif getControllerAif(Integer controller);
	public Servicio getReceiverController(Integer receiverId);
	
	
	public Servicio getAifLegacy(Integer aifId);
	
	public Servicio getServicio(Integer receiverId);
	

}
