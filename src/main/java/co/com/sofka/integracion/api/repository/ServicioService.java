package co.com.sofka.integracion.api.repository;

import java.util.List;

import co.com.sofka.integracion.api.dominio.model.Aif;
import co.com.sofka.integracion.api.dominio.model.Controller;
import co.com.sofka.integracion.api.dominio.model.ControllerAif;
import co.com.sofka.integracion.api.dominio.model.Legacy;
import co.com.sofka.integracion.api.dominio.model.Receiver;
import co.com.sofka.integracion.api.dominio.model.Servicio;

public interface ServicioService {
	//public ControllerAif getControllerAif(Integer controller);
	public Servicio getReceiverController(Integer receiverId);
	
	
	public Servicio getAifLegacy(Integer aifId);
	
	public Servicio getServicio(Integer receiverId);
	
	public Servicio addServicio(Legacy legacy, Aif aif, Controller controller,Receiver receiver);

}
