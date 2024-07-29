package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
        try {
			System.out.print("Numero do quarto: ");
			int number = sc.nextInt();
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
		    Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Mude a reserva");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
		    reservation.updateDates(checkIn, checkOut);
		    System.out.println(reservation);
			
        }
        catch(ParseException e) {
        	System.out.println("Data invalida");
			sc.close();
        }
        catch (DomainException e) {
        	System.out.println("Error in reservation: " + e.getMessage());

		}
        catch(RuntimeException e) {
        	System.out.println("Unexpected error");
        }

	}

}
