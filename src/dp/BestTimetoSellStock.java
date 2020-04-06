package dp;

/**
 * @author hyhcoder
 * @date 2020/3/9 8:02
 *
 * 121. 买卖股票的最佳时机
 * 这个的思路就是每次记录一个历史最低值
 */
public class BestTimetoSellStock {
	
	
	public int maxProfit(int[] prices) {
	
		int result = 0;
		
		if (prices.length <= 0) {
			return 0;
		}
		
		int minHistory = prices[0];
		// 先遍历, 存入
		for (int i = 1; i < prices.length; i++) {
			
			if (minHistory > prices[i]) {
				minHistory = prices[i];
			} else if (minHistory < prices[i]) {
				int temp = prices[i] - minHistory;
				
				if (temp > result) {
					result = temp;
				}
			}
			
		}
		
		return result;
		
	}
	
	
	
	//dp
	public int maxProfitdp(int[] prices) {
		
		int n = prices.length;
		int[][] dp = new int[n][2];
		for (int i = 0; i < n; i++) {
			if (i - 1 == -1) {
				dp[i][0] = 0;
				// 解释：
				//   dp[i][0]
				// = max(dp[-1][0], dp[-1][1] + prices[i])
				// = max(0, -infinity + prices[i]) = 0
				dp[i][1] = -prices[i];
				//解释：
				//   dp[i][1]
				// = max(dp[-1][1], dp[-1][0] - prices[i])
				// = max(-infinity, 0 - prices[i])
				// = -prices[i]
				continue;
			}
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
		}
		return dp[n - 1][0];
	
	}
	
}
