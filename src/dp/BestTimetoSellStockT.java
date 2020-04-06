package dp;

/**
 * @author hyhcoder
 * @date 2020/3/9 21:08
 *
 * 123 买卖股票的最佳时机 三
 *
 *
 */
public class BestTimetoSellStockT {
	
	
	public static void main(String[] args) {
		BestTimetoSellStockT bestTimetoSellStockT = new BestTimetoSellStockT();
		
		System.out.println(bestTimetoSellStockT.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
	}
	
	//这个是含有冻结期的
	public int maxProfit(int[] prices) {
	
		//状态转移方程
		//定义 dp[i][k][0/1]
		// i为天数, k为买卖次数, 0为卖出, 1为持有
		// dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k-1][1] + price[i])
		
		// 初始化值
		// dp[i][0][0] = dp[-1][k][0] = 0;
		// dp[-1][k][1] = dp[i][0][1] = -infinity  不可能的情况
		
		int n = prices.length;
		int dpi0 = 0, dpi1 = Integer.MIN_VALUE;
		int dppre0 = 0; // 代表 dp[i-2][0]
		for (int i = 0; i < n; i++) {
			int temp = dpi0;
			dpi0 = Math.max(dpi0, dpi1 + prices[i]);
			dpi1 = Math.max(dpi1, dppre0 - prices[i]);
			dppre0 = temp;
		}
		return dpi0;
		
	}
	
}
