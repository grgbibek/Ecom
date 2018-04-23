package com.grgbibek22.controller.admin;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.grgbibek22.model.Category;
import com.grgbibek22.services.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/addCategory", method=RequestMethod.GET)
	private String categoryForm() {
		return "addCategory";
	}
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	private String addCategory(@ModelAttribute("category") Category category, Model model) {
		categoryService.addCategory(category);
		List <Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("msg","Category Updated");
		return "category";
	}
	
	@RequestMapping(value="/editCategory/{id}")
	private String editProduct(@PathVariable(value="id") int categoryId, Model model) {
		Category category= categoryService.getCategoryById(categoryId);
		model.addAttribute("category",category);
		return "editCategory";
		
	}
	
	@RequestMapping("/categories")
	public String categories(Model model) {
		List <Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		return "category";
	}
	
	@RequestMapping("/deleteCategory/{id}")
	private String deleteCategory(@PathVariable(value="id") int id,Model model) throws SQLException {
		Category category= categoryService.getCategoryById(id);
		categoryService.deleteCategory(category);
		
		List <Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("msg","Item deleted");
		return "category";
	}
}
