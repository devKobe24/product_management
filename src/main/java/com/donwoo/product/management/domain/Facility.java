package com.donwoo.product.management.domain;

public class Facility {
	private String processingFactory; // 가공장
	private String slaughterhouse; // 도축장

	public String getProcessingFactory() {
		return processingFactory;
	}

	public void setProcessingFactory(String processingFactory) {
		this.processingFactory = processingFactory;
	}

	public String getSlaughterhouse() {
		return slaughterhouse;
	}

	public void setSlaughterhouse(String slaughterhouse) {
		this.slaughterhouse = slaughterhouse;
	}
}
