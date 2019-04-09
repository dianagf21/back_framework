package co.com.sofka.integracion.api.repository;

import java.util.List;

import co.com.sofka.integracion.api.dominio.model.Receiver;



public interface ReceiverService {
	
	public List<Receiver> getReceivers();
	
	public Receiver addReceiver(Receiver receiver);
	
	//public Receiver searchReceiver(Integer receiverId );
	
	public Receiver getReceiver(Integer receiverId);

	public void deleteReceiver(Receiver receiver);
	
	public Receiver updateReceiver(Receiver receiver);
	
}

