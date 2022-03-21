package fresher.Team3.Controllers.Admin;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fresher.Team3.Controllers.BaseController;

import fresher.Team3.Enities.OrdersEnity;
import fresher.Team3.Repository.OrderRepository;
import fresher.Team3.Services.OrderService;

@Controller
public class OrdersController extends BaseController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

//	@RequestMapping(value = "/Admin/Order", method = RequestMethod.GET)
//	public String index(Model model) {
//		List<OrdersEnity> order = orderService.getAllOrder();
//		
//		order.get(0).getOrderDetailsEnities();
//		
//		model.addAttribute("order", order);
//		return "Admin/Order/HomeOrder";
//	}
	////////
	// Page phân trang ........................................
	////////////////////////////////////////////////////////////
//	@RequestMapping(value = "/Admin/Order", method = RequestMethod.GET)
//	public String index(Model model, HttpServletRequest request, @RequestParam("pageId") Optional<Integer> pageId) {
//		Pageable pageable = PageRequest.of(pageId.orElse(1) - 1, 2);
//		model.addAttribute("order", orderRepository.findOrder(pageable));
//		System.out.println(orderRepository.findOrder(pageable).getTotalPages());
//
//		return "Admin/Order/HomeOrder";
//	}

	////////////////////////////////////////////////
	////// Search...........................
	///////////////////////////////////////////
//	@RequestMapping(value = "/Admin/Order")
//	public String viewOrderSearch(Model model, @Param("date") Date date) {
//		List<OrdersEnity> listOrder = orderService.SearchOrder(date);
//		model.addAttribute("listProducts", listOrder);
//		model.addAttribute("date", date);
//
//		return "Admin/Order/HomeOrder";
//	}

	@RequestMapping(value = "/Admin/Order", method = RequestMethod.GET)

	public String index(Model model, HttpServletRequest request, @RequestParam("pageId") Optional<Integer> pageId,
			@Param("date") String date) {
		if(date =="") {
			date = null;
		}
		Pageable pageable = PageRequest.of(pageId.orElse(1) - 1, 6);
		model.addAttribute("order", orderService.getAllOrder(pageable,date));

		model.addAttribute("date", date);
		return "Admin/Order/HomeOrder";
	}

	@RequestMapping(value = "/Admin/Order/add", method = RequestMethod.GET)
	public String addOrder(Model model) {
		model.addAttribute("order", new OrdersEnity());
		return "Admin/Order/AddUpdateOrder";
	}

	@RequestMapping(value = "/Admin/Order/edit", method = RequestMethod.GET)
	public String editOrder(@RequestParam("id") Integer orderId, Model model) {

		Optional<OrdersEnity> orderEdit = orderService.findOrderById(orderId);
		orderEdit.ifPresent(order -> model.addAttribute("order", order));

		return "Admin/Order/AddUpdateOrder";
	}

	@RequestMapping(value = "/Admin/Order/Save", method = RequestMethod.POST)
	public String save(OrdersEnity order) {
		orderService.saveOrder(order);
		return "redirect:/Admin/Order";
	}

	@RequestMapping(value = "/Admin/Order/delete", method = RequestMethod.GET)
	public String deleteOrder(@RequestParam("id") Integer orderId, Model model) {
		orderService.deleteOrder(orderId);
		return "redirect:/Admin/Order";
	}
	@RequestMapping(value = "/Admin/Order/Set", method = RequestMethod.GET)
	public String getDetailsSet(Model model, @RequestParam("id") Integer orderId) {

		
		Optional<OrdersEnity> ordersEnities = orderService.findOrderById(orderId);
		ordersEnities.get().setStatus(1);
		ordersEnities.get().setUpdatedDate(dateNow());
		orderRepository.save(ordersEnities.get());

		return "redirect:/Admin/Order";
	}

}
