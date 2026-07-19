package mao.yannan._0692_top_k_frequent_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (var w : words) {
            freq.merge(w, 1, Integer::sum);
        }
        List<String> result = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (x, y) -> Objects.equals(x.getValue(), y.getValue())
                        ? y.getKey().compareTo(x.getKey()) : Integer.compare(x.getValue(), y.getValue())
        );
        for (var entry : freq.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        while (!pq.isEmpty()) {
            result.addFirst(pq.remove().getKey());
        }
        return result;
    }

}
