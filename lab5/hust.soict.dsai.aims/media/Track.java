package media;

public class Track implements Playable {
    String title;
    int length;
    // getter and setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    // Create constructor(s)
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    @Override
    public String play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track track = (Track) obj;
            if (this.title.equals(track.title) && this.length == track.length) {
                return true;
            }
        }
        return false;
    }
}
