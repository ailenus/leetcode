package mao.yannan.removeduplicatesfromsortedarray;

class Solution {

    public int removeDuplicates(int[] nums) {
        var len = nums.length;
        if (len == 1) {
            return 1;
        }
        var count = 0;
        for (var i = 1; i < len; i++) {
            var curr = nums[i];
            if (nums[count] != curr) {
                nums[++count] = curr;
            }
        }
        return ++count;
    }

}
