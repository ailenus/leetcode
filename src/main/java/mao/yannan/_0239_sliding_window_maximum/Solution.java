package mao.yannan._0239_sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        var n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        var answer = new int[n - k + 1];
        Deque<Integer> window = new ArrayDeque<>();
        for (var i = 0; i < n; i++) {
            while (!window.isEmpty() && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            window.offerLast(i);
            if (i >= k - 1) {
                answer[i - k + 1] = nums[window.peekFirst()];
            }
        }
        return answer;
    }

}
