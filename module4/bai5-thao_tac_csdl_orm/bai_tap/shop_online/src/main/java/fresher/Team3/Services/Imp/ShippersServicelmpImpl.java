package fresher.Team3.Services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fresher.Team3.Enities.ShipperEnity;
import fresher.Team3.Repository.ShippersRepository;
import fresher.Team3.Services.ShipperService;

@Service
public class ShippersServicelmpImpl implements ShipperService {
	@Autowired
	private ShippersRepository shippersRepository;
	
	@Override
	public List<ShipperEnity> getAllShipper() {
		 return (List<ShipperEnity>) shippersRepository.findAll();  
	}

	@Override
	public void saveShiper(ShipperEnity shiper) {
		shippersRepository.save(shiper); 
		
	}

	@Override
	public void deleteShiper(Integer id) {
		shippersRepository.deleteById(id); 
		
	}

	@Override
	public Optional<ShipperEnity> findShiperById(Integer id) {
		return shippersRepository.findById(id); 
	}

}
