package fresher.Team3.Controllers.Custommers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fresher.Team3.Controllers.BaseController;
import fresher.Team3.Repository.ProductsRepository;


@Controller
public class HomeController extends BaseController {
	
	
	@Autowired
	private ProductsRepository productsRepository;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String viewHome(Model model) {
		Pageable pageable = PageRequest.of(0, 6,new Sort(Direction.DESC, "avg_rating"));
		model.addAttribute("products", productsRepository.findAllProduct(pageable));
		return "Custommers/Home";
	}
	@GetMapping("/403")
	public String accessDenied1() {
		return "redirect:/index";
	}
}
