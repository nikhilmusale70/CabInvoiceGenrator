package CabInvoiceGenrator;

public class Rate {
    int normalRatePerKM;
    int normalRatePerMIN;
    int normalMinFare;

    int premiumRatePerKM;
    int premiumRatePerMIN;
    int premiumMinFare;

    public Rate(int normalRatePerKM, int normalRatePerMIN, int normalMinFare ,int premiumRatePerKM, int premiumRatePerMIN, int premiumMinFare ) {
        this.normalRatePerKM = normalRatePerKM;
        this.normalRatePerMIN = normalRatePerMIN;
        this.normalMinFare = normalMinFare;

        this.premiumRatePerKM = premiumRatePerKM;
        this.premiumRatePerMIN = premiumRatePerMIN;
        this.premiumMinFare = premiumMinFare;

    }
}
