package mao.yannan._0560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        frequency.put(0, 1);
        var total = 0;
        var count = 0;
        for (var num : nums) {
            total += num;
            if (frequency.containsKey(total - k)) {
                count += frequency.get(total - k);
            }
            frequency.merge(total, 1, Integer::sum);
        }
        return count;
    }

}
