package mao.yannan._0205_isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> fwd = new HashMap<>();
        Map<Character, Character> bwd = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            var a = s.charAt(i);
            var b = t.charAt(i);
            if (fwd.containsKey(a) && fwd.get(a) != b) {
                return false;
            }
            if (bwd.containsKey(b) && bwd.get(b) != a) {
                return false;
            }
            fwd.put(a, b);
            bwd.put(b, a);
        }
        return true;
    }

}
