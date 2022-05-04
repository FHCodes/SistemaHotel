package model.entities;

import entities.enums.typeRoom;

public class Rooms {

	private String name;
	private Double price;
	private typeRoom type;

	public Rooms() {

	}

	public Rooms(String name, Double price, typeRoom type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public typeRoom getType() {
		return type;
	}

	public void setType(typeRoom type) {
		this.type = type;
	}

}
