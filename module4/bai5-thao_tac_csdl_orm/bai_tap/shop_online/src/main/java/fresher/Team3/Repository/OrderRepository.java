package fresher.Team3.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fresher.Team3.Enities.OrdersEnity;

public interface OrderRepository extends CrudRepository<OrdersEnity, Integer> {
	@Query(value = "SELECT * FROM tbl_order", nativeQuery = true)
	Page<OrdersEnity> findOrder(Pageable pageable);
	
	@Query(value = "select * from foodpet.tbl_order\r\n"
			+ "where :date is null or date(created_at) = :date", nativeQuery = true)
	Page<OrdersEnity> findOrderSeachbyDate(Pageable pageable,String date);
	
	@Query(value = "SELECT * FROM tbl_order where :userId is null or tbl_order.user_id = :userId" , nativeQuery = true)
	List<OrdersEnity> findByUserId(Integer userId);

 
	
}
