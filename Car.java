import java.util.ArrayList;

public class Car {

    //attributes
    private ArrayList <Passenger> passengerOnboard;
    private int maxCapacity;

    //constructor
    public Car(int maxCapacity) {
        passengerOnboard = new ArrayList<>(maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    //accessor-like methods
    public int getCapacity(){
        return maxCapacity;
    }

    public int seatsRemaining(){
        return maxCapacity - passengerOnboard.size();
    }
    
    //methods
    //add a passenger to the car
    public void addPassenger(Passenger p) {
        if (seatsRemaining() > 0) {
            passengerOnboard.add(p);
        } else {
            throw new RuntimeException("This car is full. Cannot add passenger. ");
        }
    }

    //remove a passenger from the car
    public void removePassenger(Passenger p) {
        if (passengerOnboard.contains(p)) {
            passengerOnboard.remove(p);
        } else {
            throw new RuntimeException("Passenger " + " is not on this car.");
        }
    }

    public void printManifest(){
        if(seatsRemaining() == 0){
            System.out.println("This car is EMPTY.");
        }
        //print out each element in the ArrayList
        for (int i = 0; i < passengerOnboard.size();i++) 
	      { 		      
	          System.out.println(passengerOnboard.get(i)); 		
	      }   
    }
    
    
    
}