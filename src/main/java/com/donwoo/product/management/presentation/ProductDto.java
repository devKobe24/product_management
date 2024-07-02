package com.donwoo.product.management.presentation;

import com.donwoo.product.management.domain.Certificate;
import com.donwoo.product.management.domain.Facility;
import com.donwoo.product.management.domain.MeatInformation;
import com.donwoo.product.management.domain.ProductDate;
import jakarta.validation.constraints.NotNull;


public class ProductDto {
	private Long product_id;

	@NotNull
	private String meatGrade;

	@NotNull
	private String productName;

	@NotNull
	private Integer pricePerKg;

	@NotNull
	private String brandName;

	@NotNull
	private ProductDate date;

	@NotNull
	private Facility facility;

	@NotNull
	private Certificate certificate;

	@NotNull
	private MeatInformation meatInformation;

	// Getter
	public Long getProduct_id() {
		return product_id;
	}

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

	// Setter
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
}
