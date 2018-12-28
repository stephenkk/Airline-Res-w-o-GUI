//STEPHEN GARY KOFFLER
//This airline reservation system will operate in similar fashion to self service
//kiosks at the airport. Customers have the option to choose first class or coach
//based on availability, can decline to travel if the desired class of service is
//unavailable, or choose to travel in the class of service with seats remaining.
//Customers who decline to travel will be informed the next flight departs in 3 hours.
//Boarding passes will be printed for travelers. Once the customer has made his/her choices 
//and is done with the session, the seat selection prompt will re-appear for the next customer. 
//Once the flight is full, the prompt will be replaced by a message stating that the flight 
//is now full and that the next flight will depart in three hours.


import java.util.Scanner;
public class AirlineRes {
	private boolean seats[];			//array for the seats on the plane.
	private boolean cabin;			//first class is cabin == true. coach is cabin == false.
	private int seatingChoice;				//takes in 1 or 2 for first class or coach respectively.
	private boolean seatsRemain;	//seatsRemain == true means there are still seats available.
	private int firstClassSeat;		//finds the next assignable element in the array seats (FC)
	private int coachClassSeat;		//finds the next assignable element in the array seats (coach)
	Scanner keyboard = new Scanner(System.in);
	
	public AirlineRes () {	//Constructor
		cabin = false;
		seatingChoice=0;
		int size = 11;				// size 11 to avoid out of range error in assignCoach method
		seats = new boolean[size];
		seatsRemain = true;
		firstClassSeat = 0;
		coachClassSeat =5;
	}
	
	public void readNextCustomerInput() {	//reads customer input and converts to boolean
		System.out.println("There are seats available on this flight."
				+ " Enter 1 for first class or 2 for coach.");
		seatingChoice = keyboard.nextInt();
		if (seatingChoice != 1 && seatingChoice != 2) {
			System.out.println("Invalid Entry.");	//entries other than 1 or 2 are invalid.
			readNextCustomerInput();
		}else if (seatingChoice == 1)
			cabin = true;
			else cabin = false;
	}
		public void setCabin (boolean newCabin) {
			cabin = newCabin;
	}
		
		public boolean getCabin() {
			return cabin;
		}
		
		public void setSeatsRemain (boolean newSeatsRemain) {
			seatsRemain = newSeatsRemain;
		}
		
		public boolean getSeatsRemain (){
		
			return seatsRemain;
		}
		
		public String toString() {		//toString is NOT used in the main method.
	return ("Your seating choice: " + seatingChoice + " First class cabin? " +cabin
					+ " First Class seat is " + firstClassSeat +""
							+ " Coach Class seat is " + coachClassSeat);
			
		}
		
		public boolean planeNotFull() {	//Method to determine if seats remain after each assignment.
			int index=0;			//local variable to move through array elements
			seatsRemain=false;
			while (index <= 9) {
				if (seats[index]==false) {
					index++;
					seatsRemain=true;
					break;}
				else 
					index++;				
			}
			return seatsRemain;		//seatsRemain == true means seats are still available in at least
									//one class of service.
		}
		
		public void assignFirstClass () {//Assigns a seat in first class based on customer choice
				firstClassSeat=0;			//offers coach (if available) if 1st is not available
				
				while (seats[firstClassSeat] != false && firstClassSeat <= 4) {
					firstClassSeat++;
				}if (firstClassSeat <= 4) {
				seats[firstClassSeat] = true;//array element set to true as seat is now assigned.
				
				System.out.println("Your seat is #" + (firstClassSeat + 1) +" in first class."
						+ " Your boarding pass is printed below.");
				System.out.println();
				printBoardingPassFC();
				}
				else if (seatsRemain == true) {
					int secondChoice;		//local var to give customer the option of the other class
				System.out.println("The first class cabin is full. "
						+ " Would you like to travel in coach class?"
						+ " Enter 1 for yes or 2 for no.");
				secondChoice = keyboard.nextInt();
				if (secondChoice == 1) 					
					assignCoachClass();
				else System.out.println("The next flight departs in 3 hours.");
				}
				
			}
			public void assignCoachClass () {//Assigns a seat in coach based on customer choice
				coachClassSeat=5;				//offers 1st class (if available) if coach is not available
				
					while (seats[coachClassSeat] != false && coachClassSeat <= 9) {
						coachClassSeat++;
					}
					
					if (coachClassSeat <= 9) {
					seats[coachClassSeat] = true;//array element set to true as seat is now assigned.
					System.out.println("Your seat is #" + (coachClassSeat + 1) +" in the coach cabin."
							+ " Your boarding pass is printed below.");
					System.out.println();
					printBoardingPassCoach();
					}
					else if (seatsRemain = true) {
						int secondChoice;	//local var to give customer the option of the other class
					System.out.println("The coach class cabin is full."
							+ " Would you like to travel in first class?"
							+ " Enter 1 for yes or 2 for no.");
					secondChoice = keyboard.nextInt();
					if (secondChoice == 1) 					
						assignFirstClass();
					else System.out.println("The next flight departs in 3 hours.");
					}
			
			}

			public void printBoardingPassFC() {
System.out.println("**********************************************");
System.out.println("*                                            *");
System.out.println("*                                            *");
System.out.println("*  You are seated in the first class cabin.  *");
System.out.println("*  Your seat number is " + (firstClassSeat + 1) +"                     *");
System.out.println("*                                            *");
System.out.println("*                                            *");
System.out.println("**********************************************");
			
			}
			public void printBoardingPassCoach() {
System.out.println("**********************************************");
System.out.println("*                                            *");
System.out.println("*                                            *");
System.out.println("*  You are seated in the coach class cabin.  *");
System.out.println("*  Your seat number is " + (coachClassSeat + 1) +"                     *");
System.out.println("*                                            *");
System.out.println("*                                            *");
System.out.println("**********************************************");
			
			}
		
}
