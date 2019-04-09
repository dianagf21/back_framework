package co.com.sofka.integracion.api.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.com.sofka.integracion.api.dominio.model.Aif;
import co.com.sofka.integracion.api.dominio.model.AifRepository;

@Service
public class AifServiceImpl implements AifService{

	private final Logger log = LoggerFactory.getLogger(AifServiceImpl.class);
	private final AifRepository aifRepository;
	
	public AifServiceImpl(AifRepository aifRepository) {
		this.aifRepository=aifRepository;
	}
	public List<Aif> getAifs(){
		log.debug("Inicio getAif");
		List<Aif> aif=aifRepository.findAll();
		return aif;
	}
	
	public Aif addAif(Aif aif) {
		log.debug("Inicio addAif: id = {}", aif);
		return aifRepository.save(aif);
	}
	@Override
	public Aif getAif(Integer aifId) {
		Optional<Aif> aif= aifRepository.findByAifId(aifId);
		
		log.debug("Fin getproyecto: proyecto = {}", aif.get());
		return aif.get();
	}
	@Override
	public Aif updateAif(Aif newAif) {
		log.debug("Inicio updateAif: id = {}", newAif);
		return aifRepository.save(newAif);
	}
	
	@Override
	public void deleteAif(Aif aif) {
		log.debug("Inicio deleteAif: id = {}", aif);
		aifRepository.delete(aif);
	}
}
