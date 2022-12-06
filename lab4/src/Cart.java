
import java.util.ArrayList;
import java.util.List;
import media.DigitalVideoDisc;
import media.book;
public class Cart {
    public static final int MAX_NUMBER_ORDER = 20;
    private List<DigitalVideoDisc> itemsOrdered;
    private int quantity;
    private List<book> Author = new ArrayList<book>();
    public Cart() {
        quantity = 0;
        itemsOrdered = new ArrayList<>(MAX_NUMBER_ORDER);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (quantity>=MAX_NUMBER_ORDER){
            System.out.println("Full order");
            return;
        }
        else
        {
            quantity++;
            itemsOrdered.add(disc);
            System.out.println("The item has added");
        }
        return;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (quantity==0){
            System.out.println("Have no order");
        }
        String name = disc.getTitle();
        for(DigitalVideoDisc item : itemsOrdered){
            if(item.getTitle().equals(name)){
                itemsOrdered.remove(item);
                System.out.println("Your item has been removed");
                return;
            }
        }
        System.out.println("The item not found");
    }
//    public float totalCost() {
//        float sum = 0;
//        for(DigitalVideoDisc item : itemsOrdered) {
//            sum += item.getCost();
//        }
//        return sum;
//    }
//    public void printDigitalVideoDisc() {
//        int i = 0;
//        System.out.println("*************************\n");
//        for (DigitalVideoDisc item : itemsOrdered) {
//            i++;
//            System.out.println(i + ".DVD - " + item.getTitle() + " " + item.getCategory() + " " + item.getDirector() + " " + item.getLength() + " " + item.getCost() + "\n");
//        }
//        System.out.println(totalCost() + "\n");
//        System.out.println("*************************\n");
//    }

}
