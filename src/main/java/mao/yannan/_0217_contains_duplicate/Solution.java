package mao.yannan._0217_contains_duplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (var n : nums) {
            if (!seen.add(n)) {
                return true;
            }
        }
        return false;
    }

}
