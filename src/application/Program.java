package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.enums.typeRoom;
import model.entities.Clients;
import model.entities.Hotel;
import model.entities.Management;
import model.entities.Rooms;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Preenchendo o nome do hotel
		try {
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

				// Cadastramento de quartos
				System.out.println();
				System.out.println("=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=DADOS DO QUARTOL=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=");
				System.out.print("Entre com o numero do quarto do cliente #" + i + ": ");
				sc.nextLine();
				String roomName = sc.nextLine();
				System.out.print("Entre com o preço do quarto: ");
				double price = sc.nextDouble();
				System.out.print("tipo do quarto(casal/solteiro): ");
				typeRoom type = typeRoom.valueOf(sc.next().toUpperCase());

				Rooms room = new Rooms(roomName, price, type);

				// Cadastramento de clientes
				System.out.println();
				System.out.println("=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=DADOS DO CLIENTE=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=");
				System.out.println("Entre com os dados do cliente #" + i + ": ");
				System.out.print("Nome do cliente: ");
				sc.nextLine();
				String clientName = sc.nextLine();
				System.out.print("Cpf: ");
				String cpf = sc.next();
				System.out.print("Data de Check-in (dd/MM/yyyy): ");
				Date checkIn = sdf.parse(sc.next());
				System.out.print("Data de Check-out (dd/MM/yyyy): ");
				Date checkOut = sdf.parse(sc.next());
				System.out.println();

				Clients client = new Clients(clientName, cpf, room, checkIn, checkOut);

				management.addItem(client);
			}
			System.out.println();
			System.out.println(management);
		}

		catch (ParseException e) {
			System.out.println("Formato invalido de data: ");
		} catch (Exception e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}

		sc.close();
	}
}
