package mao.yannan.besttimetobuyandsellstock;

class Solution {

    public int maxProfit(int[] prices) {
        var len = prices.length;
        if (len == 0) {
            return 0;
        }
        var profit = 0;
        var min = 10_001;
        for (var price : prices) {
            if (price < min) {
                min = price;
            } else {
                var currProfit = price - min;
                if (currProfit > profit) {
                    profit = currProfit;
                }
            }
        }
        return profit;
    }

}
