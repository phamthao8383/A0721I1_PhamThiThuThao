package fresher.Team3.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fresher.Team3.Enities.OrderDetailsEnity;

public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEnity, Integer>{
	
	  @Query(value = "SELECT tlb_order_details.*\r\n" +
	  "FROM tbl_order,tlb_order_details where tbl_order.id = tlb_order_details.order_id and tlb_order_details.order_id = :id"
	  ,nativeQuery = true) List<OrderDetailsEnity>
	  findOrderDetailsByOrderId(Integer id);
	
//	@Query(value = "SELECT tlb_order_details.* ,tlb_order_details.quality*tbl_products.price as thanhtien\r\n"
//			+ "FROM tbl_order,tlb_order_details,tbl_products where tbl_order.id = tlb_order_details.order_id \r\n"
//			+ "and tlb_order_details.product_id = tbl_products.id and  tlb_order_details.order_id = :id ",nativeQuery = true)
//	List<OrderDetailsEnity> findOrderDetailsByOrderId(Integer id);
	 

}
