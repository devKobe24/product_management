package com.donwoo.product.management.domain;

public class Certificate {
	private Long certificate_id;
	private String traceability_number; // 이력번호
	private String certification; // 인증
	private Long product_id;

	// GETTER
	public Long getCertificate_id() { return certificate_id; }
	public String getTraceability_number() {
		return traceability_number;
	}
	public String getCertification() {
		return certification;
	}
	public Long getProduct_id() { return product_id; }

	// SETTER
	public void setCertificate_id(Long certificate_id) { this.certificate_id = certificate_id; }
	public void setTraceability_number(String traceability_number) { this.traceability_number = traceability_number; }
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public void setProduct_id(Long product_id) { this.product_id = product_id; }
}
