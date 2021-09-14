package CabInvoiceGenrator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultipleUsers<K,V> {
    public static Map<Integer, InvoiceSummary> map = new HashMap<Integer, InvoiceSummary>();

    ArrayList<InvoiceSummary> invSumObj = new ArrayList<>();

    public void storingInvoiceObjects(ArrayList<ArrayList<CabData>> users){
        CabInvoice ci = new CabInvoice();
        for (ArrayList<CabData> cd : users)
            invSumObj.add(ci.invoiceSummary(cd));

        for (int i=0; i<invSumObj.size(); i++)
            map.put(i,invSumObj.get(i));
    }

    public InvoiceSummary getInvoiceSummary(){
        int id = 1;
        System.out.println("Enter ID :- " + id);
        return map.get(id);
    }

}
