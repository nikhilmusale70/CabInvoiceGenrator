package CabInvoiceGenratorTest;

import CabInvoiceGenrator.CabInvoice;
import org.junit.Assert;
import org.junit.Test;

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
        double minimumFare = 5.0;
        double minFare = Math.max(totalFare,minimumFare);
        Assert.assertEquals(5, minFare, 0.1);
    }

    
}
