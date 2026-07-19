package mao.yannan._0049_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (var s : strs) {
            var chars = s.toCharArray();
            Arrays.sort(chars);
            var key = new String(chars);
            result.computeIfAbsent(key, _ -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(result.values());
    }

}

