package co.com.sofka.integracion.api.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.com.sofka.integracion.api.dominio.model.Legacy;
import co.com.sofka.integracion.api.dominio.model.LegacyRepository;

@Service
public class LegacyServiceImpl implements LegacyService {
	private final Logger log = LoggerFactory.getLogger(LegacyServiceImpl.class);
	
	private final LegacyRepository legacyRepository;
	
	public LegacyServiceImpl(LegacyRepository legacyRepository ) {
		this.legacyRepository=legacyRepository;
	}
	@Override
	public List<Legacy> getLegacys(){
		log.debug("Inicio getLegacy");
		List<Legacy> legacy= legacyRepository.findAll();
		log.debug("Fin getLegacy");
		return legacy;
	}
	@Override
	public Legacy addLegacy(Legacy legacy) {
		log.debug("Inicio addLegacy: id = {}", legacy);
		return legacyRepository.save(legacy);
	}
	@Override
	public Legacy getLegacy(Integer legacyRegisterId) {
		Optional<Legacy> legacy= legacyRepository.findByLegacyRegisterId(legacyRegisterId);
		
		log.debug("Fin getLegacy: Legacy = {}", legacy.get());
		return legacy.get();
	}
	@Override
	public void deleteLegacy(Legacy legacy) {
		log.debug("Inicio deleteLegacy: id = {}", legacy);
		legacyRepository.delete(legacy);
	}
	@Override
	public Legacy updateLegacy(Legacy newLegacy) {
		log.debug("Inicio updateReceiver: id = {}", newLegacy);
		return legacyRepository.save(newLegacy);
	}
	
}
