package mao.yannan._0003_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, longest = 0;
        for (var right = 0; right < s.length(); right++) {
            var c = s.charAt(right);
            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

}
