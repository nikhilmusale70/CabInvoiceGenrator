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
}
