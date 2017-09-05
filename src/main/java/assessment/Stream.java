package assessment;

/**
 * The interface to define behaviours of assessment.Stream
 */
public interface Stream {
	/**
	 * Get the next character in the Stream
	 */
	char getNext();

	/**
	 * Test if the next character is available in the Stream
	 */
	boolean hasNext();
}