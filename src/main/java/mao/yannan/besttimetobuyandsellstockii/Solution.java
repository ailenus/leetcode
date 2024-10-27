package mao.yannan.besttimetobuyandsellstockii;

class Solution {

    public int maxProfit(int[] prices) {
        var len = prices.length;
        if (len == 1) {
            return 0;
        }
        var maxProfit = 0;
        for (var i = 1; i < len; i++) {
            var prev = prices[i - 1];
            var curr = prices[i];
            if (curr > prev) {
                maxProfit += curr - prev;
            }
        }
        return maxProfit;
    }

}
