package com.donwoo.product.management.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class Product {
	private Long product_id;

	@Size(min = 1, max = 10)
	private String meat_grade;

	@Size(min = 1, max = 10)
	private String product_name;

	@Max(1_000_000)
	@Min(0)
	private Integer price_per_kg;

	@Size(min = 1, max = 10)
	private String brand_name;
	private DateInfo date_info;
	private Facility facility;
	private Certificate certificate;
	private MeatInformation meat_information;

	// Setter


	public void setProduct_id(Long product_id) { this.product_id = product_id; }

	public void setProduct_name(String product_name) { this.product_name = product_name; }

	public void setPrice_per_kg(Integer price_per_kg) { this.price_per_kg = price_per_kg; }

	public void setBrand_name(String brand_name) { this.brand_name = brand_name; }

	public void setDate_info(DateInfo date_info) { this.date_info = date_info; }

	// Getter

	public Long getProduct_id() { return product_id; }

	public String getMeat_grade() {
		return meat_grade;
	}

	public String getProduct_name() {
		return product_name;
	}

	public Integer getPrice_per_kg() {
		return price_per_kg;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public DateInfo getDate_info() { return date_info; }

	public Facility getFacility() {
		return facility;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public MeatInformation getMeat_information() {
		return meat_information;
	}

	// Method
	public Boolean sameId(Long product_id) {
		return this.product_id.equals(product_id);
	}

	public Boolean containsProductName(String product_name) {
		return this.product_name.contains(product_name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(product_id, product.product_id);
	}
}
