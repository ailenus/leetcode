package mao.yannan.majorityelement;

class Solution {

    public int majorityElement(int[] nums) {
        var mode = 1_000_000_001;
        var count = 0;
        for (var num : nums) {
            if (count == 0) {
                mode = num;
                count++;
            } else if (mode == num) {
                count++;
            } else {
                count--;
            }
        }
        return mode;
    }

}
