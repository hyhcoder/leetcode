package dp;

import java.util.HashMap;

/**
 * @author hyhcoder
 * @date 2020/3/8 9:44
 *
 * 322 零钱兑换
 *
 */
public class CoinChange {
	
	public static void main(String[] args) {
		
		CoinChange coinChange = new CoinChange();
		//System.out.println(coinChange.coinChange(new int[]{186,419,83,408},6249));
		System.out.println(coinChange.coinChange(new int[]{1,2,5},11));
		System.out.println(coinChange.coinChange(new int[]{1,2,5},12));
		System.out.println(coinChange.coinChange(new int[]{1},0));
	}
	
	/**
	 * 这种问题求解不能用贪心算法;
	 * 只能用动态规划, 加上剪子叶的优化方法
	 */
	// 总硬币数
	private HashMap<Integer, Integer> resultMap = new HashMap();
	public int coinChange(int[] coins, int amount) {
		
		if (amount == 0) {
			return 0;
		}
		
		int totalResult = findCoin(coins, amount);
		
		if (totalResult == Integer.MAX_VALUE) {
			return -1;
		}
		
		return  totalResult;
	}
	
	
	/**
	 * 递归, 剪子叶
	 */
	public int findCoin(int[] coins, int amount) {
		
		if (resultMap.containsKey(amount)) {
			return resultMap.get(amount);
		}
		
		if (amount < 0) {
			// 表示找不到
			return -1;
		}
		if (amount == 0) {
            return 0;
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i ++) {
			int tempR = findCoin(coins, amount - coins[i]);
			if (tempR != -1) {
				result = Math.min(result, tempR + 1);
			}
		}
		if (result == Integer.MAX_VALUE) {
			resultMap.put(amount, -1);
		} else {
			resultMap.put(amount, result);
		}
		
		
		return  resultMap.get(amount);
	}
}
