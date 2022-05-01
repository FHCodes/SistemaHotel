package entities;

public class Clients {
	
	private String clientName;
	private String cpf;
	private Integer days;
	private Rooms room;
	
	
	
	public Clients() {
		
	}
	
	public Clients(String clientName, String cpf, Integer days, Rooms room) {
		this.clientName = clientName;
		this.cpf = cpf;
		this.days = days;
		this.room = room;
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

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}
	
	public double valuePerClient() {
		return days * getRoom().getPrice();
		
	}
	
	@Override
	public String toString() {
		return "\n" + "Classificação do quarto: " + getRoom().getType() + "| Numero do quarto: " + getRoom().getName() 
				+ "| Nome do cliente:  " + clientName + "| CPF:  " + cpf +" |"
				+ "Permanencia:" + days + "horas" + "| Preço do quarto: " + getRoom().getPrice() 
				+ "R$ | Valor gasto: "  
				+ "Subtotal: $" + String.format("%.2f", valuePerClient());
	}
}
