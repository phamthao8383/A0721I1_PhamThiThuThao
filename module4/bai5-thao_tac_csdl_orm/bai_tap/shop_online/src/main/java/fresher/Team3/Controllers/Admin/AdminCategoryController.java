package fresher.Team3.Controllers.Admin;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fresher.Team3.Controllers.BaseController;
import fresher.Team3.Enities.CategoriesEnity;

import fresher.Team3.Repository.CategoriesRepository;

@Controller
public class AdminCategoryController extends BaseController {
	@Autowired
	CategoriesRepository categoriesRepository;
	@RequestMapping(value ={"/Admin/Category"}, method = RequestMethod.GET)  
	  public String index(Model model) {  
		List<CategoriesEnity> categoriesEnity = (List<CategoriesEnity>) categoriesRepository.findAll();

	    model.addAttribute("categoriesEnities", categoriesEnity);  

	    return "Admin/Category/CategoriesList";  
	  }  
	
	@RequestMapping(value = "/Admin/Category/add")  
	  public String addShiper(Model model) {  
	    model.addAttribute("categories", new CategoriesEnity());  
	    model.addAttribute("categoriesEnity", new CategoriesEnity());  
	    return "Admin/Category/AddUpdateCategory";  
	  }  

	  @RequestMapping(value = "/Admin/Category/edit", method = RequestMethod.GET)  
	  public String editShiper(@RequestParam("id") Integer id, Model model) {  
	    Optional<CategoriesEnity> categoriesEnity  = categoriesRepository.findById(id) ;  
	    categoriesEnity.ifPresent(category -> model.addAttribute("categories", category)); 
	    model.addAttribute("categoriesEnity", new CategoriesEnity());  
	    
	    return "Admin/Category/AddUpdateCategory";  
	  }  

	  @RequestMapping(value = "/Admin/Category/Save", method = RequestMethod.POST)  
	  public String save(CategoriesEnity categoriesEnity) {  
	    categoriesRepository.save(categoriesEnity);  
	    return "redirect:/Admin/Category";  
	  }  

	  @RequestMapping(value = "/Admin/Category/delete", method = RequestMethod.GET)  
	  public String deleteShiper(@RequestParam("id") Integer id, Model model) {  
	    categoriesRepository.deleteById(id);  
	    return "redirect:/Admin/Category";  
	  }  



}
