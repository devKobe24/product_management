package com.donwoo.product.management.domain;

public class Certificate {
	private String traceability_number; // 이력번호
	private String certification; // 인증

	public String getTraceability_number() {
		return traceability_number;
	}

	public void setTraceability_number(String traceability_number) {
		this.traceability_number = traceability_number;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
}
