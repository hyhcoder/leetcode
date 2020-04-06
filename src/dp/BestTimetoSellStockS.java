package dp;

/**
 * @author hyhcoder
 * @date 2020/3/9 20:53
 *
 * 122 买卖股票的最佳时机2
 * 面试题63 股票的最大利润
 *
 * 股民思想, 因为可以有预测, 如果第二天要跌, 那就卖出;然后在跌的那个方向, 找最低的 买入
 *
 */
public class BestTimetoSellStockS {
	
	
	public int maxProfit(int[] prices) {
	
		int result = 0;
		for (int i = 0; i < prices.length - 1; i++) {
	
			if (prices[i+1] > prices[i]) {
				
				// 利润到手
				result += prices[i+1] - prices[i];
			}
			
		}
		
		return result;
		
	}
	
	
}
