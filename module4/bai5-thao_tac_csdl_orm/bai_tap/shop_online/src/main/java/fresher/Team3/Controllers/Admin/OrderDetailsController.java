package fresher.Team3.Controllers.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fresher.Team3.Enities.OrderDetailsEnity;
import fresher.Team3.Enities.OrdersEnity;

import fresher.Team3.Services.OrderDetailsService;
import fresher.Team3.Services.OrderService;

@Controller
public class OrderDetailsController {
	@Autowired
	private OrderDetailsService orderDetailsService;
	@Autowired
	private OrderService orderService;
	

	@RequestMapping(value = "/Admin/Order/Details", method = RequestMethod.GET)
	public String getDetails(Model model, @RequestParam("id") Integer orderId) {

		List<OrderDetailsEnity> orderDetails = orderDetailsService.FindByOrderId(orderId);
		Optional<OrdersEnity> ordersEnities = orderService.findOrderById(orderId);
		model.addAttribute("ordersEnities", ordersEnities);
		model.addAttribute("orderDetails", orderDetails);
		return "Admin/Order/OrderDetails";
	}
	

	
	

}
