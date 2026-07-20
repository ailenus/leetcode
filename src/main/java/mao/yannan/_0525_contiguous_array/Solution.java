package mao.yannan._0525_contiguous_array;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        var prefix = 0;
        var maxLength = 0;
        for (var i = 0; i < nums.length; i++) {
            prefix += nums[i] == 0 ? -1 : 1;
            if (seen.containsKey(prefix)) {
                maxLength = Math.max(maxLength, i - seen.get(prefix));
            } else {
                seen.put(prefix, i);
            }
        }
        return maxLength;
    }

}
