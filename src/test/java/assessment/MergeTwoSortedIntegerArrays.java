package assessment;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static assessment.Helper.intArrayToList;

/**
 * Created by edward on 2017-08-30.
 */
public class MergeTwoSortedIntegerArrays {
    // Two list must already be sorted, otherwise the result is uncertain
    private List<Integer> mergeTwoSortedIntegerArrays(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<Integer>();

        if (list1 == null || list1.size() == 0) {
            return list2;
        }

        if (list2 == null || list2.size() == 0) {
            return list1;
        }

        int len1 = list1.size();
        int len2 = list2.size();
        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            int current1 = list1.get(i);
            int current2 = list2.get(j);

            if (current1 <= current2) {
                result.add(current1);
                i++;
            } else {
                result.add(current2);
                j++;
            }
        }

        while (i < len1) {
            result.add(list1.get(i++));
        }

        while (j < len2) {
            result.add(list2.get(j++));
        }

        return result;
    }

    @Test
    public void testMergeTwoSortedIntegerArrays() {
        int[][] input1 = {
                {2, 5, 6, 8},
                null,
                {1, 2, 3},
                null,
                {},
                {1},
                {},
                {1, 2, 3}
        };

        int[][] input2 = {
                {-1, 0, 7, 9, 10, 12},
                {1, 2, 3},
                null,
                null,
                {1},
                {},
                {},
                {100, 101, 102}
        };

        int[][] expect = {
                {-1, 0, 2, 5, 6, 7, 8, 9, 10, 12},
                {1, 2, 3},
                {1, 2, 3},
                null,
                {1},
                {1},
                {},
                {1, 2, 3, 100, 101, 102}
        };

        List<Integer> expectList;
        List<Integer> resultList;
        for (int i = 0; i < input1.length; i++) {
            expectList = intArrayToList(expect[i]);
            resultList = mergeTwoSortedIntegerArrays(intArrayToList(input1[i]), intArrayToList(input2[i]));
            if (expectList == null) {
                Assert.assertTrue(resultList == null);
            } else {
                Assert.assertTrue(expectList.equals(resultList));
            }
            System.out.println(resultList);
        }
    }
}
