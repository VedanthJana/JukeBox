
import java.util.EmptyStackException;

public class Album {
    private String albumName; // The name of the album.
    private int size; // The number of songs currently in the album.
    private LinkedStack<Song> trackList; // Stack to store songs in the album.

    /**
     * Constructs an empty Album with a new LinkedStack to store songs and size as zero.
     *
     * @param albumName the name of the album
     */
    public Album(String albumName) {
        this.albumName = albumName;
        this.size = 0;
        this.trackList = new LinkedStack<>();
    }

    /**
     * Adds a song to the top of the album's track list and adds the Album reference to the song.
     *
     * @param s the song to be added
     */
    public void addSong(Song s) {
        trackList.push(s);
        size++;
    }

    /**
     * Retrieves the song that is currently at the top of the album's track list, without removing it from the stack.
     *
     * @return the song at the top of the track list
     * @throws EmptyStackException if the album is empty
     */
    public Song firstSong() {
        return trackList.peek();
    }

    /**
     * Retrieves the name of the album.
     *
     * @return the album name
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Removes the most recently added song from the album.
     *
     * @return the removed song
     * @throws EmptyStackException if the album is empty
     */
    public Song removeSong() {
        size--;
        return trackList.pop();
    }

    /**
     * Returns the number of songs currently in the album.
     *
     * @return the size of the album
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of the album, with the name of the album as the first line
     * and listing all songs from the top of the stack to the bottom.
     *
     * @return the string representation of the album
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(albumName).append("\n");

        // Use a temporary stack to avoid modifying the original trackList
        LinkedStack<Song> tempStack = new LinkedStack<>();
        boolean firstSong = true;

        while (!trackList.isEmpty()) {
            Song song = trackList.pop();
            if (!firstSong) {
                sb.append("\n");  // Add newline only between songs
            }
            sb.append(song.toString());
            firstSong = false;
            tempStack.push(song);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            trackList.push(tempStack.pop());
        }

        return sb.toString();
    }

}

