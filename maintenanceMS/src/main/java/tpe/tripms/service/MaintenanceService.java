package tpe.tripms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import jakarta.validation.Valid;
import tpe.tripms.dto.DTOMaintenanceRequest;
import tpe.tripms.dto.DTOMaintenanceResponse;
import tpe.tripms.dto.DTOScooterResponse;
import tpe.tripms.dto.DTOScooterStatusRequest;
import tpe.tripms.model.Maintenance;
import tpe.tripms.repository.MaintenanceRepository;

@Service("maintenanceService")
public class MaintenanceService {
	
	@Autowired
	private MaintenanceRepository repository; 
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Transactional
	public DTOScooterResponse updateScooterStatus(long idScooter, DTOScooterStatusRequest request) throws WebClientResponseException {
		DTOScooterResponse scooter = webClientBuilder.build()
			.put()
			.uri("http://localhost:8002/scooter/" + idScooter + "/status")
			.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.body(BodyInserters.fromValue(request))
			.retrieve()
			.bodyToMono(DTOScooterResponse.class)
			.block();
		return scooter;
	}
	
	@Transactional ( readOnly = true )
	public List<DTOMaintenanceResponse> findAll() throws Exception {
		try {
			return repository.findAll().stream().map( DTOMaintenanceResponse::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public DTOMaintenanceResponse save(@Valid DTOMaintenanceRequest request) throws Exception {
		try {
			Maintenance maintenance = new Maintenance(request.getId(), request.getDescription(),request.getStartDate(),request.getFinishDate(),request.getIdScooter());
			maintenance = repository.save(maintenance);
			return new DTOMaintenanceResponse(maintenance);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional ( readOnly = true )
	public DTOMaintenanceResponse getMaintenanceById(long id) throws Exception {
		try {
			return new DTOMaintenanceResponse(repository.getMaintenanceById(id));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional ( readOnly = true )
	public List<DTOMaintenanceResponse> getMaintenancesBySimpleOrdering() throws Exception {
		try {
			return repository.getMaintenancesBySimpleOrdering().stream().map( DTOMaintenanceResponse::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
