package assessment;

import org.junit.Assert;
import org.junit.Test;

import static assessment.Helper.compareArrays;

/**
 * Created by edward on 2017-08-28.
 */
public class CompareThreeIntegers {
    private void compareThreeIntegers(int[] array) {
        if (array != null && array.length == 3) {
            makeSureLowToHigh(array, 0, 1);
            makeSureLowToHigh(array, 1, 2);
            makeSureLowToHigh(array, 0, 1);
        }
    }

    private void makeSureLowToHigh(int[] array, int a, int b) {
        if (checkParameters(array, a, b)) {
            if (array[a] > array[b]) {
                swapIntegers(array, a, b);
            }
        }
    }

    private void swapIntegers(int[] array, int i, int j) {
        if (checkParameters(array, i, j)) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private boolean checkParameters(final int[] array, int i, int j) {
        if (array == null || array.length <= 0 || i == j) {
            return false;
        }

        int len = array.length;

        if (i < 0 || j < 0 || i > len || j > len) {
            return false;
        }

        return true;
    }

    @Test
    public void testCompareThreeIntegers() {
        int[][] inputs = {
                {0, 0, 0},
                null,
                {1000, 500, 1},
                {},
                {3, 2, 1}
        };
        int[][] expects = {
                {0, 0, 0},
                null,
                {1, 500, 1000},
                {},
                {1, 2, 3}
        };

        for (int i = 0; i < inputs.length; i++) {
            compareThreeIntegers(inputs[i]);
            System.out.println(inputs[i]);
            Assert.assertTrue(compareArrays(inputs[i], expects[i]));
        }
    }
}
