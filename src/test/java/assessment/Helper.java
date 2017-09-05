package assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by edward on 2017-09-01.
 */
public final class Helper {
    private Helper() {}

    public static List<Integer> intArrayToList(int[] array) {
        if (array == null) {
            return null;
        }

        if (array.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<Integer>(array.length);

        for (int i : array) {
            result.add(i);
        }

        return result;
    }

    public static boolean compareArrays(final int[] a, final int[] b) {
        if (a == null || b == null) {
            return a == b;
        }

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
