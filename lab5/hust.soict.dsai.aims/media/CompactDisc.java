package media;

import exception.PlayerException;

import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public String getArtist() {
        return artist;
    }
    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }
    public void addTrack(Track track) {
        // check if track is already in the list
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getTitle().equals(track.getTitle())) {
                System.out.println("Track is already in the list");
                return;
            }
        }
        tracks.add(track);
    }
    public void removeTrack(Track track) {
        // check if track is in the list
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getTitle().equals(track.getTitle())) {
                tracks.remove(i);
                return;
            }
        }
        System.out.println("Track is not in the list");
    }
    public int getLength() {
        int length = 0;
        for (int i = 0; i < tracks.size(); i++) {
            length += tracks.get(i).getLength();
        }
        return length;
    }
    @Override
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing CD: " + this.getTitle() + "\n" + "CD length: " + this.getLength();
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

    }

}
