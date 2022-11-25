import java.util.ArrayList;
import java.util.List;

public class ScoreTest {
    public static void main(String[] args) {
        store newstore = new store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "87", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",19.95f);
        newstore.addDVD(dvd1);
        newstore.addDVD(dvd2);
        newstore.addDVD(dvd3);
        newstore.removeDVD(dvd2);

        }
}
