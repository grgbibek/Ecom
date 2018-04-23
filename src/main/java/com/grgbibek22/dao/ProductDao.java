package com.grgbibek22.dao;

import java.util.List;

import com.grgbibek22.model.Product;
import com.grgbibek22.model.ProductImage;

public interface ProductDao {
	
	List<Product> getProductList();
	
	Product getProductById(int id);
	
	void saveProduct(Product product);
	
	void deleteProduct(Product product);
}
