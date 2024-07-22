/**
 * The <code>SongRecord</code>is used to make songs and contains
 * information about it
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
public class SongRecord {
    private String title; // Holds the title of the song
    private String artist; // Holds the name of the artist
    private int minutes; // Holds the length in minutes
    private int seconds; //Holds the length in seconds

    /**
     * Constructor that sets the title, artist, and length
     * of a song
     * @param title title of the song
     * @param artist artist name of the song
     * @param minutes length of the song in minutes
     * @param seconds length of the song in seconds
     */

    public SongRecord(String title, String artist, int minutes,
                      int seconds) {
        this.title = title;
        this.artist = artist;
        if (minutes < 0){
            throw new IllegalArgumentException();
        } else {
            this.minutes = minutes;
        }
        if (seconds < 0 || seconds > 59){
            throw new IllegalArgumentException();
        } else {
            this.seconds = seconds;
        }
    }

    /**
     * Getter method for the title
     * @return Returns the title
     */

    public String getTitle() {
        return title;
    }

    /**
     * Setter method for the title
     * @param title Title of the song
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for the artist
     * @return returns the artist of the song
     */

    public String getArtist() {
        return artist;
    }

    /**
     * Setter method for the artist
     * @param artist artist name of the song
     */

    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Getter method for the length in minutes
     * @return returns the minutes of a song
     */

    public int getMinutes() {
        return minutes;
    }

    /**
     * Setter method for the length in minutes
     * @param minutes length of the song in minutes
     */

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * Getter method for the length in seconds
     * @return returns the seconds of a song
     */

    public int getSeconds() {
        return seconds;
    }

    /**
     * Setter method for the length in seconds
     * @param seconds length of the song in seconds
     */

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * toString method that prints out the title, artist, and
     * length of the song
     * @return returns the title, artist, minutes, and seconds
     * of a song
     */
    public String toString(){
        return String.format("%-15s%-16s%02d:%02d", this.title,
                this.artist, this.minutes, this.seconds);
    }
}
