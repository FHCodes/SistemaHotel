package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.typeRoom;

public class Management {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private Hotel hotel;
	private List<Clients> client = new ArrayList<>();

	
	public Management() {

	}

	public Management(Date moment,  Hotel hotel) {
		this.moment = moment;
		this.hotel = hotel;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void addItem(Clients cliente) {
		client.add(cliente);
	}

	public void removeItem(Clients cliente) {
		client.remove(cliente);
	}

	public double total() {
		double sum = 0;
		for (Clients cli : client) {
			sum += cli.valuePerClient();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		

		sb.append("=-=-=-=-==-=-=-=-==-=-=-=-==-=-=Informações sobre o Hotel=-=-==-=-=-=-==-=-=-=-==-=-=-=-=\n");
		sb.append(hotel + "\n");
		sb.append("Data atual:  " + sdf.format(moment) + "\n");
		sb.append("\nDados do cliente:\n");
		
		int cont = 1;
		for (Clients client : client) {
			sb.append("\n" + "Cliente #"+ cont +": "+ client + "\n");
			cont++;
		}
		sb.append("\nLucro total do hotel: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();

	}
}
