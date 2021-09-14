package CabInvoiceGenrator;

import java.util.Map;

public class CabData {
    double distance;
    double timeInMin;
    RideType rideType;

    public CabData(double distance, double timeInMin, RideType rideType) {
        this.distance = distance;
        this.timeInMin = timeInMin;
        this.rideType = rideType;
    }
}
