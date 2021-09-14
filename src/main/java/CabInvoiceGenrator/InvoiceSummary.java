package CabInvoiceGenrator;

public class InvoiceSummary {
    public int totalNumberOfRides;
    public double totalFare;
    public double avgFarePerRide;

    public InvoiceSummary(int totalNumberOfRides, double totalFare) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFare = totalFare;
        this.avgFarePerRide = totalFare/totalNumberOfRides;
    }


}
