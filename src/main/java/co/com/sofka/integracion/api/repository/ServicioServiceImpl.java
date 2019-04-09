package co.com.sofka.integracion.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.com.sofka.integracion.api.dominio.model.Aif;
import co.com.sofka.integracion.api.dominio.model.AifRepository;
import co.com.sofka.integracion.api.dominio.model.Controller;
import co.com.sofka.integracion.api.dominio.model.ControllerAif;
import co.com.sofka.integracion.api.dominio.model.ControllerRepository;
import co.com.sofka.integracion.api.dominio.model.Legacy;
import co.com.sofka.integracion.api.dominio.model.LegacyRepository;
import co.com.sofka.integracion.api.dominio.model.Receiver;
import co.com.sofka.integracion.api.dominio.model.ReceiverRepository;
import co.com.sofka.integracion.api.dominio.model.Routing;
import co.com.sofka.integracion.api.dominio.model.Servicio;

@Service
public class ServicioServiceImpl implements ServicioService {
	//private final Logger log = LoggerFactory.getLogger(ServicioServiceImpl.class);
	
	private final ReceiverRepository receiverRepository;
	private final ControllerRepository controllerRepository;
	private final AifRepository aifRepository;
	private final LegacyRepository legacyRepository;
	private final ControllerAifRepository controllerAifRepository;
	//private final ServicioRepository servicioRepository;
	
	public ServicioServiceImpl(ReceiverRepository receiverRepository, ControllerRepository controllerRepository, AifRepository aifRepository, LegacyRepository legacyRepository, ControllerAifRepository controllerAifRepository) {
		this.receiverRepository = receiverRepository;
		this.controllerRepository=controllerRepository;
		this.aifRepository=aifRepository;
		this.legacyRepository=legacyRepository;
		this.controllerAifRepository=controllerAifRepository;
		//this.servicioRepository=servicioRepository;
	}
		@Override
		public Servicio getReceiverController(Integer receiverId) {
			Optional<Receiver> receiver= receiverRepository.findAllByReceiverId(receiverId);
			Receiver receiverB= receiver.get();
			
			Optional<Controller> controller= controllerRepository.findAllByControllerId(receiverB.getControllerId());
			Controller controllerB=controller.get();
			
			Servicio service=new Servicio();
			service.setReceiver(receiverB);
			service.setController(controllerB);
			
			return(service);
		}
		@Override
		public Servicio getAifLegacy(Integer aifId) {
			Optional<Aif> aif = aifRepository.findByAifId(aifId);
			Aif aifB= aif.get();
			
			Optional<Legacy> legacy= legacyRepository.findByLegacyRegisterId(aifB.getLegacyRegisterId());
			Legacy legacyB=legacy.get();
			
			Servicio service=new Servicio();
			//service.setAif(aifB);
			//service.setLegacy(legacyB);
			
			return(service);
		}
		
		@Override
		public Servicio getServicio(Integer receiverId) {
			Optional<Receiver> receiver= receiverRepository.findAllByReceiverId(receiverId);
			Receiver receiverB= receiver.get();
			
			Optional<Controller> controller= controllerRepository.findAllByControllerId(receiverB.getControllerId());
			Controller controllerB=controller.get();
			
			List<ControllerAif> controllerAif = controllerAifRepository.findAllByControllerId(controllerB.getControllerId());
			
			Servicio service=new Servicio();
			service.setReceiver(receiverB);
			service.setController(controllerB);
			
			List<Routing> routing= new ArrayList<Routing>();
			
			for(int index=0; index<controllerAif.size(); index++ ) {
				
				Optional<Aif> aif = aifRepository.findByAifId(controllerAif.get(index).getAifId());
				Aif aifObject= aif.get();
				
				Optional<Legacy> legacy= legacyRepository.findByLegacyRegisterId(aifObject.getLegacyRegisterId());
				Legacy legacyObject=legacy.get();
			
				Routing routingB= new Routing();
				routingB.setAif(aifObject);
				routingB.setLegacy(legacyObject);
				
				routing.add(routingB);
			}
			
			service.setRouting(routing);
			
			return(service);
		}
	}

