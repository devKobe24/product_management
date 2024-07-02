package com.donwoo.product.management.domain;

public class Certificate {
	private String traceabilityNumber; // 이력번호
	private String certification; // 인증

	public String getTraceabilityNumber() {
		return traceabilityNumber;
	}

	public void setTraceabilityNumber(String traceabilityNumber) {
		this.traceabilityNumber = traceabilityNumber;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
}
