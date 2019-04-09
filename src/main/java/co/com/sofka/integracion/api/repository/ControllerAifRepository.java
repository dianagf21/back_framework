package co.com.sofka.integracion.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import co.com.sofka.integracion.api.dominio.model.ControllerAif;

public interface ControllerAifRepository extends JpaRepository<ControllerAif, String>{
	public List<ControllerAif> findAllByControllerId(Integer controllerId);
	
}
