package fresher.Team3.Controllers.Custommers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AboutController {
	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String viewAbout() {
		
		return "Custommers/About";
	}

}
