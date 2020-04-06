package dp;


import java.util.Arrays;

/**
 * @author hyhcoder
 * @date 2020/3/14 11:15
 *
 * 300. 最长上升子序列
 *
 */
public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
		
		longestIncreasingSubsequence.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
	}
	
	public int lengthOfLIS(int[] nums) {
		
		if (nums.length == 0) {
			return 0;
		}
		
		// 定义一个初始化数组
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		
		int result = 1;
		
		for (int i = 1 ; i < nums.length; i++) {
			
			// 动态规划
			for (int j = 0; j < i; j++ ) {
				
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				
				result = Math.max(result, dp[i]);
			}
			
		}
		
		return  result;
	}
	
}
