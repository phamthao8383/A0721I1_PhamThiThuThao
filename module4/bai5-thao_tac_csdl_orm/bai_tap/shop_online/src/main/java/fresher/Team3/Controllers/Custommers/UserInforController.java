package fresher.Team3.Controllers.Custommers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fresher.Team3.Controllers.BaseController;
import fresher.Team3.Repository.OrderRepository;


@Controller
public class UserInforController extends BaseController {
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping(value = { "/Home/UserInfor" }, method = RequestMethod.GET)
	public String viewUserInfor(Model model) {
		model.addAttribute("orders", orderRepository.findByUserId(userLoginedIsEnity().getId()));
		System.out.println(orderRepository.findByUserId(userLoginedIsEnity().getId()).size());
		return "Custommers/UserInfor";
	}

}
