package mao.yannan._1047_remove_all_adjacent_duplicates_in_string;

class Solution {

    public String removeDuplicates(String s) {
        var result = new StringBuilder();
        for (var c : s.toCharArray()) {
            var last = result.length() - 1;
            if (!result.isEmpty() && result.charAt(last) == c) {
                result.setLength(last);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
