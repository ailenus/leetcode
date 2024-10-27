package mao.yannan.insertinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        var len = intervals.length;
        var i = 0;
        List<int[]> result = new ArrayList<>();
        while (i < len && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < len && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        Collections.addAll(result, Arrays.copyOfRange(intervals, i, len));
        return result.toArray(new int[result.size()][2]);
    }

}
