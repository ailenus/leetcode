package mao.yannan._0974_subarray_sums_divisible_by_k;

class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        var seen = new int[k];
        seen[0] = 1;
        var prefix = 0;
        var count = 0;
        for (var n : nums) {
            prefix += n;
            var remainder = (prefix % k + k) % k;
            count += seen[remainder];
            seen[remainder]++;
        }
        return count;
    }

}
