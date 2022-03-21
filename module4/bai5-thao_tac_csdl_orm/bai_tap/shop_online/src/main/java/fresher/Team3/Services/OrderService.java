package fresher.Team3.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fresher.Team3.Enities.OrderDetailsEnity;
import fresher.Team3.Enities.OrdersEnity;


public interface OrderService {
//	List<OrdersEnity> getAllOrder();
	
	void saveOrder(OrdersEnity order);
	
	void deleteOrder(Integer id);

	Optional<OrdersEnity> findOrderById(Integer id);

	

	Page<OrdersEnity> getAllOrder(Pageable pageable,String date); 

	 
	
}
