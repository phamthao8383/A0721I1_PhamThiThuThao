package fresher.Team3.Controllers.Admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fresher.Team3.Enities.RolesEnity;
import fresher.Team3.Enities.UsersEnity;
import fresher.Team3.Repository.RoleRepository;
import fresher.Team3.Services.UserService;

@Controller
public class AdminUsersController {
	@Autowired
	private UserService userService;
	@Autowired
	RoleRepository roleRepo;

	/*
	 * @RequestMapping("/Admin/User") public String viewHomePage(Model model) {
	 * List<UsersEnity> listUsers = userService.getAllUser();
	 * model.addAttribute("listUsers", listUsers); return "/Admin/User/user"; }
	 */
	@GetMapping("/Admin/User")
	public String listUserPage(ModelMap model, @RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		int currnetPage = page.orElse(0);
		int sizePage = size.orElse(5);

		Pageable pageable = PageRequest.of(currnetPage, sizePage, Sort.by("id"));
		Page<UsersEnity> resultPage = null;
		List<UsersEnity> list = null;

		if (StringUtils.hasText(name)) {
			resultPage = userService.findByNameContaining(name, pageable);
			list = userService.findByNameContaining(name);
			if (list.size() == 0) {
				model.addAttribute("error", "No result ");

			}

			model.addAttribute("name", name);
		} else {

			resultPage = userService.findAll(pageable);
		}

		int totalPages = resultPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currnetPage - 2);
			int end = Math.min(currnetPage + 2, totalPages - 1);
			if (totalPages > 1) {
				if (end == totalPages)
					start = end - 1;
				else if (start == 1)
					end = start + 1;
				List<Integer> pageNumber = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

				model.addAttribute("pageNumber", pageNumber);

			}

		}
		model.addAttribute("userPage", resultPage);

		return "/Admin/User/user";
	}

	@RequestMapping(value = "/Admin/User/New", method = RequestMethod.GET)
	public String showNewUserPage(Model model) {
		List<RolesEnity> listRole = roleRepo.findAll();
		UsersEnity user = new UsersEnity();
		model.addAttribute("listRole", listRole);
		model.addAttribute("user", user);
		return "/Admin/User/AddUser";
	}

	@RequestMapping(value = "/Admin/User/Details/{id}", method = RequestMethod.GET)
	public ModelAndView detailsUser(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("/Admin/User/DetailsUser");
		Optional<UsersEnity> user = userService.findUserById(id);
		mav.addObject("user", user);

		return mav;
	}
	
	@RequestMapping(value = "/Admin/User/Block/{id}", method = RequestMethod.GET)
	public String detailsUserBlock(@PathVariable(name = "id") int id) {
		
		Optional<UsersEnity> user = userService.findUserById(id);
		user.get().setAdress("1");
		userService.saveUser(user.get());
		return "redirect:/Admin/User";
	}

	@RequestMapping(value = "/Admin/User/Save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") UsersEnity user) {
		userService.saveUser(user);
		return "redirect:/Admin/User";
	}

	@RequestMapping("/Admin/User/Edit/{id}")
	public ModelAndView showEditUser(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("/Admin/User/EditUser");
		Optional<UsersEnity> user = userService.findUserById(id);
		mav.addObject("user", user);

		return mav;
	}

	@RequestMapping("/Admin/User/Delete/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
		userService.deleteUser(id);
		return "redirect:/Admin/User";
	}

}
