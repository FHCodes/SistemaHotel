package model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import entities.enums.typeRoom;

public class Hotel {
	private String nomeHotel;
	private String email;
	private String local;
	private typeRoom status;
	
	public Hotel() {
		
	}

	public Hotel(String nomeHotel, String email, String local) {
		this.nomeHotel = nomeHotel;
		this.email = email;
		this.local = local;
	}


	public String getNomeHotel() {
		return nomeHotel;
	}

	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	
	@Override
	public String toString() {
		return "Nome: " + nomeHotel + ", " + "\n" + "Email: " + email + ", " + "\n" + "Endereço: " + local;
	}
	
	
	
}
