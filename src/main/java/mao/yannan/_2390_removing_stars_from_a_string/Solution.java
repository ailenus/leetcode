package mao.yannan._2390_removing_stars_from_a_string;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String removeStars(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (var c : s.toCharArray()) {
            if (c != '*') {
                st.push(c);
            } else {
                st.pop();
            }
        }
        var result = new StringBuilder();
        st.forEach(result::append);
        return result.reverse().toString();
    }

}
