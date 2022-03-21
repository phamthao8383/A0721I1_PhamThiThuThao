package fresher.Team3.Controllers.Admin;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fresher.Team3.Enities.ReviewsEnity;
import fresher.Team3.Repository.ReviewsRepository;
import fresher.Team3.Services.ReviewsService;

@Controller
public class AdminReviewsController {
	@Autowired
	private ReviewsService reviewsService;
	@Autowired
	private ReviewsRepository reviewsRepository;
	/*
	 * @RequestMapping(value = { "/homeReview" }, method = RequestMethod.GET) public
	 * String index(Model model) { List<ReviewsEnity> review =
	 * reviewsService.getAllReview();
	 * 
	 * model.addAttribute("review", review);
	 * 
	 * return "/Admin/Review/HomeReview"; }
	 */
	@RequestMapping(value = "/Admin/homeReview",method = RequestMethod.GET)
	  public String index(Model model, HttpServletRequest request, @RequestParam("pageId") Optional<Integer> pageId ,  @RequestParam("date") Optional<String> date) {
		  Pageable pageable = PageRequest.of(pageId.orElse(1)-1, 4);
		  if(date == null || date.isEmpty()) {
			  model.addAttribute("review",reviewsRepository.findAllReview(pageable)); // lấy hết danh sách từ thằng Repo rồi đưa vào /Admin..
		  }
		  else {
			  model.addAttribute("review",reviewsRepository.findOrderSeachbyDate(pageable, date.get())); // lấy hết danh sách từ thằng Repo rồi đưa vào /Admin..
		  }
		  
		  return "Admin/Review/HomeReview";
	  }
	@RequestMapping(value = "/Admin/addReview")
	public String addReview(Model model) {
		model.addAttribute("review", new ReviewsEnity());
		return "/Admin/Review/AddUpdateReview";
	}
	@RequestMapping(value = "/Admin/editReview", method = RequestMethod.GET)
	public String editReview(@RequestParam("id") Integer reviewId, Model model) {
		System.out.println(reviewId);
		Optional<ReviewsEnity> reviewEdit = reviewsService.findReviewById(reviewId);
		reviewEdit.ifPresent(review -> model.addAttribute("review", review));

		return "Admin/Review/AddUpdateReview";
	}
	@RequestMapping(value = "/Admin/SaveReview", method = RequestMethod.POST)
	public String save(ReviewsEnity review) {
		reviewsService.saveShiper(review);
		return "redirect:/Admin/homeReview";
	}
	@RequestMapping(value = "/Admin/deleteReview", method = RequestMethod.GET)
	public String deleteReview(@RequestParam("id") Integer reviewId, Model model) {
		reviewsService.deleteReview(reviewId);
		return "redirect:/Admin/homeReview";
	}
}
