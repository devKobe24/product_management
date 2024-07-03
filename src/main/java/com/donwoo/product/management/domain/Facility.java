package com.donwoo.product.management.domain;

public class Facility {
	private String processing_factory; // 가공장
	private String slaughterhouse; // 도축장

	public String getProcessing_factory() {
		return processing_factory;
	}

	public void setProcessing_factory(String processing_factory) {
		this.processing_factory = processing_factory;
	}

	public String getSlaughterhouse() {
		return slaughterhouse;
	}

	public void setSlaughterhouse(String slaughterhouse) {
		this.slaughterhouse = slaughterhouse;
	}
}
