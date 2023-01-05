package media;

import java.util.ArrayList;
import java.util.List;

public class book extends Media{
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public book(String title, String category, float cost) {

        super(title, category, cost);
    }
    public List<String> getAuthor() {
        return authors;
    }


    public void setAuthor(String authorName){
        if(!this.authors.contains(authorName)){
            this.authors.add(authorName);
        }
        else{
            System.out.println("The author is already exits");
        }
    }
    public void removeAuthor(String authorName){
        if(this.authors.contains(authorName)){
            this.authors.remove(authorName);
        }
        else{
            System.out.println("The author is not exits");
        }
    }
}
