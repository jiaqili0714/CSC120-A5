public class Engine {

private FuelType f;
double currentFuelLevel;
double maxFuelLevel;

public Engine(FuelType fuelType, double fuelCapacity) {
    this.f = fuelType;
    this.currentFuelLevel = fuelCapacity;
}

//accessors

//get fuel type
public FuelType getFuelType(){
    return f;
}

//get the current fuel level
public double getCurrentFuelLevel(){
    return currentFuelLevel;
}

//get the max fuel level
public double getMaxFuelLevel(){
    return maxFuelLevel;
}

//constructors
public void setFuelType(FuelType f){
    this.f = f;
}

public void setCurrentFuelLevel(double currentFuelLevel){
    this.currentFuelLevel = currentFuelLevel;
}

public void setMaxFuelLevel(double maxFuelLevel){
    this.maxFuelLevel = maxFuelLevel;
}

//methods

// set the current fuel level to max level
public void refuel(){
    currentFuelLevel = maxFuelLevel;
}

//make the train go and decrease current 
public void go(){
    if (currentFuelLevel > 0) {
        System.out.println("Remaining fuel level: " + currentFuelLevel);
        currentFuelLevel -= 1;
    } else {
        //print out error message
        throw new RuntimeException("Engine has run out of fuel!");
    }
}
}