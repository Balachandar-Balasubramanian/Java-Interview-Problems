public class Main {
    public static void main(String[] args) {
        Taxi taxi1 = new Taxi("Taxi1", 'A');
        Booking booking1 = new Booking('A', 9, 'B');
        
        taxi1.acceptBooking(booking1);
        
        System.out.println("Taxi Name: " + taxi1.TaxiName);
        System.out.println("Current Location: " + taxi1.currentLoc);
        System.out.println("Total Earnings: " + taxi1.totalEarnings);
        System.out.println("Last Pickup Location: " + taxi1.pickupLoc);
        System.out.println("Last Drop Location: " + taxi1.dropLoc);
    }
}
