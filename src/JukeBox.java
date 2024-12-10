import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class JukeBox {

    private int capacity;
    private LinkedQueue<Song> songQueue;

    // Constructor
    public JukeBox(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative.");
        }
        this.capacity = capacity;
        this.songQueue = new LinkedQueue<>();
    }

    // Adds a single song to the queue if there is space
    public void addSongToQueue(Song song) {
        if (isFull()) {
            throw new IllegalStateException("The jukebox is full.");
        }
        if (songQueue.contains(song)) {
            throw new IllegalArgumentException("This song is already in the queue.");
        }
        songQueue.enqueue(song);
    }

    // Adds an entire album to the queue if space allows
    public void addAlbumToQueue(Album album) {
    	while (album.size() > 0 && !isFull()) {
            Song song = album.removeSong();
            if (!songQueue.contains(song)) {
                songQueue.enqueue(song);
            }
        }
    }

    // Plays and removes the song at the front of the queue
    public Song playSong() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty, cannot play a song.");
        }
        return songQueue.dequeue();
    }

    // Shuffles the songs in the queue
    public void shuffleSongQueue() {
        List<Song> songList = new LinkedList<>();
        while (!songQueue.isEmpty()) {
            songList.add(songQueue.dequeue());
        }
        Collections.shuffle(songList);
        for (Song song : songList) {
            songQueue.enqueue(song);
        }
    }

    // Returns the number of songs in the queue
    public int size() {
        return songQueue.size();
    }

    // Returns the capacity of the queue
    public int capacity() {
        return this.capacity;
    }

    // Checks if the queue is full
    public boolean isFull() {
        return songQueue.size() == capacity;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return songQueue.isEmpty();
    }

    //return song queue
    /*public LinkedQueue<Song> getSong()
    {
    	return songQueue;
    }*/
    // String representation of the jukebox queue
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedQueue<Song> tempQueue = new LinkedQueue<>();
        
        // Process the songs in the queue
        while (!songQueue.isEmpty()) {
            Song song = songQueue.dequeue();
            sb.append(song).append(" -> ");
            tempQueue.enqueue(song);
        }
        
        // Restore the queue
        while (!tempQueue.isEmpty()) {
            songQueue.enqueue(tempQueue.dequeue());
        }
        
        sb.append("END");
        return sb.toString();
    }

}