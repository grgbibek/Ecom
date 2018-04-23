package com.grgbibek22.dao;

import java.util.List;

import com.grgbibek22.model.ProductImage;

public interface ProductImageDao {
	List<ProductImage> getProductImageList();
	
	ProductImage getProductImageById(int id);
	
	void saveProductImage(ProductImage productImage);
	
	void deleteProductImage(ProductImage productImage);
}
