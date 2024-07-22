/**
 * The <code>Playlist</code>is used to make a playlist of songs
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
public class Playlist implements Cloneable {
    final int MAX_RECORD = 50; // Max capacity of songs in a playlist
    SongRecord[] songs; // An array of songs
    int counter; // number of songs in the playlist

    /**
     * Constructor for the Playlist class
     * Initializes an empty playlist
     */
    public Playlist() {
        songs = new SongRecord[MAX_RECORD];
        this.counter = 0;
    }

    /**
     * Deep cloning method of a specified Playlist
     * @return returns a deep copy of a Playlist
     * @throws CloneNotSupportedException throws an
     * exception if cloning is not supported
     */

    public Object clone() throws CloneNotSupportedException {
        Playlist clone = new Playlist();
        try {
            clone = (Playlist)super.clone();
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Not cloneable.");
        }
        clone.songs = (SongRecord[]) songs.clone();
        return clone;
    }

    /**
     * Method that compares two playlists to see if they're
     * identical
     * @param obj the playlist that's being compared to
     * @return returns true or false
     */
    public boolean equals(Object obj) {
        if (obj instanceof Playlist) {
            Playlist compare = (Playlist) obj;
            if (((Playlist) obj).size() != compare.size()) {
                return false;
            } else {
                for (int i = 0; i < compare.size(); i++) {
                    if (!compare.songs[i].equals(this.songs)) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    /**
     * Size method that returns the size of the playlist
     * @return returns the song count in a playlist
     */
    public int size(){
        return counter;
    }

    /**
     * addSong method that adds a song to a playlist
     * @param newSong a new SongRecord to be added
     * @param position position to put the song within a playlist
     * @throws FullPlaylistException throws an exception if the playlist
     * reached max capacity
     */
    public void addSong(SongRecord newSong, int position)
            throws FullPlaylistException {
        if (position > 50 || position < 1){
            throw new IllegalArgumentException("Index out " +
                    "of bounds.");
        } else if(counter == 50){
            throw new FullPlaylistException("Playlist is " +
                    "full.");
        } else{
            if (songs[position - 1] != null){
                for (int i = counter; i >= position - 1; i--) {
                    songs[i] = songs[i - 1];
                }
                songs[position - 1] = newSong;
            } else {
                songs[position - 1] = newSong;
            }
            counter ++;
        }

    }

    /**
     * removeSong method removes a song from a playlist
     * @param position position of a song to be removed
     */
    public void removeSong(int position) {
        if (position > 50 || position < 1) {
            throw new IllegalArgumentException("Invalid " +
                    "position");
        } else if (songs[position - 1] == null) {
            throw new IllegalArgumentException("No song " +
                    "in this position");
        }
        if (songs[position] != null) {
            int i = position;
            while(songs[i] != null) {
                songs[i - 1] = songs[i];
                i++;
            }
        } else {
            songs[position - 1] = null;
        }
        counter--;

    }

    /**
     * getSong Method that returns a certain song
     * @param position Position of the song to be returned
     * @return Returns the song in the position
     */
    public String getSong(int position) {
        return position + "          " +
                songs[position - 1].toString();

    }

    /**
     * Method that prints all the songs in a playlist
     */
    public void printAllSongs() {
        for (int i = 0; i < counter; i++) {
            System.out.println(i + 1 + "          " +
                    "" + songs[i].toString());
        }

    }

    /**
     * getSongsByArtist method returns a new playlist containing
     * only songs of a specified artist
     * @param originalList The Playlist to make a new one from
     * @param artist Specified artist to make a new Playlist based on
     * @return a Playlist containing only the specified artist
     * @throws FullPlaylistException if the playlist is full, it
     * will throw an exception
     */
    public static Playlist getSongsByArtist(Playlist
                                                    originalList,
                                            String artist) throws
            FullPlaylistException {
        Playlist artistPlaylist = new Playlist();
        for (int i = 0; i < originalList.size(); i++) {
            if (originalList.songs[i].getArtist()
                    .equalsIgnoreCase(artist)) {
                artistPlaylist.addSong(originalList
                        .songs[i], artistPlaylist.size() + 1);
            }
        }
        return artistPlaylist;
    }

    /**
     * toString method that prints out the songs of the Playlist
     * @return null since it wasn't necessary for the program
     * to run
     */
    public String toString() {
        return null;

    }



}

