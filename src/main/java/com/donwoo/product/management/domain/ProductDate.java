package com.donwoo.product.management.domain;

public class ProductDate {
	private String manufactureDate; // 제조일
	private String useByDate; // 소비기한

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getUseByDate() {
		return useByDate;
	}

	public void setUseByDate(String useByDate) {
		this.useByDate = useByDate;
	}
}
