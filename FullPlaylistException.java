/**
 * The <code>FullPlaylistException</code>is a custom exception
 * for when a playlist reached maximum capacity
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
public class FullPlaylistException extends Exception{
    public FullPlaylistException(String message){
        super(message);
    }

}
