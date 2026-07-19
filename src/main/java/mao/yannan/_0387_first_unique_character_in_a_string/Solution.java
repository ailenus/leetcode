package mao.yannan._0387_first_unique_character_in_a_string;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (var c : s.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }
        for (var i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
