package mao.yannan.twosum;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        var n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (var i = 0; i < n; i++) {
            var curr = nums[i];
            var diff = target - curr;
            if (map.containsKey(diff)) {
                return new int[] { i, map.get(diff) };
            }
            map.put(curr, i);
        }
        return new int[2];
    }

}
