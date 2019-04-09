package co.com.sofka.integracion.api.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.com.sofka.integracion.api.dominio.model.Receiver;
import co.com.sofka.integracion.api.dominio.model.ReceiverRepository;

@Service
public class ReceiverServiceImpl implements ReceiverService{

private final Logger log = LoggerFactory.getLogger(ReceiverServiceImpl.class);
	

	private final ReceiverRepository receiverRepository;
	//private final ServicioRepository servicioRepository;

	public ReceiverServiceImpl(ReceiverRepository receiverRepository) {
		this.receiverRepository = receiverRepository;
	}
	
	@Override
	public List<Receiver> getReceivers(){
		log.debug("Inicio getReceiver");
		List<Receiver> receiver= receiverRepository.findAll();
		log.debug("Fin getReceiver");
		return receiver;
	}
	@Override
	public Receiver addReceiver(Receiver receiver) {
		log.debug("Inicio addReceiver: id = {}", receiver);
		return receiverRepository.save(receiver);
	}
	@Override
	public void deleteReceiver(Receiver receiver) {
		log.debug("Inicio deleteReceiver: id = {}", receiver);
		receiverRepository.delete(receiver);
	}
	
	@Override
	public Receiver getReceiver(Integer receiverId) {
		Optional<Receiver> receiver= receiverRepository.findAllByReceiverId(receiverId);
		
		log.debug("Fin getReceiver: Receiver = {}", receiver.get());
		return receiver.get();
	}
	
	@Override
	public Receiver updateReceiver(Receiver newReceiver) {
		log.debug("Inicio updateReceiver: id = {}", newReceiver);
		return receiverRepository.save(newReceiver);
	}
	
	
}
