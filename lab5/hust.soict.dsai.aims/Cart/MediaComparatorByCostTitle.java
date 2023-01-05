package Cart;

import media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator {
    public int compare(Object o1, Object o2) {
        Media m1 = (Media) o1;
        Media m2 = (Media) o2;
        if (m1.getCost() > m2.getCost()) {
            return 1;
        } else if (m1.getCost() < m2.getCost()) {
            return -1;
        } else {
            return m1.getTitle().compareTo(m2.getTitle());
        }
    }
}
