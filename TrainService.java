package com.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainService {
	
	private static List<Train> allTrains = new LinkedList<>();
	
	static {
		allTrains.add(new Train(101,"Train-one","Hyderabad","Bangalore",100,800,LocalDate.now()));
		allTrains.add(new Train(102,"Train-two","Bangalore","Hyderabad",100,800,LocalDate.now()));
		allTrains.add(new Train(103,"Train-three","Hyderabad","Bangalore",80,600,LocalDate.now()));
		allTrains.add(new Train(104,"Train-four","Bangalore","Hyderabad",80,600,LocalDate.now()));
		allTrains.add(new Train(105,"Train-five","Hyderabad","Chennai",100,900,LocalDate.now()));
		allTrains.add(new Train(106,"Train-six","Chennai","Hyderabad",100,800,LocalDate.now()));
	}

	public TrainService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Train findTrain(int trainNumber) {
		Train temp = null;
		for(Train t : allTrains) {
			if(t.getTrainNumber()==trainNumber) {
				temp = t;
				break;
			}
		}
		return temp;
	}
	public static void searchTrainsBetweenStations(String fromStation, String toStation, LocalDate doj, int numOfSeats) {
		List<Train> searchTrainList = new LinkedList<>();
		for(Train t : allTrains) {
			if(t.getFromStation().equals(fromStation) &&
					t.getToStation().equals(toStation) &&
					t.getDoj().equals(doj) &&
					t.getSeatsAvailabe() > numOfSeats) {
				searchTrainList.add(t);
			}
		}
		if(searchTrainList.size()==0) {
			System.out.println("Sorry, no matching trains available for the search criteria..");
			
		}else {
			System.out.println("Tr.No\tTrain Name\tFrom Station\tTo Station\tDoj\tSeats Available\tFare");
			System.out.println();
			for(Train t : searchTrainList) {
				System.out.printf("%4d%20s%15s%15s%12s%4d%5d\n",t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getDoj(),t.getSeatsAvailabe(),t.getFare() );
		}
	}

}


public static void bookTickets(int trainNumber, List<Passenger> passengerList) {
	
	int numOfSeats = passengerList.size();
	/*Passenger tempPassenger = passengerList.get(0);
	BankAccount account = tempPassenger.getBankAccount();*/
	
	BankAccount account = passengerList.get(0).getBankAccount();
	Train tempTrain = findTrain(trainNumber);
	int fare = tempTrain.getFare();
	int totalFare = fare * numOfSeats;
	account.withdraw(totalFare);
	
	tempTrain.setSeatsAvailabe(tempTrain.getSeatsAvailabe()-numOfSeats);
	
	TicketService.addNewTicket(trainNumber, passengerList);
	
}
}