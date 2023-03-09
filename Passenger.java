public class Passenger {
    
    //attribute
    private String name;

    public Passenger(String name) {
        this.name = name;
    }


    //boarding method
    public void boardCar(Car c){
        c.addPassenger(this);
        try {
            c.addPassenger(this);
        } catch (Exception e) {
            System.out.println("Maybe come back tmrw to check if there are any empty cars?");
        }
    }

    //getting off method
    public void getOffCar(Car c){
        c.removePassenger(this);
        try {
            c.removePassenger(this);
        } catch (Exception e) {
            System.out.println("It could be that this person is in other cars currently, or he/she/them is not on this train at all.");
        }
    }
}
