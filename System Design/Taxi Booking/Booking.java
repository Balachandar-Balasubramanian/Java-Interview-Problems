
@SuppressWarnings("unused")

public class Booking {
    char pickupLoc;
    int pickupTime;
    char dropLoc;
    int dropTime;
    String taxi;
    int totalFare;


    Booking(char pickupLoc,int pickupTime,char dropLoc){
        this.pickupLoc=pickupLoc;
        this.pickupTime=pickupTime;
        this.dropLoc=dropLoc;
        this.dropTime=pickupTime+Map.travelDuration(pickupLoc, dropLoc);
        totalFare=Map.calculateFare(pickupLoc, dropLoc);        
    }

    

}
