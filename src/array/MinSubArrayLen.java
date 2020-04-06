package array;

/**
 * @author hyhcoder
 * @date 2020/3/16 13:48
 *
 * 长度最小的子数组
 */
public class MinSubArrayLen {
	
	public int minSubArrayLen(int s, int[] nums) {
		int res = Integer.MAX_VALUE;
		int end = 1;
		// 暴力
		for (int d = 0 ; d <= nums.length-1; d++) {
			
			int tempRes = nums[d];
			int count = 1;
			end = d + 1;
			while (end <= nums.length-1 && tempRes < s) {
				tempRes += nums[end];
				end++;
				count++;
			}
			if (tempRes >= s) {
				res = Math.min(res, count);
			}
		}
		
		if (res == Integer.MAX_VALUE) {
			// 没有找到的情况
			res = 0;
		}
		return res;
	}
}
