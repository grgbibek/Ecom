package com.grgbibek22.services;

import java.util.List;

import com.grgbibek22.model.Category;
import com.grgbibek22.model.Product;
import com.grgbibek22.model.ProductImage;

public interface ProductService {
	
	List<Product> getProductList();
	
	Product getProductById(int id);
	
	void saveProduct(Product product);
	
	void deleteProduct(Product product);

}
