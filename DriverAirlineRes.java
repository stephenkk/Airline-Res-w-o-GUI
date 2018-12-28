//STEPHEN GARY KOFFLER
public class DriverAirlineRes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AirlineRes flight = new AirlineRes();
	
		
		while (flight.getSeatsRemain()==true) {
			flight.readNextCustomerInput();
		if (flight.getCabin() == true) {
			flight.assignFirstClass();
			System.out.println();
		}
		else
			flight.assignCoachClass();
			System.out.println();
			flight.planeNotFull();
		}
		
		System.out.println("The flight is full. The next flight departs in 3 hours.");
		
		
	}

}
