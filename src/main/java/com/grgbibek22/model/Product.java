package com.grgbibek22.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


//import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="productName")
	private String productName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private Category category;
	
	@OneToOne
	@JoinColumn(name="productImageId")
	private ProductImage productImage;
	
	@Column(name="description")
	private String description;
	@Column(name="price")
	private String price;
	@Column(name="status")
	private String condition;
	
	@Transient
	private int categoryId;
	
	@Transient
	private MultipartFile productImg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public ProductImage getProductImage() {
		return productImage;
	}
	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}
	public MultipartFile getProductImg() {
		return productImg;
	}
	public void setProductImg(MultipartFile productImg) {
		this.productImg = productImg;
	}
	
	
	
	
}
