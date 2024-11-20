@SuppressWarnings("unused")

public class Taxi {
    String TaxiName;
    char currentLoc;
    int totalEarnings=0;
    char pickupLoc;
    char dropLoc;
    int pickupTime;
    int dropTime;

    Taxi(String Name,char currentLoc){
        this.TaxiName=Name;
        this.currentLoc=currentLoc;
        pickupTime=-1;
        dropTime=-1;
    }

    public boolean isAvailable(int pickup,int dropout){
        int startTime=this.pickupTime-(Map.travelDuration(currentLoc, pickupLoc));
        int endTime=this.dropTime;
        return (dropout<startTime) || (pickup>endTime);
    }

    
    public void collectFare(int fare){
        totalEarnings=totalEarnings+fare;
    }


    public void acceptBooking(Booking booking){
        this.pickupLoc=booking.pickupLoc;
        this.pickupTime=booking.pickupTime;
        this.dropLoc=booking.dropLoc;
        this.dropTime=booking.dropTime;
        collectFare(booking.totalFare);
    }
}
