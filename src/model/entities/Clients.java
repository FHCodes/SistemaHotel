package model.entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.Exception;

public class Clients {

	private String clientName;
	private String cpf;
	private Integer days;
	private Rooms room;
	private Date checkIn;
	private Date checkOut;

	public Clients() {

	}

	public Clients(String clientName, String cpf, Rooms room, Date checkIn, Date checkOut) throws Exception {
		this.clientName = clientName;
		this.cpf = cpf;
		this.room = room;

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new Exception("As datas de reserva devem ser datas futuras");
		}
		if (!checkOut.after(checkIn)) {
			throw new Exception("A data de Check-out deve ser maior que a data de Check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public double valuePerClient() {
		return duration() * getRoom().getPrice();

	}

	@Override
	public String toString() {
		return "\n" + "Classificação do quarto: " + getRoom().getType() + "| Numero do quarto: " + getRoom().getName()
				+ "| Nome do cliente:  " + clientName + "| CPF:  " + cpf + " |" + "Permanencia: " + duration() + "dias"
				+ "| Preço do quarto: " + getRoom().getPrice() + "R$ | Valor gasto: " + "Subtotal: $"
				+ String.format("%.2f", valuePerClient());
	}
}
