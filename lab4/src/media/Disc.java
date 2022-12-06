package media;

public class Disc extends Media{
    private float length;
    private String director;

    public float getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    public Disc() {
        this.length = length;
        this.director = director;
    }
}
