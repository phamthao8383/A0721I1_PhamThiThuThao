package fresher.Team3.Controllers.Custommers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import fresher.Team3.Confs.LinkUpLoadFile;
import fresher.Team3.Controllers.BaseController;

import fresher.Team3.DTO.ReviewDTO;
import fresher.Team3.Enities.OrderDetailsEnity;
import fresher.Team3.Enities.ProductsEnity;
import fresher.Team3.Enities.ReviewsEnity;
import fresher.Team3.Enities.UsersEnity;
import fresher.Team3.Repository.OrderDetailsRepository;
import fresher.Team3.Repository.ProductsRepository;
import fresher.Team3.Repository.ReviewsRepository;
import fresher.Team3.Repository.UserRepository;

@Controller
public class ProductsController extends BaseController {
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	UserRepository userRepository;

	@Autowired
	ReviewsRepository reviewsRepository;
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@RequestMapping(value = { "/Home/ProductDetail" }, method = RequestMethod.GET)
	public String viewProductDetail(Model model, @RequestParam("id") Integer id , HttpServletRequest request) {
		Optional<ProductsEnity> productsEnity = productsRepository.findById(id);
		model.addAttribute("product", productsEnity.get());

		List<OrderDetailsEnity> orderDetailsEnities = (List<OrderDetailsEnity>) orderDetailsRepository.findAll();
		List<ReviewsEnity> reviewsEnities = (List<ReviewsEnity>) reviewsRepository.findAll();
		boolean isEmty = false;
		if(userLoginedIsEnity() != null) {
			for (OrderDetailsEnity o : orderDetailsEnities) {
				if (o.getProductsEnityOrderDetails().getId() == productsEnity.get().getId()
						&& o.getOrdersEnityOrderDetails().getUsersEnityOrders().getId() == userLoginedIsEnity().getId()  ) {
					isEmty = true;
					break;
				}
			}
			for (ReviewsEnity r : reviewsEnities ) {
				if(r.getUsersEnityReviews().getId() == userLoginedIsEnity().getId()&&r.getProductsEnityReviews().getId() == productsEnity.get().getId()) {
					isEmty = false;
				}
			}
		}
		if (isEmty == true) {
			model.addAttribute("isCheck", true);
		} else {
			model.addAttribute("isCheck", false);
		}		
		
		  System.out.println(request.getRequestURL().toString()+
		  request.getQueryString());
		 
		return "Custommers/ProductDetail";
	}

	public float tbRate(Integer id) {
		Iterable<ReviewsEnity> reviewsEnities = new ArrayList<ReviewsEnity>();
		reviewsEnities = reviewsRepository.findAll();
		float tol = 0;
		int dem = 0;
		for (ReviewsEnity reviewsEnity : reviewsEnities) {
			if (reviewsEnity.getProductsEnityReviews().getId() == id) {
				tol = tol + reviewsEnity.getRate();
				dem++;
			}
		}
		return tol / dem;

	}

	@RequestMapping(value = { "/Home/add/ReviewAjax" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_Review(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, @RequestBody ReviewDTO reviewDTO) throws IOException {
		if (getUserLogined() == null) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		UsersEnity usersEnity = userRepository.findByEmail(getUserLogined().getUsername());
		ReviewsEnity reviewsEnity = new ReviewsEnity();
		reviewsEnity.setUsersEnityReviews(usersEnity);
		reviewsEnity.setContent(reviewDTO.getContent());
		Optional<ProductsEnity> productsEnity = productsRepository.findById(reviewDTO.getProductId());
		reviewsEnity.setProductsEnityReviews(productsEnity.get());
		reviewsEnity.setRate(reviewDTO.getRate());
		reviewsEnity.setCreatedDate(dateNow());
		reviewsEnity.setUpdatedDate(dateNow());
		reviewsRepository.save(reviewsEnity);
		productsEnity.get().setAvgRating(BigDecimal.valueOf(tbRate(reviewDTO.getProductId())));
		productsRepository.save(productsEnity.get());
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("data", reviewsEnity);
		jsonResult.put("email", reviewsEnity.getUsersEnityReviews().getEmail());
		return ResponseEntity.ok(jsonResult);
	}

	@RequestMapping(value = { "/Home/Products/Ajax" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_ViewProducts(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, @RequestParam("pageId") Optional<Integer> pageId ,@RequestParam ("search") String search) throws IOException {
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		Pageable pageable = PageRequest.of(pageId.orElse(1) - 1, 6);
		if(!search.isEmpty()||search != "") {
			model.addAttribute("products", productsRepository.findByAllColumns(search, pageable).getContent());
			jsonResult.put("data", productsRepository.findByAllColumns(search, pageable).getContent());
			jsonResult.put("sizeOfPage", productsRepository.findByAllColumns(search, pageable).getNumberOfElements());
			jsonResult.put("link", LinkUpLoadFile.linkUpLoad);
			jsonResult.put("id", productsRepository.findByAllColumns(search, pageable).getContent());
			jsonResult.put("page", pageId);
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
			
		}
		else {
			model.addAttribute("products", productsRepository.findAllProduct(pageable).getContent());
			jsonResult.put("data", productsRepository.findAllProduct(pageable).getContent());
			jsonResult.put("sizeOfPage", productsRepository.findAllProduct(pageable).getNumberOfElements());
			jsonResult.put("link", LinkUpLoadFile.linkUpLoad);
			jsonResult.put("id", productsRepository.findAllProduct(pageable).getContent());
			jsonResult.put("page", pageId);
			System.out.println("============================================");
		}
		
		return ResponseEntity.ok(jsonResult);
	}

	@RequestMapping(value = { "/Home/Products" }, method = RequestMethod.GET)
	public String viewProductList(Model model ) {
			
		model.addAttribute("search",null);
			Pageable pageable = PageRequest.of(0, 6);
			model.addAttribute("products", productsRepository.findAllProduct(pageable));	
		
		return "Custommers/ProductList";
	}
	
	@RequestMapping(value = { "/Home/Products/Find" }, method = RequestMethod.GET)
	public String viewProductListFind(Model model , @RequestParam ("search") String search) {
		if (search == null) {
			Pageable pageable = PageRequest.of(0, 6);
			model.addAttribute("products", productsRepository.findAllProduct(pageable));	
		}
		else {
			model.addAttribute("search",search);
			Pageable pageable = PageRequest.of(0, 6);
			model.addAttribute("products", productsRepository.findByAllColumns(search, pageable));	
		}
			
		
		return "Custommers/ProductList";

	}
}
