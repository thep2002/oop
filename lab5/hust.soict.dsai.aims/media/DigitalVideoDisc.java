package media;

import exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
    }


    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
    @Override
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
