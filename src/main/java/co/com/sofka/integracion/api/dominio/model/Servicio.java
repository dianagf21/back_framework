package co.com.sofka.integracion.api.dominio.model;

import java.util.List;

public class Servicio {
	private Receiver receiver;
	private Controller controller;
	private List<Routing> routing;
	
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public List<Routing> getRouting() {
		return routing;
	}
	public void setRouting(List<Routing> routing) {
		this.routing = routing;
	}
	
	
}
