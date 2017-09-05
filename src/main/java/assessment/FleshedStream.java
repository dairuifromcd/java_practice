package assessment;

/**
 * Implementation of the interface assessment.Stream
 */
public class FleshedStream implements Stream {
	private String charList;
	private int position;

	/**
	 * Constructor of class FleshedStream
	 * @param charList A standard String object
	 */
	public FleshedStream(String charList) {
	    this.charList = charList;
		position = 0;
	}

	/**
	 * Get the next character in the Stream
	 * @return The next character if there is one or Character.MAX_VALUE which is not used in the ASCII table
	 */
	public char getNext() {
		if (hasNext()) {
			return charList.charAt(position++);
		} else {
			return Character.MAX_VALUE;
		}
	}

	/**
	 * Test if the next character is available in the Stream
	 * @return True if the next character is available, otherwise false
	 */
	public boolean hasNext() {
		if (charList != null) {
			int listLength = charList.length();

			// 0 <= position < length
			return position < listLength;
		}

		return false;
	}
}