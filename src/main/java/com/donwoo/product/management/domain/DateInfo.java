package com.donwoo.product.management.domain;

public class DateInfo {
	private Long date_info_id;
	private String manufacture_date; // 제조일
	private String use_by_date; // 소비기한
	private Long product_id;

	// Getter
	public String getManufacture_date() { return manufacture_date; }

	public String getUse_by_date() {
		return use_by_date;
	}

	public Long getDate_info_id() { return date_info_id; }

	public Long getProduct_id() { return product_id; }

	// Setter
	public void setManufacture_date(String manufacture_date) { this.manufacture_date = manufacture_date; }

	public void setUse_by_date(String use_by_date) {
		this.use_by_date = use_by_date;
	}

	public void setDate_info_id(Long date_info_id) { this.date_info_id = date_info_id; }

	public void setProduct_id(Long product_id) { this.product_id = product_id; }
}
