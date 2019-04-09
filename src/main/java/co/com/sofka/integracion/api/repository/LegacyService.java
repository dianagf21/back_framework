package co.com.sofka.integracion.api.repository;

import java.util.List;

import co.com.sofka.integracion.api.dominio.model.Legacy;

public interface LegacyService {
	
	public List<Legacy> getLegacys();
	public Legacy addLegacy(Legacy legacy);
	public Legacy getLegacy(Integer legacyRegisterId);
	public void deleteLegacy(Legacy legacy);
	public Legacy updateLegacy(Legacy legacy);
}
