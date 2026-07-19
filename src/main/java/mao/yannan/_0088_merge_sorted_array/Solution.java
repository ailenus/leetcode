package mao.yannan._0088_merge_sorted_array;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var i = m - 1;
        var j = n - 1;
        var k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

}
