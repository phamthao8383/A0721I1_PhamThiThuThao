package fresher.Team3.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fresher.Team3.Enities.ProductsEnity;

public interface ProductsRepository extends CrudRepository<ProductsEnity, Integer> {
	@Query(value = "SELECT * from tbl_products   where tbl_products.category_id = :id", nativeQuery = true)
	List<ProductsEnity> searchCategoryId(Integer id);
	
	@Query(value = "SELECT p from ProductsEnity p  where :id is null or p.categoriesEnity.id = :id  ")
	Page<ProductsEnity> searchCategoryIdPaging(Integer id ,Pageable pageable);
	
	
	@Query(value = "SELECT * from tbl_products ", nativeQuery = true)
	Page<ProductsEnity> findAllProduct(Pageable pageable);
	
	 @Query(value="select p from ProductsEnity p where p.description like %:searchtext% or p.name like %:searchtext%")    
	    Page<ProductsEnity> findByAllColumns(String searchtext, Pageable pageable);
	
	
	/*
	 * @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%") List<Movie>
	 * searchByTitleLike(@Param("title") String title);
	 */
	
}
