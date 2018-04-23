package com.grgbibek22.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbibek22.dao.ProductDao;
import com.grgbibek22.model.Category;
import com.grgbibek22.model.Product;
import com.grgbibek22.model.ProductImage;
import com.grgbibek22.services.CategoryService;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CategoryService categoryService;

	public List<Product> getProductList() {
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();
		session.flush();
		return productList;
	}

	public Product getProductById(int id) {
		Session session= sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		session.flush();
		return product;
	}

	public void saveProduct(Product product) {
		Session session= sessionFactory.getCurrentSession();
		product.setCategory(categoryService.getCategoryById(product.getCategoryId()));
		/*category.getProduct().add(product);*/
/*		session.saveOrUpdate(category);
*/		session.saveOrUpdate(product);
		session.flush();
	}

	public void deleteProduct(Product product) {
		Session session= sessionFactory.getCurrentSession();
		session.delete(product);
		session.flush();
		
	}

}
