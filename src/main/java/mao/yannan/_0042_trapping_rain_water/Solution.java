package mao.yannan._0042_trapping_rain_water;

class Solution {

    public int trap(int[] height) {
        var total = 0;
        var leftMax = 0;
        var rightMax = 0;
        var start = 0;
        var end = height.length - 1;
        while (start < end) {
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);
            if (leftMax < rightMax) {
                total += leftMax - height[start];
                start++;
            } else {
                total += rightMax - height[end];
                end--;
            }
        }
        return total;
    }

}
