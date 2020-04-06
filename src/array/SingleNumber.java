package array;

import java.util.Arrays;

/**
 * @author hyhcoder
 * @date 2020/3/19 8:05
 *
 * 数组中数字出现的次数 II
 *
 * 找出里面单独的数字
 */
public class SingleNumber {

	
	public int singleNumber(int[] nums) {
		
		// 一开始的情况
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		int begint = 0;
		int end = 1;
		
		while (begint < nums.length - 3) {
			
			if (nums[begint] != nums[end]) {
				return nums[begint];
			}else {
				begint += 3;
				end += 3;
			}
		}
		
		// 最后的情况
		return nums[nums.length-1];
	}
	
}
