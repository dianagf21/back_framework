package co.com.sofka.integracion.api.dominio.model;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.com.sofka.integracion.api.dominio.model.Receiver;

@Repository

public interface ReceiverRepository extends JpaRepository<Receiver, String>{
	
	//public List<Receiver> findByIdReceiver(Integer receiverId);
	public Optional<Receiver> findAllByReceiverId(Integer receiverId);
	//public Optional<ControllerAif> findByControllerId(Integer controllerId);
}
