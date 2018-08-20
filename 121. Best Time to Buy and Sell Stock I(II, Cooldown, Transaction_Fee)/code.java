//121. Best Time to Buy and Sell Stock
class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int buyCondition = -prices[0];
		int sellCondition = 0;
		for(int i = 1; i < prices.length; i++){
			int prev = buyCondition;
			buyCondition = Math.max(buyCondition, sellCondition - prices[i]);
			sellCondition = Math.max(sellCondition, prev + prices[i]);
		}
		return sellCondition;
	}
}

//122. Best Time to Buy and Sell Stock II
class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int unhold = 0;
		int hold = -prices[0];
		for(int i = 1; i < prices.length; i++){
			int temp = hold;
			hold = Math.max(hold, unhold - prices[i]);
			unhold = Math.max(unhold, temp + prices[i]);
		}
		return unhold;
	}
}

//714. Best Time to Buy and Sell Stock with Transaction Fee
class Solution {
	public int maxProfit(int[] prices, int fee) {
		if(prices == null || prices.length == 0) return 0;
		int unhold = 0;
		int hold = -prices[0];
		for(int i = 1; i < prices.length; i++){
			int temp = hold;
			hold = Math.max(hold, unhold - prices[i]);
			unhold = Math.max(unhold, temp + prices[i] - fee);
		}
		return unhold;
	}
}

//309. Best Time to Buy and Sell Stock with Cooldown
class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int hold = -prices[0];
		int unhold = 0;
		// 两天前不持有股票是手里的利润
		int unholdBeforeTwoDays = 0;
		for(int i = 1; i < prices.length; i++){
			//prevhHold为i-1天持有股票时的最大利润
			int prevHold = hold;
			//prevhUnhold为i-1天未持有股票时的最大利润
			int prevUnhold = unhold;
			//第i天持有股票的最大利润是求第i-1天持有股票的最大利润和两天前不持有股票是手里的利润减去第i天买入股票的价格的值的最大值
			hold = Math.max(hold, unholdBeforeTwoDays - prices[i]);
			unhold = Math.max(unhold, prevHold + prices[i]);
			//第i天过后i-1天的unhold值就可以作为两天前不持有股票是手里的利润
			unholdBeforeTwoDays = prevUnhold;
		}
		return unhold;
	}
}