package com.mgs.vehicle;

public class House implements Paintable {
	private String color;
	
	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setColor(String value) {
		color = value;
	}

	public String toString()
	{
		return "A House that is " + color;
	}
}
