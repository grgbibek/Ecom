package com.grgbibek22.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbibek22.dao.CategoryDao;
import com.grgbibek22.model.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		session.flush();
	}


	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Category");
		List <Category> categoryList = query.list();
		session.flush();
		return categoryList;
	}


	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Category category= (Category) session.get(Category.class, id);
		session.flush();
		return category;
	}


	public void deleteCategory(Category category) {
		Session session= sessionFactory.getCurrentSession();
		session.delete(category);
		session.flush();
	}

}
