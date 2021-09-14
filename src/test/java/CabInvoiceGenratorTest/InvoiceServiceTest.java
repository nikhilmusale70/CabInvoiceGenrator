package CabInvoiceGenratorTest;

import CabInvoiceGenrator.CabData;
import CabInvoiceGenrator.CabInvoice;
import CabInvoiceGenrator.InvoiceSummary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class InvoiceServiceTest {
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

    @Before
    public void setUp(){
        cabData.add(new CabData(10,10));
        cabData.add(new CabData(0.1,0.1));
    }
    @Test   //uc3
    public void givenMultipleRides_ReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFares(cabData);
        Assert.assertEquals(55, fare, 0.1);

    }

    @Test
    public void givenMultipleRides_ReturnInvoiceSummary(){
        CabInvoice cabInvoice = new CabInvoice();
        InvoiceSummary invSum = cabInvoice.invoiceSummary(cabData);
        InvoiceSummary expected = new InvoiceSummary( 2,55);
        int equal =0;
        if ((expected.totalNumberOfRides == invSum.totalNumberOfRides) && (expected.totalFare == invSum.totalFare) && (expected.avgFarePerRide == invSum.avgFarePerRide))
            equal =1;

        Assert.assertEquals(1, equal);
    }


}
