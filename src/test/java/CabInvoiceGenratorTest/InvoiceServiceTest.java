package CabInvoiceGenratorTest;

import CabInvoiceGenrator.CabData;
import CabInvoiceGenrator.CabInvoice;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class InvoiceServiceTest {
    @Test
    public void givenDistance_Time_ReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceInKm = 10.0;
        double timeInMin = 10.0;
        double totalFare = cabInvoice.totalFare(distanceInKm, timeInMin);

        Assert.assertEquals(50.0,totalFare,0.1);

    }

    @Test
    public void givenLessDistanceOrTime_ReturnMinFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceInKm = 0.1;
        double timeInMin = 0.1;
        double totalFare = cabInvoice.totalFare(distanceInKm, timeInMin);

        Assert.assertEquals(5, totalFare, 0.1);
    }

    ArrayList<CabData> cabData = new ArrayList<>();
    @Test
    public void givenMultipleRides_ReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();

        cabData.add(new CabData(10,10));
        cabData.add(new CabData(0.1,0.1));

        double fare = cabInvoice.calculateFares(cabData);
        
        Assert.assertEquals(55, fare, 0.1);

    }
}
