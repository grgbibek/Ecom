package com.grgbibek22.controller.admin;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.grgbibek22.model.Category;
import com.grgbibek22.model.Product;
import com.grgbibek22.model.ProductImage;
import com.grgbibek22.services.CategoryService;
import com.grgbibek22.services.ProductImageService;
import com.grgbibek22.services.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	private Path path;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductImageService productImageService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/showProductList")
	public String showProductList(Model model) {
		List<Product> productList= productService.getProductList();
		model.addAttribute("productList",productList);
		return "adminProduct";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.GET)
	private String addProduct(Model model) {
		List<Category> categoryList= categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		return "addProduct";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	private String saveProduct(@ModelAttribute ("product") Product product, HttpServletRequest request) {
		System.out.println("We are in now!");
		
		/*productService.saveProduct(product);*/
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String uploadPath = rootDirectory + "\\src\\main\\resources\\images\\";
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");		
        
        MultipartFile productImg= product.getProductImg();
	        System.out.println(rootDirectory);
	       /* DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	        Date date = new Date();*/
	        String filename = df.format(new Date()) + "." + "jpg";
	        path = Paths.get(uploadPath + filename);
	        if(productImg !=null && !productImg.isEmpty()){
	            try{
	            	ProductImage productImage = new ProductImage();
	            	productImage.setImageName(filename);
	            	
	            	productImageService.saveProductImage(productImage);
	            	
	            	product.setProductImage(productImage);
	            	productService.saveProduct(product);
	            	productImg.transferTo(new File(path.toString()));
	            }catch(Exception e){
	                e.printStackTrace();
	                throw new RuntimeException("Product image saving failed");
	            }
	        }
		return "redirect:/admin/showProductList";
	}
	
	@RequestMapping(value="/getProductById/{id}")
	public String getProductById(@PathVariable (value="id") int id, Model model) {
		Product product= productService.getProductById(id);
		model.addAttribute("product",product);
		return "adminProduct";
	}
	
	@RequestMapping(value="/editProduct/{id}")
	public String editProduct(@PathVariable (value="id") int id, Model model) {
		Product product= productService.getProductById(id);
		model.addAttribute("product",product);
		
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList",categoryList);
		return "edit_adminProduct";
	}
	
	@RequestMapping(value="/deleteProduct/{id}")
	public String deleteProduct(@PathVariable (value="id") int id, Model model) {
		Product product = productService.getProductById(id);
		productService.deleteProduct(product);
		return "redirect:/admin/showProductList";
	}
	

	
	
}
