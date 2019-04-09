package co.com.sofka.integracion.api.dominio.model;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegacyRepository extends JpaRepository<Legacy, String>{
	
	public Optional<Legacy> findByLegacyRegisterId(Integer legacyRegisterId);
	
	//public List<Legacy> findAllByLegacyRegisterId(Integer legacyRegisterId);
}
