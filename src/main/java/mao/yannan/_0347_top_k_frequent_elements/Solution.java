package mao.yannan._0347_top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    @SuppressWarnings("unchecked")
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (var num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (var entry : frequencyMap.entrySet()) {
            var frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }

        var answer = new int[k];
        var written = 0;
        for (var frequency = nums.length; frequency >= 1 && written < k; frequency--) {
            if (buckets[frequency] == null) {
                continue;
            }
            for (var bucket : buckets[frequency]) {
                answer[written++] = bucket;
                if (written == k ) {
                    break;
                }
            }
        }
        return answer;
    }

}
