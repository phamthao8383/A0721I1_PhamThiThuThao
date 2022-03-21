package fresher.Team3.Services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fresher.Team3.Enities.OrderDetailsEnity;
import fresher.Team3.Repository.OrderDetailsRepository;
import fresher.Team3.Services.OrderDetailsService;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public List<OrderDetailsEnity> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return (List<OrderDetailsEnity>) orderDetailsRepository.findAll();
	}

	@Override
	public Optional<OrderDetailsEnity> FindOrderDetailsById(Integer id) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findById(id);
	}

	@Override
	public List<OrderDetailsEnity> FindByOrderId(Integer id) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findOrderDetailsByOrderId(id);
	}

}
