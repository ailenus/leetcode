package mao.yannan.mergesortedarray;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        var sum = m + n;
        var result = new int[sum];
        int i = 0, j = 0, k = 0;
        while (k < m + n) {
            if (i >= m) {
                result[k] = nums2[j];
                j++;
                k++;
            } else if (j >= n) {
                result[k] = nums1[i];
                i++;
                k++;
            } else if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                j++;
                k++;
            } else {
                result[k] = nums1[i];
                i++;
                k++;
            }
        }
        System.arraycopy(result, 0, nums1, 0, sum);
    }

}
