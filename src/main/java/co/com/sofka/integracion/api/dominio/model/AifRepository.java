package co.com.sofka.integracion.api.dominio.model;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.com.sofka.integracion.api.dominio.model.Aif;

@Repository
public interface AifRepository extends JpaRepository<Aif, String> {
	
	//public List<Aif> findAllByAifId(Integer aifId);
	
	public Optional<Aif> findByAifId(Integer aifId);
}
