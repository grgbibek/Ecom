package com.grgbibek22.services;

import java.util.List;

import com.grgbibek22.model.ProductImage;

public interface ProductImageService {
	List<ProductImage> getProductImageList();
	
	ProductImage getProductImageById(int id);
	
	void saveProductImage(ProductImage productImage);
	
	void deleteProductImage(ProductImage productImage);
}
