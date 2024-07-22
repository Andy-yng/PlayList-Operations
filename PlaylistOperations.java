/**
 * The <code>PlaylistOperations</code>is where the main program runs
 * for the songs and playlists to be manipulated
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
import java.util.Scanner;
public class PlaylistOperations {
    /**
     * Main method of program where the simulation runs
     * @param args
     * @throws FullPlaylistException throws an exception if the
     * playlist is full
     */
    public static void main(String[]args)
            throws FullPlaylistException {
        Playlist playlist = new Playlist();
        System.out.println("A) Add Song\n" +
                "B) Print Songs by Artist\n" +
                "G) Get Song\n" +
                "R) Remove Song\n" +
                "P) Print All Songs\n" +
                "S) Size\n" +
                "Q) Quit ");

        while (true) {
            Scanner st = new Scanner(System.in);
            System.out.println("Select a menu option: ");
            String option = st.nextLine();
            switch (option.toUpperCase()) {
                case "A":
                    System.out.println("Enter the song title: ");
                    String title = st.nextLine();
                    System.out.println("Enter the song artist: ");
                    String artist = st.nextLine();
                    System.out.println("Enter the song length (minutes): ");
                    int min = st.nextInt();
                    st.nextLine();
                    System.out.println("Enter the song length (seconds): ");
                    int sec = st.nextInt();
                    st.nextLine();
                    System.out.println("Enter the position: ");
                    int position = st.nextInt();
                    if (min < 0 || sec < 0 || sec > 59){
                        System.out.println("Invalid song length.");
                        break;
                    } else if (position > playlist.size() + 1){
                        System.out.println("Invalid position for adding the new song.");
                        break;
                    } else {
                        SongRecord newSong = new SongRecord(title, artist, min, sec);
                        playlist.addSong(newSong, position);
                        System.out.println("Song Added: " + title + " By " + artist);
                    }
                    break;

                case "B":
                    System.out.println("Enter the artist: ");
                    String art = st.nextLine();
                    print();
                    Playlist.getSongsByArtist(playlist, art).printAllSongs();
                    break;
                case "G":
                    System.out.println("Enter position: ");
                    int songPosition = st.nextInt();
                    st.nextLine();
                    print();
                    System.out.println(playlist.getSong(songPosition));
                    break;
                case "R":
                    System.out.println("Enter the position: ");
                    int remove = st.nextInt();
                    st.nextLine();
                    if (remove > playlist.size()) {
                        throw new IllegalArgumentException("No song in that position");
                    }
                    playlist.removeSong(remove);
                    System.out.println("Song Removed at position " + remove);
                    break;
                case "P":
                    print();
                    playlist.printAllSongs();
                    break;
                case "S":
                    System.out.println("There are " + playlist.size()
                            +  " song(s) in the current playlist.");
                    break;
                case "Q":
                    System.out.println("Program terminating normally...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }

    }

    /**
     * print method that prints out the header to display songs
     */
    public static void print(){
        System.out.println("Song#      Title          Artist   " +
                "       Length");
        System.out.println("---------------------------------" +
                "---------------");

    }
}
