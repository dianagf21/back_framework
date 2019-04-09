package co.com.sofka.integracion.api.dominio.model;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.com.sofka.integracion.api.dominio.model.Controller;

@Repository
public interface ControllerRepository extends JpaRepository<Controller, String>{
	
		public Optional<Controller> findAllByControllerId(Integer ControllerId);
	
}
