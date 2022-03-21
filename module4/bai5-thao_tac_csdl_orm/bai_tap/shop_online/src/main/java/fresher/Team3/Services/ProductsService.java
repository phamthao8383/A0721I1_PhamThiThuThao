package fresher.Team3.Services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.h2.mvstore.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fresher.Team3.Enities.ProductsEnity;

@Service
public interface ProductsService {
	List<ProductsEnity> getAllProductsEnities();  

	  void saveProduct(ProductsEnity productsEnity);  

	  void deleteProduct(Integer id);  

	  Optional<ProductsEnity> findProductById(Integer id);  
	  
	  List<ProductsEnity> search(Integer id);
	  ProductsEnity addFile(ProductsEnity productsEnity ,MultipartFile productAvatar , MultipartFile[] productPictures) throws IllegalStateException, IOException;
	  ProductsEnity updateFile(ProductsEnity productsEnity ,MultipartFile productAvatar , MultipartFile[] productPictures) throws IllegalStateException, IOException;
	  
		
	

}
