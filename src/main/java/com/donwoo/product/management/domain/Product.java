package com.donwoo.product.management.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class Product {
	private Long product_id;

	@Size(min = 1, max = 10)
	private String meatGrade;

	@Size(min = 1, max = 10)
	private String productName;

	@Max(1_000_000)
	@Min(0)
	private Integer pricePerKg;

	@Size(min = 1, max = 10)
	private String brandName;
	private ProductDate date;
	private Facility facility;
	private Certificate certificate;
	private MeatInformation meatInformation;

	// Setter


	public void setProduct_id(Long product_id) { this.product_id = product_id; }

	public void setProductName(String productName) { this.productName = productName; }

	public void setPricePerKg(Integer pricePerKg) { this.pricePerKg = pricePerKg; }

	public void setBrandName(String brandName) { this.brandName = brandName; }

	// Getter

	public Long getProduct_id() { return product_id; }

	public String getMeatGrade() {
		return meatGrade;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getPricePerKg() {
		return pricePerKg;
	}

	public String getBrandName() {
		return brandName;
	}

	public ProductDate getDate() {
		return date;
	}

	public Facility getFacility() {
		return facility;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public MeatInformation getMeatInformation() {
		return meatInformation;
	}

	// Method
	public Boolean sameId(Long product_id) {
		return this.product_id.equals(product_id);
	}

	public Boolean containsProductName(String product_name) {
		return this.productName.contains(product_name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(product_id, product.product_id);
	}
}
