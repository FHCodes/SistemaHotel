package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Clients;
import entities.Management;
import entities.Hotel;
import entities.Rooms;
import entities.enums.typeRoom;


public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Preenchendo o nome do hotel

		System.out.println("=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=-DADOS DO HOTEL-=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=");
		System.out.print("Nome: ");
		String nameHotel = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		sc.nextLine();
		System.out.print("Entre com o endereço: ");
		String address = sc.nextLine();

		Hotel hotel = new Hotel(nameHotel, email, address);


		// Preenchendo o nome dos clientes
		
		Management management = new Management(new Date(), hotel);
		
		System.out.print("Quantos clientes tem? ");
		int clientNumber = sc.nextInt();

		for (int i = 1; i <= clientNumber; i++) {
			
			
			//Cadastramento de quartos
			System.out.println();
			System.out.println("=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=DADOS DO QUARTOL=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=");
			System.out.print("Entre com o numero do quarto do cliente #" + i +": ");
			sc.nextLine();
			String roomName = sc.nextLine();
			System.out.print("Entre com o preço do quarto: ");
			double price = sc.nextDouble();
			System.out.print("tipo do quarto(casal/solteiro): ");
			typeRoom type = typeRoom.valueOf(sc.next().toUpperCase());      
					
			
			Rooms room = new Rooms(roomName, price, type);
			
			//Cadastramento de clientes
			System.out.println();
			System.out.println("=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=DADOS DO CLIENTE=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=");
			System.out.println("Entre com os dados do cliente #" + i + ": " );
			System.out.print("Nome do cliente: ");
			sc.nextLine();
			String clientName = sc.nextLine();
			System.out.print("Cpf: ");
			String cpf = sc.next();
			System.out.print("Quantidade de dias: ");
			int days = sc.nextInt();
			System.out.println();
			
			Clients client = new Clients(clientName, cpf, days, room);
			
			management.addItem(client);	
		}
		
		System.out.println();
		System.out.println(management);
		
		sc.close();
	}
}
