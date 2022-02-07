package com.sac.di3;

//VO(Value Object)
//DTO(Data Transfer Object)
//Bean(Object)
public class Car {
	
	private String model;
	private int price;
	
	public Car() {
		
	}

	public Car(String model, int price) {
		System.out.println("arg2 생성자");
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
	
	
}
