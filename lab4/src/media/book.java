package media;

import java.util.ArrayList;
import java.util.List;

public class book extends Media{
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> author = new ArrayList<String>();


    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }
    public void addAuthor(String authorName){
        if(!this.author.contains(authorName)){
            this.author.add(authorName);
        }
        else{
            System.out.println("The author is already exits");
        }
    }
    public void remove(String authorName){
        if(this.author.contains(authorName)){
            this.author.remove(authorName);
        }
        else{
            System.out.println("The author is not exits");
        }
    }
}
