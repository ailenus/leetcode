package mao.yannan.removeduplicatesfromsortedarrayii;

class Solution {

    public int removeDuplicates(int[] nums) {
        var len = nums.length;
        if (len == 1 || len == 2) {
            return len;
        }
        var k = 2;
        var modified = false;
        for (var i = 2; i < len; i++) {
            var curr = nums[i];
            var prev = nums[i - 1];
            var pprev = nums[i - 2];
            if (modified) {
                if (k == i) {
                    prev--;
                } else if (k == i - 1) {
                    pprev--;
                }
                modified = false;
            }
            if (curr != prev || curr != pprev) {
                if (nums[k] != curr) {
                    nums[k] = curr;
                    modified = true;
                }
                k++;
            }
        }
        return k;
    }

}
