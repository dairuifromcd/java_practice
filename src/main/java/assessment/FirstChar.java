package assessment;

import java.util.LinkedHashMap;

public abstract class FirstChar {
    /**
     * Find the first character in a stream which is not repeated in the rest of the stream.
     * @param input The source of characters. An instance of assessment.Stream rather than java.util.stream.Stream
     * @return The first found unrepeated character in the Stream, otherwise Character.MAX_VALUE which is not used in the ASCII table.
     */
	public static char firstChar(Stream input) {
		if (input.hasNext()) {
		    // HashMap is not used because it doesn't guarantee maintaining insertion order.
			LinkedHashMap<Character, Integer> candidates = new LinkedHashMap<Character, Integer>();
			char current;

			do {
				current = input.getNext();

				if (candidates.containsKey(current)) {
					candidates.put(current, candidates.get(current) + 1);
				} else {
				    candidates.put(current, 1);
                }
			} while (input.hasNext());

			// keySet() returns keys in insertion order.
			for (Character key : candidates.keySet()) {
                if (candidates.get(key) == 1) {
                    return key;
                }
            }

		}

		return Character.MAX_VALUE;
	}
}