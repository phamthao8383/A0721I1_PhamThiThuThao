package fresher.Team3.Services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fresher.Team3.Enities.ReviewsEnity;
import fresher.Team3.Repository.ReviewsRepository;
import fresher.Team3.Services.ReviewsService;


@Service
public class ReviewsServiceImpl implements ReviewsService {
	@Autowired
	private ReviewsRepository reviewsRepository;
	
	@Override
	public List<ReviewsEnity> getAllReview() {
		 return (List<ReviewsEnity>) reviewsRepository.findAll();  
	}

	@Override
	public void saveShiper(ReviewsEnity review) {
		reviewsRepository.save(review); 
		
	}

	@Override
	public void deleteReview(Integer id) {
		reviewsRepository.deleteById(id); 
		
	}

	@Override
	public Optional<ReviewsEnity> findReviewById(Integer id) {
		return reviewsRepository.findById(id); 
	}

}
