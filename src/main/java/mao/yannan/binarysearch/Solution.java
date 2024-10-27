package mao.yannan.binarysearch;

class Solution {

    public int search(int[] nums, int target) {
        var low = 0;
        var high = nums.length - 1;
        while (low <= high) {
            var mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
