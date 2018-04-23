package com.grgbibek22.services;

import java.util.List;

import com.grgbibek22.model.Category;

public interface CategoryService {
	
	List<Category> getCategoryList();
	
	Category getCategoryById(int id);
	
	void addCategory(Category category);	
	
	void deleteCategory(Category category);
	
	
}
