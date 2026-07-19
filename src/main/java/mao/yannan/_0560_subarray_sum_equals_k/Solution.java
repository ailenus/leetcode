package mao.yannan._0560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);
        var prefix = 0;
        var count = 0;
        for (var n : nums) {
            prefix += n;
            count += seen.getOrDefault(prefix - k, 0);
            seen.merge(prefix, 1, Integer::sum);
        }
        return count;
    }

}
