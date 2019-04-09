package co.com.sofka.integracion.api.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.com.sofka.integracion.api.dominio.model.Controller;
import co.com.sofka.integracion.api.dominio.model.ControllerRepository;
@Service
public class ControllerServiceImpl implements ControllerService{
	
	private final Logger log = LoggerFactory.getLogger(ControllerServiceImpl.class);
	private final ControllerRepository controllerRepository;
	
	public ControllerServiceImpl(ControllerRepository controllerRepository) {
		this.controllerRepository = controllerRepository;
	}
	
	@Override
	public List<Controller> getController(){
		log.debug("Inicio getController");
		List<Controller> controller= controllerRepository.findAll();
		log.debug("Fin getcontroller");
		return controller;
	}
	@Override
	public Controller addController(Controller controller) {
		log.debug("Inicio addcontroller: id = {}", controller);
		return controllerRepository.save(controller);
	}
	@Override
	public Controller getController(Integer controllerId) {
		Optional<Controller> controller= controllerRepository.findAllByControllerId(controllerId);
		
		log.debug("Fin getproyecto: proyecto = {}", controller.get());
		return controller.get();
	}
	@Override
	public Controller updateController(Controller newController) {
		log.debug("Inicio updateController: id = {}", newController);
		return controllerRepository.save(newController);
	}
	@Override
	public void deleteController(Controller controller) {
		log.debug("Inicio deleteController: id = {}", controller);
		controllerRepository.delete(controller);
	}
	
}
