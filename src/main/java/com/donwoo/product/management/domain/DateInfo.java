package com.donwoo.product.management.domain;

public class DateInfo {
	private Long date_id;
	private String manufacture_date; // 제조일
	private String use_by_date; // 소비기한
	private Long product_id;

	public DateInfo(
			Long date_id,
			String manufacture_date,
			String use_by_date,
			Long product_id
	) {
		this.date_id = date_id;
		this.manufacture_date = manufacture_date;
		this.use_by_date = use_by_date;
		this.product_id = product_id;
	}


	// Getter
	public String getManufacture_date() { return manufacture_date; }

	public String getUse_by_date() {
		return use_by_date;
	}

	public Long getDate_id() { return date_id; }

	public Long getProduct_id() { return product_id; }

	// Setter
	public void setManufacture_date(String manufacture_date) { this.manufacture_date = manufacture_date; }

	public void setUse_by_date(String use_by_date) {
		this.use_by_date = use_by_date;
	}

	public void setDate_id(Long date_id) { this.date_id = date_id; }

	public void setProduct_id(Long product_id) { this.product_id = product_id; }
}
