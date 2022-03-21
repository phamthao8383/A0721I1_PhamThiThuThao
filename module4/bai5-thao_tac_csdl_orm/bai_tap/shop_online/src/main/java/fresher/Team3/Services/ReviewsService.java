package fresher.Team3.Services;

import java.util.List;
import java.util.Optional;

import fresher.Team3.Enities.ReviewsEnity;

public interface ReviewsService {
	List<ReviewsEnity> getAllReview();

	void saveShiper(ReviewsEnity review);

	void deleteReview(Integer id);

	Optional<ReviewsEnity> findReviewById(Integer id);
}
