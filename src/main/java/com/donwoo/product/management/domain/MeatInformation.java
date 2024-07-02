package com.donwoo.product.management.domain;

public class MeatInformation {
	private Double backFat; // 등지방
	private Integer meatColor; // 육색
	private Integer maturity; // 성숙도
	private Double loinArea; // 등심면적
	private Integer fatColor; // 지방색
	private Integer ageInMonths; // 월령
	private Integer marbling; // 근내지방
	private Integer texture; // 조직감
	private String birth; // 출생일

	public Double getBackFat() {
		return backFat;
	}

	public void setBackFat(Double backFat) {
		this.backFat = backFat;
	}

	public Integer getMeatColor() {
		return meatColor;
	}

	public void setMeatColor(Integer meatColor) {
		this.meatColor = meatColor;
	}

	public Integer getMaturity() {
		return maturity;
	}

	public void setMaturity(Integer maturity) {
		this.maturity = maturity;
	}

	public Double getLoinArea() {
		return loinArea;
	}

	public void setLoinArea(Double loinArea) {
		this.loinArea = loinArea;
	}

	public Integer getFatColor() {
		return fatColor;
	}

	public void setFatColor(Integer fatColor) {
		this.fatColor = fatColor;
	}

	public Integer getAgeInMonths() {
		return ageInMonths;
	}

	public void setAgeInMonths(Integer ageInMonths) {
		this.ageInMonths = ageInMonths;
	}

	public Integer getMarbling() {
		return marbling;
	}

	public void setMarbling(Integer marbling) {
		this.marbling = marbling;
	}

	public Integer getTexture() {
		return texture;
	}

	public void setTexture(Integer texture) {
		this.texture = texture;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
}
