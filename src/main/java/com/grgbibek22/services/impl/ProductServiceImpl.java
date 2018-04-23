package com.grgbibek22.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbibek22.dao.ProductDao;
import com.grgbibek22.model.Product;
import com.grgbibek22.model.ProductImage;
import com.grgbibek22.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao	productDao;  //what are we doing here?? generally accessing the method of interface "ProductDao", 
										//but what goes behind scene. are we creating the object of interface here? No, but how??

	public List<Product> getProductList() {
		return productDao.getProductList();
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}

	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}

	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
		
	}
	
}
