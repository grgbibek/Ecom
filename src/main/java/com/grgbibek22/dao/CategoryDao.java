package com.grgbibek22.dao;

import java.util.List;

import com.grgbibek22.model.Category;

public interface CategoryDao {
	
	List<Category> getCategoryList();
	
	Category getCategoryById(int id);
	
	void saveCategory(Category category);
	
	void deleteCategory(Category category);
	
}
