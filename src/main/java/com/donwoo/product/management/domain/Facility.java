package com.donwoo.product.management.domain;

public class Facility {
	private Long facility_id;
	private String processing_factory; // 가공장
	private String slaughterhouse; // 도축장
	private Long product_id;

	// GETTER
	public Long getFacility_id() { return facility_id; }
	public String getProcessing_factory() {
		return processing_factory;
	}
	public String getSlaughterhouse() {
		return slaughterhouse;
	}
	public Long getProduct_id() { return product_id; }

	// SETTER
	public void setFacility_id(Long facility_id) { this.facility_id = facility_id; }
	public void setProcessing_factory(String processing_factory) { this.processing_factory = processing_factory; }
	public void setSlaughterhouse(String slaughterhouse) {
		this.slaughterhouse = slaughterhouse;
	}
	public void setProduct_id(Long product_id) { this.product_id = product_id; }
}
