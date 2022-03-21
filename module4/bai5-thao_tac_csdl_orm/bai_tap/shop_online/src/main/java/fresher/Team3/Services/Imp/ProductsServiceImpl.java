package fresher.Team3.Services.Imp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import fresher.Team3.Confs.LinkUpLoadFile;
import fresher.Team3.Enities.ProductImagesEnity;
import fresher.Team3.Enities.ProductsEnity;
import fresher.Team3.Repository.ProductImagesRepository;
import fresher.Team3.Repository.ProductsRepository;
import fresher.Team3.Services.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsRepository productsRepository;

	

	@Autowired
	private ProductImagesRepository productImagesRepository;

	@Override
	public List<ProductsEnity> getAllProductsEnities() {
		// TODO Auto-generated method stub
		return (List<ProductsEnity>) productsRepository.findAll();
	}

	@Override
	public void saveProduct(ProductsEnity productsEnity) {
		// TODO Auto-generated method stub
		productsRepository.save(productsEnity);

	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		productsRepository.deleteById(id);

	}

	@Override
	public Optional<ProductsEnity> findProductById(Integer id) {
		// TODO Auto-generated method stub
		return productsRepository.findById(id);
	}

	@Override
	public List<ProductsEnity> search(Integer id) {
		// TODO Auto-generated method stub
		return productsRepository.searchCategoryId(id);
	}

	@Override
	public ProductsEnity addFile(ProductsEnity productsEnity, MultipartFile productAvatar,
			MultipartFile[] productPictures) throws IllegalStateException, IOException {
		if (!isEmptyUpLoadFile(productAvatar)) {
			String pathToFile = LinkUpLoadFile.linkUpLoad + "/products/avatars/"
					+ productAvatar.getOriginalFilename();
			productAvatar.transferTo(new File(pathToFile));
			productsEnity.setAvatar("/products/avatars/" + productAvatar.getOriginalFilename());
		}
		if (!isEmptyUpLoadFile(productPictures)) {
			for (MultipartFile pic : productPictures) {
				pic.transferTo(
						new File(LinkUpLoadFile.linkUpLoad + "/products/pictures/" + pic.getOriginalFilename()));
				ProductImagesEnity productImagesEnity = new ProductImagesEnity();
				productImagesEnity.setPath("/product/pictures/" + pic.getOriginalFilename());
				productImagesEnity.setName(pic.getOriginalFilename());
				productImagesEnity.setProductsEnity(productsEnity);
				productsEnity.getProductImagesEnities().add(productImagesEnity);

			}
		}
		return productsRepository.save(productsEnity);
	}
	@Override
	@Transactional
	public ProductsEnity updateFile(ProductsEnity productsEnity, MultipartFile productAvatar,
			MultipartFile[] productPictures) throws IllegalStateException, IOException {

		Optional<ProductsEnity> productInDb = productsRepository.findById(productsEnity.getId());

		if (!isEmptyUpLoadFile(productAvatar)) {

			new File(LinkUpLoadFile.linkUpLoad  + productInDb.get().getAvatar()).delete();

			productAvatar.transferTo(new File(
					LinkUpLoadFile.linkUpLoad + "/products/avatars/" + productAvatar.getOriginalFilename()));
			productsEnity.setAvatar("/products/avatars/" + productAvatar.getOriginalFilename());
		} else {

			productsEnity.setAvatar(productInDb.get().getAvatar());
		}

		if (!isEmptyUpLoadFile(productPictures)) {
			if (productInDb.get().getProductImagesEnities() != null
					&& productInDb.get().getProductImagesEnities().size() > 0) {
				for (ProductImagesEnity opi : productInDb.get().getProductImagesEnities()) {
					new File(LinkUpLoadFile.linkUpLoad + opi.getPath()).delete();
					productImagesRepository.delete(opi);
				}
			}

			for (MultipartFile pic : productPictures) {
				pic.transferTo(
						new File(LinkUpLoadFile.linkUpLoad + "/products/pictures/" + pic.getOriginalFilename()));
				ProductImagesEnity productImagesEnity = new ProductImagesEnity();
				productImagesEnity.setPath("/products/pictures/" + pic.getOriginalFilename());
				productImagesEnity.setName(pic.getOriginalFilename());
				productImagesEnity.setProductsEnity(productsEnity);
				productsEnity.getProductImagesEnities().add(productImagesEnity);

			}
		}
		return productsRepository.save(productsEnity);

	}

	private boolean isEmptyUpLoadFile(MultipartFile[] images) {
		if (images == null || images.length <= 0)
			return true;
		if (images.length == 1 && images[0].getOriginalFilename().isEmpty())
			return true;
		return false;
	}

	private boolean isEmptyUpLoadFile(MultipartFile image) {
		return image == null || image.getOriginalFilename().isEmpty();
	}

}
