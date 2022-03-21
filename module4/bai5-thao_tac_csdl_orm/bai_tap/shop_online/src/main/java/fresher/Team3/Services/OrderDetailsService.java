package fresher.Team3.Services;

import java.util.List;
import java.util.Optional;

import fresher.Team3.Enities.OrderDetailsEnity;

public interface OrderDetailsService {

	List<OrderDetailsEnity> getAllOrderDetails();
	
	Optional<OrderDetailsEnity> FindOrderDetailsById(Integer id);
	
	List<OrderDetailsEnity> FindByOrderId(Integer id);
}
