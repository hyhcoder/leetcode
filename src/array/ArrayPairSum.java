package array;

import java.util.Arrays;

/**
 * @author hyhcoder
 * @date 2020/3/15 11:38
 *
 * 数组拆分
 *
 */
public class ArrayPairSum {
	
	public int arrayPairSum(int[] nums) {
		
		
		Arrays.sort(nums);
		int length = nums.length -1;
		int result = 0;
		for (int i = 0 ; i <= length;) {
			result += nums[i];
			i += 2;
		}
		return result;
	}
}
