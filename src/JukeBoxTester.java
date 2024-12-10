// TODO complete file header

import java.util.ArrayList;
/**
 * Tester class for testing the functionality of the LinkedQueue, LinkedStack, Album, Song, and
 * Jukebox classes.
 */
public class JukeBoxTester {

  /**
   * Test the behavior of adding an element to the stack.
   * 
   * @return true if element is correctly added to the stack, false otherwise
   */
  public static boolean testStackAdd() {
	// Create a new stack
	    LinkedStack<String> stack = new LinkedStack<>();

	    // Define a test element
	    String testElement = "Test Song";

	    // Add the element to the stack
	    stack.push(testElement);

	    // Check if the element is at the top of the stack
	    if (!stack.isEmpty() && stack.peek().equals(testElement)) {
	        return true; // The test passes if the element is correctly added
	    }
	    return false; // The test fails if the element is not correctly added
  }

  /**
   * Test the behavior of removing an element from the stack.
   * 
   * @return true if element is correctly removed from the stack, false otherwise
   */
  public static boolean testStackRemove() {
	// Create a new stack
	    LinkedStack<String> stack = new LinkedStack<>();

	    // Define a test element
	    String testElement = "Test Song";

	    // Add the element to the stack
	    stack.push(testElement);

	    // Remove the element from the stack
	    String removedElement = stack.pop();

	    // Check if the removed element is the same as the one added
	    // and if the stack is empty after removal
	    if (removedElement.equals(testElement) && stack.isEmpty()) {
	        return true; // The test passes if the element is correctly removed
	    }
	    return false; // The test fails if the element is not correctly removed
	}


  /**
   * Test the behavior of adding an element to the queue.
   * 
   * @return true if element is correctly added to the queue, false otherwise
   */
  public static boolean testQueueAdd() {
	// Create a new queue
	    LinkedQueue<String> queue = new LinkedQueue<>();

	    // Define a test element
	    String testElement = "Test Song";

	    // Add the element to the queue
	    queue.enqueue(testElement);

	    // Check if the element is at the front of the queue
	    if (!queue.isEmpty() && queue.peek().equals(testElement) && queue.size() == 1) {
	        return true; // The test passes if the element is correctly added
	    }
	    return false; // The test fails if the element is not correctly added
  }

  /**
   * Test the behavior of removing an element from the queue.
   * 
   * @return true if element is correctly removed from the queue, false otherwise
   */
  public static boolean testQueueRemove() {
	// Create a new queue
	    LinkedQueue<String> queue = new LinkedQueue<>();

	    // Define test elements
	    String firstElement = "First Song";
	    String secondElement = "Second Song";

	    // Add elements to the queue
	    queue.enqueue(firstElement);
	    queue.enqueue(secondElement);

	    // Remove the first element from the queue
	    String removedElement = queue.dequeue();

	    // Check if the removed element is the first one added and if the queue updates correctly
	    if (removedElement.equals(firstElement) && queue.peek().equals(secondElement) && queue.size() == 1) {
	        return true; // The test passes if the element is correctly removed
	    }
	    return false; // The test fails if the element is not correctly removed
  }

  /**
   * Test the behavior of peeking at the top element (for stack) and the front element (for queue).
   * 
   * @return true if the correct element returned for both data structures, false otherwise
   */
  public static boolean testPeek() {
	// Test for LinkedStack
	    LinkedStack<String> stack = new LinkedStack<>();
	    String stackElement = "Stack Top";
	    stack.push(stackElement);
	    boolean stackPeekCorrect = stack.peek().equals(stackElement) && !stack.isEmpty();

	    // Test for LinkedQueue
	    LinkedQueue<String> queue = new LinkedQueue<>();
	    String queueElement = "Queue Front";
	    queue.enqueue(queueElement);
	    boolean queuePeekCorrect = queue.peek().equals(queueElement) && !queue.isEmpty();

	    return stackPeekCorrect && queuePeekCorrect;
  }

  /**
   * This method tests whether the contains method correctly identifies whether a specific element
   * exists in a stack and a queue.
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testContains() {
	// Test for LinkedStack
	    LinkedStack<String> stack = new LinkedStack<>();
	    String stackElement = "Stack Element";
	    stack.push(stackElement);
	    boolean stackContainsCorrect = stack.contains(stackElement) && !stack.contains("Nonexistent");

	    // Test for LinkedQueue
	    LinkedQueue<String> queue = new LinkedQueue<>();
	    String queueElement = "Queue Element";
	    queue.enqueue(queueElement);
	    boolean queueContainsCorrect = queue.contains(queueElement) && !queue.contains("Nonexistent");

	    return stackContainsCorrect && queueContainsCorrect;
  }

  /**
   * Test the behavior of getting the list of elements in the stack and queue.
   * 
   * @return true if method returns a correctly ordered list for both data structures, false
   *         otherwise
   */
  public static boolean testGetList() {
	// Test for LinkedStack
	    LinkedStack<String> stack = new LinkedStack<>();
	    stack.push("First");
	    stack.push("Second");
	    stack.push("Third");
	    ArrayList<String> stackList = stack.getList();
	    boolean stackListCorrect = stackList.size() == 3 &&
	                               stackList.get(0).equals("Third") &&
	                               stackList.get(1).equals("Second") &&
	                               stackList.get(2).equals("First");

	    // Test for LinkedQueue
	    LinkedQueue<String> queue = new LinkedQueue<>();
	    queue.enqueue("First");
	    queue.enqueue("Second");
	    queue.enqueue("Third");
	    ArrayList<String> queueList = queue.getList();
	    boolean queueListCorrect = queueList.size() == 3 &&
	                               queueList.get(0).equals("First") &&
	                               queueList.get(1).equals("Second") &&
	                               queueList.get(2).equals("Third");

	    return stackListCorrect && queueListCorrect;
  }

  /**
   * Tests adding songs to an Album and verifies the size and content. Checks if songs are correctly
   * added in LIFO order.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testAddSongToAlbum() {
	// Create a new Album
	    Album album = new Album("Test Album");

	    // Define test songs
	    Song song1 = new Song("Song A", "ArtistA");
	    Song song2 = new Song("Song B", "ArtistB");
	    Song song3 = new Song("Song C", "ArtistC");

	    // Add songs to the album
	    album.addSong(song1);
	    album.addSong(song2);
	    album.addSong(song3);

	    // Verify the size of the album
	    boolean sizeCorrect = album.size() == 3;

	    // Verify the content of the album in LIFO order
	    boolean contentCorrect = album.removeSong().equals(song3) && // Last in, first out
	                             album.removeSong().equals(song2) &&
	                             album.removeSong().equals(song1);

	    return sizeCorrect && contentCorrect;
  }

  /**
   * Tests removing a song from an Album and verifies the size and content after removal. Checks if
   * songs are correctly removed in LIFO order.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testRemoveSongFromAlbum() {
	// Create a new Album
	    Album album = new Album("Test Album");

	    // Define test songs
	    Song song1 = new Song("Song A", "ArtistA");
	    Song song2 = new Song("Song B", "ArtistB");
	    Song song3 = new Song("Song C", "ArtistC");
	    
	    // Add songs to the album
	    album.addSong(song1);
	    album.addSong(song2);
	    album.addSong(song3);

	    // Remove songs and verify LIFO order
	    boolean removeCorrect = album.removeSong().equals(song3) && // Last in, first out
	                            album.size() == 2 &&
	                            album.removeSong().equals(song2) &&
	                            album.size() == 1 &&
	                            album.removeSong().equals(song1) &&
	                            album.size() == 0;

	    return removeCorrect;
  }

  /**
   * Tests the toString method of the Album class. Verifies that the returned string correctly
   * represents all songs in LIFO order.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testAlbumToString() {
	// Create a new Album
	    Album album = new Album("Test Album");

	    // Define test songs
	    Song song1 = new Song("Song A", "ArtistA");
	    Song song2 = new Song("Song B", "ArtistB");
	    Song song3 = new Song("Song C", "ArtistC");

	    // Add songs to the album
	    album.addSong(song1);
	    album.addSong(song2);
	    album.addSong(song3);

	    // Expected string representation
	    String expected = "Album Name: Test Album\n" +
	                      "Track List:\n" +
	                      "Song C\n" +
	                      "Song B\n" +
	                      "Song A\n";

	    // Verify the toString output
	    System.out.println(album.toString());
	    return album.toString().equals(expected);
  }

  /**
   * Tests adding a song to the Jukebox and verifies the queue contents and size.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testAddSongToJukebox() {
	// Create a new JukeBox
	    JukeBox jukebox = new JukeBox(2);

	    // Define a test song
	    Song testSong = new Song("Test Song", "test artist");

	    // Add the song to the jukebox
	    jukebox.addSongToQueue(testSong);

	    // Verify the queue size and contents
	    boolean sizeCorrect = jukebox.size() == 1;
	    //boolean contentCorrect = jukebox.getSong().dequeue().equals(testSong);

	    return sizeCorrect;
  }

  /**
   * Tests adding an album to the Jukebox and verifies the queue contents and size.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testAddAlbumToJukebox() {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * Tests playing a song from the JukeboxQueue. Verifies that the song is removed from the queue
   * after playback.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testPlaySongFromJukebox() {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * Tests shuffling the JukeBox queue. Verifies that the songs are reordered randomly after the
   * operation.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testJukeboxShuffle() {
    // TODO Auto-generated method stub
    return false;
  }

  public static void main(String[] args) {
    // Running and printing results for all the tests

    boolean test1 = testStackAdd();
    System.out.println("testStackAdd: " + (test1 ? "PASS" : "FAIL"));

    boolean test2 = testStackRemove();
    System.out.println("testStackRemove: " + (test2 ? "PASS" : "FAIL"));

    boolean test3 = testQueueAdd();
    System.out.println("testQueueAdd: " + (test3 ? "PASS" : "FAIL"));

    boolean test4 = testQueueRemove();
    System.out.println("testQueueRemove: " + (test4 ? "PASS" : "FAIL"));

    boolean test5 = testPeek();
    System.out.println("testPeek: " + (test5 ? "PASS" : "FAIL"));

    boolean test6 = testContains();
    System.out.println("testContains: " + (test6 ? "PASS" : "FAIL"));

    boolean test7 = testGetList();
    System.out.println("testGetList: " + (test7 ? "PASS" : "FAIL"));

    boolean test8 = testAddSongToAlbum();
    System.out.println("testAddSongToAlbum: " + (test8 ? "PASS" : "FAIL"));

    boolean test9 = testRemoveSongFromAlbum();
    System.out.println("testRemoveSongFromAlbum: " + (test9 ? "PASS" : "FAIL"));

    boolean test10 = testAlbumToString();
    System.out.println("testAlbumToString: " + (test10 ? "PASS" : "FAIL"));

    boolean test11 = testAddSongToJukebox();
    System.out.println("testAddSongToJukebox: " + (test11 ? "PASS" : "FAIL"));

    boolean test12 = testAddAlbumToJukebox();
    System.out.println("testAddAlbumToJukebox: " + (test12 ? "PASS" : "FAIL"));

    boolean test13 = testPlaySongFromJukebox();
    System.out.println("testPlaySongFromJukebox: " + (test13 ? "PASS" : "FAIL"));

    boolean test14 = testJukeboxShuffle();
    System.out.println("testJukeboxShuffle: " + (test14 ? "PASS" : "FAIL"));

    System.out.println("ALL TESTS: " + (test1 && test2 && test3 && test4 && test5 && test6 && test7
        && test8 && test9 && test10 && test11 && test12 && test13 && test14 ? "PASS" : "FAIL"));
  }
}
