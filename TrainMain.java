package com.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainMain {
public static void main(String[] args) {
	
	System.out.println("Now searching for trains....");
	TrainService.searchTrainsBetweenStations("Hyderabad","Bangalore", LocalDate.now(), 10);	
	
	BankAccount b1 = new BankAccount();
	b1.setActNumber(999);
	b1.setActBalance(10000);
	
	
	Passenger p1 = new Passenger(10, "Amit", 69, b1);
	Passenger p2 = new Passenger(20, "Ankit", 38, b1);
	Passenger p3 = new Passenger(10, "Sumit", 39, b1);
	
	int initialBalance = b1.getActBalance();
	
	List<Passenger>passengerList = new LinkedList<>();
	
	passengerList.add(p1);
	passengerList.add(p2);
	passengerList.add(p3);
	
	System.out.println("Now booking tickets for 3 passengers in train number 101...");
	
	
	TrainService.bookTickets(101, passengerList);
	
	System.out.println("Now printing the ticket details...");
	
	TicketService.showTicketDetails(1);
	
	System.out.println("\n\n");
	TrainService.searchTrainsBetweenStations("Hyderabad","Bangalore", LocalDate.now(), 10);	
	
	int balanceAfterBookingTickets = b1.getActBalance();
	
	System.out.println("Initial balance = " + initialBalance);
	System.out.println("Balance after booking = "+ balanceAfterBookingTickets);
	
}
}