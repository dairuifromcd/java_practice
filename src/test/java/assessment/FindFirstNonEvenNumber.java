package assessment;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static assessment.Helper.intArrayToList;

/**
 * Created by edward on 2017-09-01.
 */
public class FindFirstNonEvenNumber {
    public int findFirstNonEvenNumber(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return -1;
        }

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        for (int i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                return key;
            }
        }

        return -1;
    }

    @Test
    public void testFindFirstNonEvenNumber() {
        int[][] inputs = {
                {1, 1, 2, 2, 3, 3, 3},
                {},
                null,
                {1},
                {1, 2, 3, 1, 2, 3}
        };
        int[] outputs = {3, -1, -1, 1, -1};

        for(int i = 0; i < inputs.length; i++) {
            Assert.assertTrue(findFirstNonEvenNumber(intArrayToList(inputs[i])) == outputs[i]);
        }
    }
}
