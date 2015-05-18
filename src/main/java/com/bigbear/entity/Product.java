package com.bigbear.entity;

public class Product {
	public Product() {
	}
	
	private String id;
	private String name;
	private String unit;
	public Product(String id, String name, String unit) {
		this.id=id;
		this.name=name;
		this.unit=unit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
