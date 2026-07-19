package mao.yannan._0056_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> answer = new ArrayList<>();
        var prev = intervals[0];
        for (var i = 1; i < intervals.length; i++) {
            var interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                answer.add(prev);
                prev = interval;
            }
        }
        answer.add(prev);
        return answer.toArray(new int[answer.size()][]);
    }

}
