package fresher.Team3.Services.Imp;

import org.springframework.beans.factory.annotation.Autowired;

import fresher.Team3.Repository.ProductImagesRepository;
import fresher.Team3.Services.ProductImagesService;

public class ProductImagesServiceImp implements ProductImagesService {
	@Autowired
	private ProductImagesRepository productImagesRepository; 

	@Override
	public void deleteProductImage(Integer id) {
		productImagesRepository.deleteById(id);
		
	}

}
