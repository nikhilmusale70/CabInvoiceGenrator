package CabInvoiceGenratorTest;

import CabInvoiceGenrator.CabData;
import CabInvoiceGenrator.CabInvoice;
import CabInvoiceGenrator.InvoiceSummary;
import CabInvoiceGenrator.MultipleUsers;
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
        double totalFare = cabInvoice.totalFare(distanceInKm, timeInMin);

        Assert.assertEquals(50.0,totalFare,0.1);

    }

    @Test   //uc2
    public void givenLessDistanceOrTime_ReturnMinFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceInKm = 0.1;
        double timeInMin = 0.1;
        double totalFare = cabInvoice.totalFare(distanceInKm, timeInMin);

        Assert.assertEquals(5, totalFare, 0.1);
    }


    ArrayList<CabData> cabData = new ArrayList<>();
    ArrayList<ArrayList<CabData>> users = new ArrayList<>();

    @Before
    public void setUp(){
        CabInvoice cabInvoice = new CabInvoice();
        MultipleUsers<K,V> mu = new MultipleUsers<K,V>();
        users.add(cabData);
        cabData.add(new CabData(10,10));
        cabData.add(new CabData(0.1,0.1));

        users.add(cabData = new ArrayList<>());
        cabData.add(new CabData(20,20));
        cabData.add(new CabData(0.2,0.2));
        cabData.add(new CabData(5,10));


        mu.storingInvoiceObjects(users);
    }

    @Test   //uc3
    public void givenMultipleRides_ReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFares(users.get(0));
        Assert.assertEquals(55, fare, 0.1);

    }

    @Test  //uc4
    public void givenMultipleRides_ReturnInvoiceSummary(){
        CabInvoice cabInvoice = new CabInvoice();
        InvoiceSummary invSum = cabInvoice.invoiceSummary(users.get(0));
        InvoiceSummary expected = new InvoiceSummary( 2,55);
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
