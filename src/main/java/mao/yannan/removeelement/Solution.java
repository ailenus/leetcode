package mao.yannan.removeelement;

import java.util.Arrays;

class Solution {

    private static final int PLACEHOLDER = 51;

    public int removeElement(int[] nums, int val) {
        var len = nums.length;
        var count = 0;
        for (var i = 0; i < len; i++) {
            if (nums[i] == val) {
                nums[i] = PLACEHOLDER;
                count++;
            }
        }
        Arrays.sort(nums);
        return len - count;
    }

}
