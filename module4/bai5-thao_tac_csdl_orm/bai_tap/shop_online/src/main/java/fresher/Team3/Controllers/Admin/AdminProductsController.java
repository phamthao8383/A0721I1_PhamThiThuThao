package fresher.Team3.Controllers.Admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fresher.Team3.Controllers.BaseController;

import fresher.Team3.Enities.CategoriesEnity;
import fresher.Team3.Enities.ProductsEnity;
import fresher.Team3.Repository.CategoriesRepository;
import fresher.Team3.Repository.ProductsRepository;
import fresher.Team3.Services.CategoriesService;
import fresher.Team3.Services.ProductsService;

@Controller
public class AdminProductsController extends BaseController {

	@Autowired
	private ProductsService productsService;
	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private CategoriesRepository categoriesRepository; 

	@RequestMapping(value = { "/Admin/products" }, method = RequestMethod.GET)
	public String viewIndexAdminProducts(Model model, HttpServletRequest request,
			@RequestParam("pageId") Optional<Integer> pageId) {
		System.out.println(getUserLogined().getAuthorities());	
		
		// List<ProductsEnity> productsEnities =
		// productsService.getAllProductsEnities();
		Pageable pageable = PageRequest.of(pageId.orElse(1)-1, 6,  new Sort(Direction.DESC, "updated_at"));
		/*
		 * pageId.orElse(0) neu page = null thi default la trang dau tin
		 */
		model.addAttribute("categorie", new CategoriesEnity());
		model.addAttribute("products", productsRepository.findAllProduct(pageable));
		
		/*
		 * System.out.println(productsRepository.findAllProduct(pageable).
		 * getTotalElements() + " tong phan tu trong page");
		 * System.out.println(productsRepository.findAllProduct(pageable).getTotalPages(
		 * )+ " tong  page");
		 */
		 
		// model.addAttribute("products", productsEnities);

		return "Admin/product/index";
	}

	@RequestMapping(value = { "/Admin/products/Update" }, method = RequestMethod.GET)
	public String viewAddOrUpdate(@RequestParam("id") Integer id, Model model) {
		productsService.findProductById(id).ifPresent(products -> model.addAttribute("products", products));
		model.addAttribute("productsEnity", new ProductsEnity());

		return "Admin/product/AddOrUpdateProduct";
	}

	@ModelAttribute("categories")
	public List<CategoriesEnity> categories() {
		return categoriesService.findAll();
	}

	@RequestMapping(value = { "/Admin/products/AddOrUpdate" }, method = RequestMethod.GET)
	public String viewAdd(Model model) {
		model.addAttribute("products", new ProductsEnity());
		model.addAttribute("productsEnity", new ProductsEnity());

		return "Admin/product/AddOrUpdateProduct";
	}

	@RequestMapping(value = "/Admin/products/AddOrUpdate", method = RequestMethod.POST)
	public String save(ProductsEnity productsEnity, BindingResult bindingResult, HttpServletRequest request,
			Model model, @RequestParam("productAvatar") MultipartFile productAvatar,
			@RequestParam("productPictures") MultipartFile[] productPictures)
			throws IllegalStateException, IOException {

		if (productsEnity.getId() == null) {
			productsEnity.setCreatedDate(dateNow());
			productsEnity.setUpdatedDate(dateNow());
			productsService.addFile(productsEnity, productAvatar, productPictures);
		} else {
			productsEnity.setUpdatedDate(dateNow());
			productsService.updateFile(productsEnity, productAvatar, productPictures);
		}
		return "redirect:/Admin/products";
	}
	@RequestMapping(value = { "/Admin/products/find" }, method = RequestMethod.GET)
	public String SearchIndexAdminProducts(Model model, @RequestParam( "categorie") Optional<Integer> id,@RequestParam("pageId") Optional<Integer> pageId) {
		
		Pageable pageable = PageRequest.of(pageId.orElse(1)-1, 6,new Sort(Direction.DESC, "price"));
		
		
		if(id.isEmpty()) {
			model.addAttribute("categorie", new CategoriesEnity());
			model.addAttribute("products", productsRepository.findAllProduct(pageable));
		}
		else {
			model.addAttribute("categorie", categoriesRepository.findById(id.get()).get());
			model.addAttribute("products", productsRepository.searchCategoryIdPaging(id.get(), pageable));
		}
		
		return "Admin/product/Index";
	}

	@GetMapping("/Admin/products/getexcel")
	public String getexcel() throws IOException {
		List<ProductsEnity> productsEnities = productsService.getAllProductsEnities();
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\rekkeisoft-MockProject-2\\src\\main\\resources\\static\\export\\test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet xssfSheet = workbook.createSheet("name");
		XSSFRow row;
		XSSFCell cell;
		row = xssfSheet.createRow((short) 0);
		cell = row.createCell((short) 0);
		cell.setCellValue("id");
		cell = row.createCell((short) 1);
		cell.setCellValue("code");
		cell = row.createCell((short) 2);
		cell.setCellValue("email");
		cell = row.createCell((short) 3);
		cell.setCellValue("name");
		cell = row.createCell((short) 4);
		cell.setCellValue("phone");

		int countrow = 0;

		for (int i = 0; i < productsEnities.size(); i++) {
			row = xssfSheet.createRow((short) ++countrow);
			cell = row.createCell((short) 0);
			cell.setCellValue(productsEnities.get(i).getId());
			cell = row.createCell((short) 1);
			cell.setCellValue(productsEnities.get(i).getName());
			cell = row.createCell((short) 2);
			cell.setCellValue(productsEnities.get(i).getDescription());
			cell = row.createCell((short) 3);
			cell.setCellValue(productsEnities.get(i).getPrice().floatValue());
			cell = row.createCell((short) 4);
			cell.setCellValue(productsEnities.get(i).getAvatar());

		}
		workbook.write(fileOutputStream);
		workbook.close();
		fileOutputStream.close();
		return "redirect:/Admin/products";
	}
	
	
	@RequestMapping(value = { "/Admin/products/ajax" }, method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> ajax_Delete(final Model model, final HttpServletRequest request,@RequestParam("id") Integer id
			) {
		Optional<ProductsEnity> productsEnity =  productsRepository.findById(id);
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("status", productsEnity.get());
		jsonResult.put("id", productsEnity.get().getId());
		productsRepository.deleteById(id);
		return ResponseEntity.ok(jsonResult);
	}

}
