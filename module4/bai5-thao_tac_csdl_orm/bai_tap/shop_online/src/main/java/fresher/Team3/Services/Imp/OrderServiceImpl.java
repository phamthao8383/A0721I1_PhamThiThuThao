package fresher.Team3.Services.Imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fresher.Team3.Enities.OrdersEnity;
import fresher.Team3.Repository.OrderRepository;
import fresher.Team3.Services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	

//	@Override
//	public List<OrdersEnity> getAllOrder() {
//		return (List<OrdersEnity>) orderRepository.findAll();
//	}

	@Override

	public Page<OrdersEnity> getAllOrder(Pageable pageable,String date) {
		 if (date != null) {
	            return orderRepository.findOrderSeachbyDate(pageable,date);
	        }
	        return  orderRepository.findOrder(pageable);
	    }
	
	
	@Override
	public void saveOrder(OrdersEnity order) {
		orderRepository.save(order);
		
	}

	@Override
	public void deleteOrder(Integer id) {
		orderRepository.deleteById(id);
		
	}

	@Override
	public Optional<OrdersEnity> findOrderById(Integer id) {
		return orderRepository.findById(id);
	}





}
