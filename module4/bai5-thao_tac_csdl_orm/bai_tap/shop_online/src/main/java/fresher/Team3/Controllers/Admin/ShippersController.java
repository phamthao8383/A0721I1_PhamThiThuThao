package fresher.Team3.Controllers.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fresher.Team3.Enities.ShipperEnity;
import fresher.Team3.Services.ShipperService;

@Controller

public class ShippersController {
	@Autowired 
	private ShipperService shipperService;  
	
	@RequestMapping(value ={"/Admin/Shipper"}, method = RequestMethod.GET)  
	  public String index(Model model) {  
	    List<ShipperEnity> shipper = shipperService.getAllShipper();  

	    model.addAttribute("shipper", shipper);  

	    return "Admin/Shipper/HomeShiper";  
	  }  

	  @RequestMapping(value = "/Admin/Shipper/add")  
	  public String addShiper(Model model) {  
	    model.addAttribute("shipper", new ShipperEnity());  
	    return "Admin/Shipper/AddUpdateShiper";  
	  }  

	  @RequestMapping(value = "/Admin/Shipper/edit", method = RequestMethod.GET)  
	  public String editShiper(@RequestParam("id") Integer shipperId, Model model) {  
		
	    Optional<ShipperEnity> shipperEdit = shipperService.findShiperById(shipperId);  
	    shipperEdit.ifPresent(shipper -> model.addAttribute("shipper", shipper));  
	    
	    return "Admin/Shipper/AddUpdateShiper";  
	  }  

	  @RequestMapping(value = "/Admin/Shipper/Save", method = RequestMethod.POST)  
	  public String save(ShipperEnity shipper) {  
	    shipperService.saveShiper(shipper);  
	    return "redirect:/Admin/Shipper";  
	  }  

	  @RequestMapping(value = "/Admin/Shipper/delete", method = RequestMethod.GET)  
	  public String deleteShiper(@RequestParam("id") Integer shipperId, Model model) {  
	    shipperService.deleteShiper(shipperId);  
	    return "redirect:/Admin/Shipper";  
	  }  

}
