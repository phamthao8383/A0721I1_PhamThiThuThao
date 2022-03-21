package fresher.Team3.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;



import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;


import fresher.Team3.Enities.ReviewsEnity;
public interface ReviewsRepository extends CrudRepository<ReviewsEnity, Integer> {
	
	  @Query(value =  "SELECT * FROM tbl_reviews ", nativeQuery = true)
	  Page<ReviewsEnity> findAllReview(Pageable pageable);
	  
	  @Query(value = "select * from foodpet.tbl_reviews\r\n"
				+ "where :date is null or date(created_at) = :date", nativeQuery = true)
		Page<ReviewsEnity> findOrderSeachbyDate(Pageable pageable,String date);
	 
}
