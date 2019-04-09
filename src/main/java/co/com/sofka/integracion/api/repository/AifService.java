package co.com.sofka.integracion.api.repository;

import java.util.List;

import co.com.sofka.integracion.api.dominio.model.Aif;

public  interface AifService {
	public List<Aif> getAifs();
	public Aif addAif(Aif aif);	
	public Aif getAif(Integer aifId);	
	public Aif updateAif(Aif Aif);
	public void  deleteAif(Aif aif);
	
}
