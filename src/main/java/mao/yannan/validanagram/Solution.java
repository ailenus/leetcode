package mao.yannan.validanagram;

class Solution {

    public boolean isAnagram(String s, String t) {
        var table = new int[26];
        for (var c : s.toCharArray()) {
            table[c - 'a']++;
        }
        for (var c : t.toCharArray()) {
            table[c - 'a']--;
        }
        for (var value : table) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

}
