package mao.yannan._0121_best_time_to_buy_and_sell_stock;

class Solution {

    public int maxProfit(int[] prices) {
        var min = prices[0];
        var best = 0;
        for (var p : prices) {
            min = Math.min(min, p);
            best = Math.max(best, p - min);
        }
        return best;
    }

}
