package media;
import Cart.*;
import java.util.Comparator;

public abstract class Media {
    public Media(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;

    }

    public static final Comparator<Media> COM_PARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COM_PARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media media = (Media) obj;
            if (this.title.equals(media.title) && this.category.equals(media.category)) {
                return true;
            }
        }
        return false;
    }
    public void play(){
        System.out.println("Playing Media: " + this.getTitle());

    }
}
