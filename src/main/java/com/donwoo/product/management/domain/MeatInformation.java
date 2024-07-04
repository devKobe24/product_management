package com.donwoo.product.management.domain;

public class MeatInformation {
	private Long meat_info_id;
	private Double back_fat; // 등지방
	private Integer meat_color; // 육색
	private Integer maturity; // 성숙도
	private Double loin_area; // 등심면적
	private Integer fat_color; // 지방색
	private Integer age_in_months; // 월령
	private Integer marbling; // 근내지방
	private Integer texture; // 조직감
	private String birth; // 출생일
	private Long product_id;

	// GETTER
	public Long getMeat_info_id() { return meat_info_id; }
	public Double getBack_fat() {
		return back_fat;
	}
	public Integer getMeat_color() {
		return meat_color;
	}
	public Integer getMaturity() {
		return maturity;
	}
	public Double getLoin_area() {
		return loin_area;
	}
	public Integer getFat_color() {
		return fat_color;
	}
	public Integer getAge_in_months() {
		return age_in_months;
	}
	public Integer getMarbling() {
		return marbling;
	}
	public Integer getTexture() {
		return texture;
	}
	public String getBirth() {
		return birth;
	}
	public Long getProduct_id() { return product_id; }

	// SETTER
	public void setMeat_info_id(Long meat_info_id) { this.meat_info_id = meat_info_id; }
	public void setBack_fat(Double back_fat) {
		this.back_fat = back_fat;
	}
	public void setMeat_color(Integer meat_color) {
		this.meat_color = meat_color;
	}
	public void setMaturity(Integer maturity) {
		this.maturity = maturity;
	}
	public void setLoin_area(Double loin_area) {
		this.loin_area = loin_area;
	}
	public void setFat_color(Integer fat_color) {
		this.fat_color = fat_color;
	}
	public void setAge_in_months(Integer age_in_months) {
		this.age_in_months = age_in_months;
	}
	public void setMarbling(Integer marbling) {
		this.marbling = marbling;
	}
	public void setTexture(Integer texture) {
		this.texture = texture;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setProduct_id(Long product_id) { this.product_id = product_id; }
}
