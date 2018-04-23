package com.grgbibek22.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbibek22.dao.CategoryDao;
import com.grgbibek22.model.Category;
import com.grgbibek22.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	
	public void addCategory(Category category) {
		categoryDao.saveCategory(category);
	}

	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	public Category getCategoryById(int id) {
		return categoryDao.getCategoryById(id);
	}

	public void deleteCategory(Category category) {
		categoryDao.deleteCategory(category);
	}

}
