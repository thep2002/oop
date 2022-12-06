

import java.util.ArrayList;
import java.util.List;
import media.DigitalVideoDisc;
public class aism {
    private static List<DigitalVideoDisc> store;
    public static void main(String[] args) {
        Cart yourcart = new Cart();
        store = new ArrayList<>();
        store.add(new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f));
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.add(new DigitalVideoDisc("Star Wars", "Science Fiction", "87", 87, 24.95f));
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "87", 87, 24.95f);
        store.add(new DigitalVideoDisc("Aladin", "Animation",19.95f));
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",19.95f);
        yourcart.addDigitalVideoDisc(dvd1);
        yourcart.addDigitalVideoDisc(dvd2);
        yourcart.addDigitalVideoDisc(dvd3);
//        System.out.println("Total cost: "+yourcart.totalCost());
//        yourcart.printDigitalVideoDisc();
        yourcart.removeDigitalVideoDisc(store.get(1));

    }
}
