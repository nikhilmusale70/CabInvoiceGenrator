package CabInvoiceGenrator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public InvoiceSummary invoiceSummary(ArrayList<CabData> cabData){

        int numberOfRides = cabData.size();
        double totalFare = calculateFares(cabData);

        return new InvoiceSummary(numberOfRides, totalFare);
    }

    public void printDetailsFromInvoice(InvoiceSummary is){
        System.out.println("Total Number of rides :- " + is.totalNumberOfRides);
        System.out.println("Total fare of ride :- " + is.totalFare);
        System.out.println("Average fare of ride :- " + is.avgFarePerRide);
    }
}
