package tpe.tripms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tpe.tripms.dto.TariffRequestDTO;
import tpe.tripms.dto.TariffResponseDTO;
import tpe.tripms.model.Tariff;
import tpe.tripms.repository.TariffRepository;

@Service("tariffService")
public class TariffService {
	
	@Autowired
	private TariffRepository repository;
	
	@Transactional
	public List<TariffResponseDTO> findAll() {
		return repository.findAll().stream().map( TariffResponseDTO::new ).toList();
	}
	
	@Transactional
	public TariffResponseDTO findById(int id) throws Exception {
		return repository.findById(id)
				.map( TariffResponseDTO::new )
				.orElseThrow(() -> new Exception());
	}
	
	@Transactional
	public TariffResponseDTO saveTariff(TariffRequestDTO request) {
		Tariff tariff = repository.save(new Tariff(request));
		return new TariffResponseDTO(tariff);
	}
	
	@Transactional
	public TariffResponseDTO deleteTariff(int id) throws Exception {
		Optional<Tariff> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return new TariffResponseDTO(optional.get());
		} else {
			throw new Exception();
		}
	}
}
