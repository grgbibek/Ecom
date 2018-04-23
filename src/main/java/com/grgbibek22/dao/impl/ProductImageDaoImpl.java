package com.grgbibek22.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbibek22.dao.ProductImageDao;
import com.grgbibek22.model.ProductImage;

@Repository
@Transactional
public class ProductImageDaoImpl implements ProductImageDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveProductImage(ProductImage productImage) {
		Session session= sessionFactory.getCurrentSession();
		session.save(productImage);
		session.flush();
	}

	public List<ProductImage> getProductImageList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductImage getProductImageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProductImage(ProductImage productImage) {
		// TODO Auto-generated method stub
		
	}
	
	
}
