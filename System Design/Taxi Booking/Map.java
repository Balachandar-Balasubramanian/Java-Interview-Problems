

public class Map {

    public static int travelDuration(char pickup,char dropout){
        return dropout-pickup;
    }
    public static int calculateFare(char pickupLoc,char dropLoc){
        int distance=((dropLoc - pickupLoc)*15)-5; 
        int fare = 100;
        fare=fare+ ((distance>0)?(distance*10):0); 
        return fare;
       }
}
