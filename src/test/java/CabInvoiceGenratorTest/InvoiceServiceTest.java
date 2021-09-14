package CabInvoiceGenratorTest;

import CabInvoiceGenrator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvoiceServiceTest<K, V> {
    @Test   //uc1
    public void givenDistance_Time_ReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceInKm = 10.0;
        double timeInMin = 10.0;
        double totalFare = cabInvoice.totalFare(distanceInKm, timeInMin, RideType.NORMAL_RIDE);
        Assert.assertEquals(110.0,totalFare,0.1);

    }

    @Test   //uc2
    public void givenLessDistanceOrTime_ReturnMinFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceInKm = 0.1;
        double timeInMin = 0.1;
        double totalFare = cabInvoice.totalFare(distanceInKm, timeInMin,RideType.NORMAL_RIDE);
        Assert.assertEquals(5, totalFare, 0.1);
    }


    ArrayList<CabData> cabData = new ArrayList<>();
    ArrayList<ArrayList<CabData>> users = new ArrayList<>();
    public Rate rate = new Rate(10,1,5,15,2,20);

    @Before
    public void setUp(){
        CabInvoice cabInvoice = new CabInvoice();
        MultipleUsers mu = new MultipleUsers();

        users.add(cabData);
        cabData.add(new CabData(10,10, RideType.NORMAL_RIDE ));
        cabData.add(new CabData(0.1,0.1, RideType.NORMAL_RIDE));

        users.add(cabData = new ArrayList<>());
        cabData.add(new CabData(20,20,RideType.PREMIUM_RIDE));
        cabData.add(new CabData(0.2,0.2,RideType.NORMAL_RIDE));
        cabData.add(new CabData(5,10,RideType.PREMIUM_RIDE));

        mu.storingInvoiceObjects(users);
    }

    @Test   //uc3
    public void givenMultipleRides_ReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFares(users.get(0));
        Assert.assertEquals(115, fare, 0.1);

    }

    @Test  //uc4
    public void givenMultipleRides_ReturnInvoiceSummary(){
        CabInvoice cabInvoice = new CabInvoice();
        InvoiceSummary invSum = cabInvoice.invoiceSummary(users.get(0));
        InvoiceSummary expected = new InvoiceSummary( 2,115);
        int equal =0;
        if ((expected.totalNumberOfRides == invSum.totalNumberOfRides) && (expected.totalFare == invSum.totalFare) && (expected.avgFarePerRide == invSum.avgFarePerRide))
            equal =1;

        Assert.assertEquals(1, equal);
    }

    @Test
    public void givenID_ReturnSummaryObject(){
        CabInvoice cabInvoice = new CabInvoice();
        MultipleUsers<K,V> mu = new MultipleUsers<K,V>();
        InvoiceSummary is = mu.getInvoiceSummary();

        cabInvoice.printDetailsFromInvoice(is);

    }

}
