package mao.yannan.validpalindrome;

class Solution {

    public boolean isPalindrome(String s) {
        var start = 0;
        var end = s.length() - 1;
        while (start < end) {
            var currStart = s.charAt(start);
            var currEnd = s.charAt(end);
            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

}
