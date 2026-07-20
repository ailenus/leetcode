package mao.yannan._0383_ransom_note;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq = new HashMap<>();
        for (var c : magazine.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }
        for (var c : ransomNote.toCharArray()) {
            var currFreq = freq.get(c);
            if (currFreq == null || currFreq == 0) {
                return false;
            }
            freq.put(c, currFreq - 1);
        }
        return true;
    }

}
