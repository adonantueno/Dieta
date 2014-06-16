package com.example.dieta.utils;

import android.widget.RadioButton;

public class Validator {
	String name;
	String years;
	String weight;
	String height;
	RadioButton gain;
	RadioButton lose;
	
	public Validator(String name, String years, String weight, String height, RadioButton gain, RadioButton lose) {
		this.name = name;
		this.years = years;
		this.weight = weight;
		this.height = height;
		this.gain = gain;
		this.lose = lose;
	}
	
	public boolean validate() {
		if ((name.length() != 0) && (years.length() != 0) && (weight.length() != 0) && (height.length() != 0) && (gain.isChecked() || lose.isChecked())) {
			return true;
		}
		return false;
	}
	
}