package CabInvoiceGenrator;

import java.util.ArrayList;

public class CabInvoice {

    public static final double costPerTime = 1.0;
    public static final double costPerKm = 4.0;

    public double totalFare(double distanceInKm, double timeInMin){
        double totalPrice = distanceInKm*costPerKm + timeInMin*costPerTime;
        return Math.max(totalPrice,5.0);
    }

    public double calculateFares(ArrayList<CabData> cabData) {
        double fare = 0;
        for (CabData cd : cabData){
            fare += totalFare(cd.distance,cd.timeInMin);
        }

        return fare;
    }
}
