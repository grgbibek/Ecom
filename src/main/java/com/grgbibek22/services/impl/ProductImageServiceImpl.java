package com.grgbibek22.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbibek22.dao.ProductImageDao;
import com.grgbibek22.model.ProductImage;
import com.grgbibek22.services.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService{
	
	@Autowired
	private ProductImageDao productImageDao;

	public List<ProductImage> getProductImageList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductImage getProductImageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveProductImage(ProductImage productImage) {
		productImageDao.saveProductImage(productImage);
		
	}

	public void deleteProductImage(ProductImage productImage) {
		// TODO Auto-generated method stub
		
	}

}
