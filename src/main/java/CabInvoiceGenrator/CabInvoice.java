package CabInvoiceGenrator;

public class CabInvoice {

    public static final double costPerTime = 1.0;
    public static final double costPerKm = 4.0;

    public double totalFare(double distanceInKm, double timeInMin){
        double totalPrice = distanceInKm*costPerKm + timeInMin*costPerTime;
        return totalPrice;
    }
}
