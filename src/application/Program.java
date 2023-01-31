package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	// Solução muito ruim:
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		try {
			System.out.print("Romm number: ");
			int number = scan.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next()); // propaga no main

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println();
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println();
			System.out.println("Reservation: " + reservation);
		} catch (ParseException except) {// tratamento da exceção causada pela leitura da data.
			System.out.println("Invalid date format");
		} catch (DomainException except) {
			System.out.println("Error in reservation: " + except.getMessage());
		} catch (RuntimeException except) {
			System.out.println("Unexpected error");
		}

		scan.close();
	}
}
