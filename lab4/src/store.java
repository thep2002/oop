
import java.util.ArrayList;
import media.*;

public class store {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void add(Media media) {
        if (itemsInStore.size() < MAX_NUMBERS_ORDERED) {
            itemsInStore.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The store is almost full");
        }
    }

    public void remove(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media is not in the store");
        }
    }

    // display store
    public void displayStore() {
        System.out.println("************************Store************************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println("       " + itemsInStore.get(i).getTitle());
        }
        System.out.println("*****************************************************");
    }

    public Media searchByTitle(String title) {
        // upper and lower case
        title = title.toLowerCase();
        for (int i = 0; i < itemsInStore.size(); i++) {
            // lower title
            String lowerTitle = itemsInStore.get(i).getTitle().toLowerCase();
            if (lowerTitle.equals(title)) {
                return itemsInStore.get(i);
            }
        }
        return null;
    }

}