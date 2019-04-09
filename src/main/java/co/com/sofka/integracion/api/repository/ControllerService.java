package co.com.sofka.integracion.api.repository;

import java.util.List;
import co.com.sofka.integracion.api.dominio.model.Controller;
public interface ControllerService {
	
	public List<Controller> getController();
	public Controller addController(Controller controller);
	
	public Controller getController(Integer controllerId);
	
	public Controller updateController(Controller controller);
	public void  deleteController(Controller controller);
	
}
