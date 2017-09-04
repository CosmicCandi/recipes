package com.cosmiccandi.recipes.models;

public enum Unit {
	CUP ("cup"),	 			//0
	HALF_CUP ("&frac12; cup"),			//1
	THIRD_CUP ("&#8531; cup"), 			//2
	QUARTER_CUP ("&frac14; cup"),	 	//3
	EIGHTH_CUP ("&#8539; cup"),			//4
	TABLESPOON ("Tbsp."),			//5
	HALF_TABLESPOON ("&frac12; Tbsp."),	//6
	TEASPOON ("tsp."),			//7
	HALF_TEASPOON ("&frac12; tsp."),		//8
	QUARTER_TEASPOON ("&frac14; tsp."),	//9
	OUNCE ("ounce"),				//10
	PINT ("pint"),				//11
	QUART ("quart"),				//12
	LITER ("liter"),				//13
	GALLON ("gallon"),				//14
	PINCH ("pinch"),				//15
	DASH ("dash"),				//16
	DROP ("drop"),				//17
	STICK ("stick"),				//18
	WHOLE ("whole"),				//19
	HALF ("half");				//20
	
	private final String description;
	
	private Unit(String s) {
		this.description = s;
	}
	
	public String getReadableUnit() {
		return this.description;
	}
}
