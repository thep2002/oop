import java.util.ArrayList;
import java.util.List;

public class store {
    public static final int MAX_NUMBER_ORDER = 20;
    private int qtyStore =0;
    public List<DigitalVideoDisc> itemsAvailable= new ArrayList<>(MAX_NUMBER_ORDER);
    public void addDVD(DigitalVideoDisc dsc){
        if(qtyStore>=MAX_NUMBER_ORDER){
            System.out.println("Store is full!");
        }
        else{
            itemsAvailable.add(dsc);
            System.out.println("DSC added !");
        }
    }
    public void removeDVD(DigitalVideoDisc dsc){
        String name = dsc.getTitle();
        for(DigitalVideoDisc item : itemsAvailable){
            if(item.getTitle().equals(name)){
                itemsAvailable.remove(dsc);
                System.out.println("Deleted");
                return;
            }
        }
        System.out.println("Elememnt  is not exist");
    }
}

