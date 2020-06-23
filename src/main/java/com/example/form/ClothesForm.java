package com.example.form;
/**
 * 入力情報
 * @author tatsuro.miyazaki
 *
 */
public class ClothesForm {
	/**性別	 */
	private String gender = "0";
	/**色	 */
	private String color;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "ClothesForm [gender=" + gender + ", color=" + color + "]";
	}
	
	
}
