package com.donwoo.product.management.presentation;

import com.donwoo.product.management.domain.Certificate;
import com.donwoo.product.management.domain.Facility;
import com.donwoo.product.management.domain.MeatInformation;
import com.donwoo.product.management.domain.DateInfo;
import jakarta.validation.constraints.NotNull;


public class ProductDto {
	private Long product_id;

	@NotNull
	private String meat_grade;

	@NotNull
	private String product_name;

	@NotNull
	private Integer price_per_kg;

	@NotNull
	private String brand_name;

	@NotNull
	private DateInfo date_info;

	@NotNull
	private Facility facility;

	@NotNull
	private Certificate certificate;

	@NotNull
	private MeatInformation meat_information;

	public ProductDto() {
	}

	public ProductDto(
			String meat_grade,
			String product_name,
			Integer price_per_kg,
			String brand_name
	) {
		this.meat_grade = meat_grade;
		this.product_name = product_name;
		this.price_per_kg = price_per_kg;
		this.brand_name = brand_name;
	}

	public ProductDto(
			String meat_grade,
			String product_name,
			Integer price_per_kg,
			String brand_name,
			DateInfo date_info,
			Facility facility,
			Certificate certificate,
			MeatInformation meat_information
	) {
		this.meat_grade = meat_grade;
		this.product_name = product_name;
		this.price_per_kg = price_per_kg;
		this.brand_name = brand_name;
		this.date_info = date_info;
		this.facility = facility;
		this.certificate = certificate;
		this.meat_information = meat_information;
	}

	public ProductDto(
			Long product_id,
			String meat_grade,
			String product_name,
			Integer price_per_kg,
			String brand_name,
			DateInfo date_info,
			Facility facility,
			Certificate certificate,
			MeatInformation meat_information
	) {
		this.product_id = product_id;
		this.meat_grade = meat_grade;
		this.product_name = product_name;
		this.price_per_kg = price_per_kg;
		this.brand_name = brand_name;
		this.date_info = date_info;
		this.facility = facility;
		this.certificate = certificate;
		this.meat_information = meat_information;
	}

	// Getter
	public Long getProduct_id() {
		return product_id;
	}

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

	public DateInfo getDate_info() {
		return date_info;
	}

	public Facility getFacility() {
		return facility;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public MeatInformation getMeat_information() {
		return meat_information;
	}

	// Setter
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
}
