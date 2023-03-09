import java.util.ArrayList;

public class Train {

    //attributes
    private final Engine engine;
    private ArrayList <Car> cars;

    //constructor
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<>(nCars);
        for (int i = 0; i < nCars; i++) {
            this.cars.add(new Car(passengerCapacity));
        }
    }

    //accessor
    public Engine getEngine(){
        return engine;
    }

    public Car getCar(int i){
        return cars.get(i);
    }

    public int getMaxCapacity(){
        int maxCapacity = 0;
        for(Car c: cars){
            maxCapacity += c.getCapacity();
        }
        return maxCapacity;
    }

    public int seatsRemaining() {
        int seatsRemaining = 0;
        for (Car c : cars) {
            seatsRemaining += c.seatsRemaining();
        }
        return seatsRemaining;
    }


    public void printManifest(){
        System.out.println("Train manifest:");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + i + ":");
            cars.get(i).printManifest();
        }
    }

    public static void main(String[] args) {
        // Define some constants
        FuelType STEAM = FuelType.STEAM;
        double fuelCapacity = 100.0;
        int nCars = 3;
        int passengerCapacity = 4;
    
        // Create a train
        Train train = new Train(STEAM, fuelCapacity, nCars, passengerCapacity);
    
        // Board some passengers
        train.getCar(0).addPassenger(new Passenger("Alice"));
        train.getCar(0).addPassenger(new Passenger("Bob"));
        train.getCar(1).addPassenger(new Passenger("Charlie"));
        train.getCar(1).addPassenger(new Passenger("Dave"));
        train.getCar(2).addPassenger(new Passenger("Eve"));
    
        // Print the initial manifest
        System.out.println("Initial manifest:");
        train.printManifest();
    
        // Try to board an extra passenger
        try {
            train.getCar(2).addPassenger(new Passenger("Frank"));
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    
        // Make the train go
        System.out.println("All aboard!");
        System.out.println("Remaining fuel: " + train.getEngine().getCurrentFuelLevel());
        for (int i = 0; i < 10; i++) {
            try {
                train.getEngine().go();
                System.out.println("Remaining fuel: " + train.getEngine().getCurrentFuelLevel());
            } catch (RuntimeException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    
        // Print the final manifest
        System.out.println("Final manifest:");
        train.printManifest();
    }
    



    



}





