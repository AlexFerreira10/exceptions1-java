package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	// throws ParseException propaga uma excessao sem tratar
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		System.out.print("Room number:  ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy):");
		Date checkOut = sdf.parse(sc.next());
		
		//Keep, because there isn't way to make the constructor return a string
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservaon: " + reservation);

			System.out.println();

			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();

			
			String error = reservation.update(checkIn, checkOut);
			if(error != null) {
				System.out.print("Error in reservation: " + error);
			}
			else {
				System.out.println("Reservaon: " + reservation);
			}
			
			
			sc.close();
		}

	}
}
