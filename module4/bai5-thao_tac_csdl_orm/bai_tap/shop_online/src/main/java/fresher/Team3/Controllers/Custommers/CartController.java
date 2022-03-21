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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fresher.Team3.Controllers.BaseController;
import fresher.Team3.DTO.Cart;
import fresher.Team3.DTO.CartItem;
import fresher.Team3.Enities.ContactsEnity;
import fresher.Team3.Enities.OrderDetailsEnity;
import fresher.Team3.Enities.OrdersEnity;
import fresher.Team3.Enities.ProductsEnity;
import fresher.Team3.Enities.ShipperEnity;
import fresher.Team3.Enities.UsersEnity;
import fresher.Team3.Repository.ContactRepository;
import fresher.Team3.Repository.OrderDetailsRepository;
import fresher.Team3.Repository.OrderRepository;
import fresher.Team3.Repository.ProductsRepository;
import fresher.Team3.Repository.ShippersRepository;
import fresher.Team3.Repository.UserRepository;
import net.bytebuddy.description.annotation.AnnotationList.Empty;



@Controller
public class CartController extends BaseController {
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ContactRepository contactRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ShippersRepository shippersRepository;
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	OrderRepository orderRepository; 
	
	
	@RequestMapping(value = { "/Home/Product/Carts" }, method = RequestMethod.GET)
	public String viewCart(Model model ,  HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		Cart cart = (Cart) httpSession.getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			model.addAttribute("carts",cart);
		}
		model.addAttribute("carts", cart.getCartItems());
		model.addAttribute("TotalPrice", cart.getTotalPrice());
		return "Custommers/Cart";
	}
	
	private int getTotalItems(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}

		Cart cart = (Cart) httpSession.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();

		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getQuanlity();
		}
		return total;
	}
	private void calculateTotalPrice(final HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();
		BigDecimal total = BigDecimal.ZERO;

		for (CartItem ci : cartItems) {
			total = total.add(ci.getPriceUnit().multiply(BigDecimal.valueOf(ci.getQuanlity())));
		}
		cart.setTotalPrice(total);
	}
	@RequestMapping(value = { "Home/add/ajax/ls" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_ls(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody CartItem cartItem) throws IOException {
		HttpSession session = request.getSession();
		Cart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);

		}
		
		List<CartItem> cartItems = cart.getCartItems();
		boolean isExists = false;
		for (CartItem item : cartItems) {
			if (item.getProductId() == cartItem.getProductId()) {
				isExists = true;
				item.setQuanlity(item.getQuanlity() + cartItem.getQuanlity());
			}
		}
		if (!isExists) {
			Optional<ProductsEnity> productInDb = productsRepository.findById(cartItem.getProductId());
			cartItem.setProductName(productInDb.get().getName());
			cartItem.setPriceUnit(productInDb.get().getPrice());
			cartItem.setNameCategory(productInDb.get().getCategoriesEnity().getName());
			cart.getCartItems().add(cartItem);
		}
		calculateTotalPrice(request);
		/*
		 * for (CartItem cartItem2 : cartItems) { System.out.println(cartItem2); }
		 */

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("totalItems", getTotalItems(request));
		session.setAttribute("totalItems", getTotalItems(request));
		session.setAttribute("cart", cart);
		return ResponseEntity.ok(jsonResult);
	}
	
	@RequestMapping(value = { "/home/shopcart" }, method = RequestMethod.POST)
	public String cartFinish(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		

		// Thông tin khách hàng
		String customerFullName = request.getParameter("customerFullName");
		String customerAddress = request.getParameter("customerAddress");
		String customerEmail = request.getParameter("customerEmail");
		String customerPhone = request.getParameter("customerPhone");
		String customerNote = request.getParameter("customerNote");
//	tạo hóa đơn
		ContactsEnity contactsEnity = new ContactsEnity();
		contactsEnity.setName(customerFullName);
		contactsEnity.setAdress(customerAddress);
		contactsEnity.setPhone(customerPhone);
		contactsEnity.setNote(customerNote);
		
		contactRepository.save(contactsEnity);
		
		OrdersEnity ordersEnity= new OrdersEnity();
		if (getUserLogined() != null) {
			UsersEnity usersEnity = new UsersEnity();
			usersEnity = userRepository.findByEmail(getUserLogined().getUsername());
			ordersEnity.setUsersEnityOrders(usersEnity);
		} else {
			return "redirect:/login";
		}
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		ordersEnity.setTotalPrice(cart.getTotalPrice());
		List<ShipperEnity> shipperEnities = (List<ShipperEnity>) shippersRepository.findAll();
		ordersEnity.setShipperEnityOrders(shipperEnities.get(0));
		ordersEnity.setContactsEnityOrder(contactsEnity);
		ordersEnity.setCreatedDate(dateNow());
		ordersEnity.setUpdatedDate(dateNow());
		ordersEnity.setStatus(0);
		orderRepository.save(ordersEnity);
		
		for (CartItem cartItem : cart.getCartItems()) {
			OrderDetailsEnity orderDetailsEnity = new OrderDetailsEnity();
			Optional<ProductsEnity> productsEnity = productsRepository.findById(cartItem.getProductId());
			orderDetailsEnity.setProductsEnityOrderDetails(productsEnity.get());
			orderDetailsEnity.setQuality(cartItem.getQuanlity());
			orderDetailsEnity.setOrdersEnityOrderDetails(ordersEnity);
			orderDetailsRepository.save(orderDetailsEnity);
			
			
		}
		session.setAttribute("cart", null);
		session.setAttribute("totalItems", "0");
		return "redirect:/index";

	}
	@RequestMapping(value = { "Home/add/ajax/total" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_total(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody CartItem cartItem) throws IOException {



		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		for (CartItem c : cart.getCartItems()) {
			if(c.getProductId() == cartItem.getProductId()) {
				c.setQuanlity(cartItem.getQuanlity());
				calculateTotalPrice(request);
			}
		}
		calculateTotalPrice(request);
		session.setAttribute("totalItems", getTotalItems(request));
		session.setAttribute("cart", cart);

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("totalItems", getTotalItems(request));
		jsonResult.put("TotalPrice", cart.getTotalPrice());
		return ResponseEntity.ok(jsonResult);
	}
	
	
	@RequestMapping(value = { "Home/add/ajax/deleteItemCart" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_deleteItemCart(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody CartItem cartItem) throws IOException {



		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		CartItem cartItem2 = null;
		for (CartItem c : cart.getCartItems()) {
			if(c.getProductId() == cartItem.getProductId()) {
				cartItem2 = c;
			}
		}
		cart.getCartItems().remove(cartItem2);
		getTotalItems(request);
		calculateTotalPrice(request);
		session.setAttribute("cart", cart);
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("totalItems", getTotalItems(request));
		jsonResult.put("TotalPrice", cart.getTotalPrice());
		jsonResult.put("id", cartItem.getProductId());
		session.setAttribute("totalItems", getTotalItems(request));
		
		return ResponseEntity.ok(jsonResult);
	}
	


	
	
}
