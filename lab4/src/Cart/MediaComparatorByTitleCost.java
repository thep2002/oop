package Cart;
import java.util.Comparator;
import media.Media;
public class MediaComparatorByTitleCost implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Media m1 = (Media) o1;
        Media m2 = (Media) o2;
        if (m1.getTitle().compareTo(m2.getTitle()) > 0) {
            return 1;
        } else if (m1.getTitle().compareTo(m2.getTitle()) < 0) {
            return -1;
        } else {
            if (m1.getCost() > m2.getCost()) {
                return 1;
            } else if (m1.getCost() < m2.getCost()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
