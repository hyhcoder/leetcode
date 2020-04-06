package array;

import java.util.Arrays;

/**
 * @author hyhcoder
 * @date 2020/3/22 9:09
 *
 * 使数组唯一的最小增量
 */
public class MinIncrementForUnique {
	
	public int minIncrementForUnique(int[] nums) {
	
		if (nums.length < 2) {
			return 0;
		}
		
		//先排序;
		Arrays.sort(nums);
		
		int result = 0;
		int slow = 0;
		int fast = 1;
		
		for (int d = 0; d < nums.length - 1; d ++) {
			
			if (nums[fast] == nums[slow]) {
				nums[fast] ++;
				result ++;

			} else if (nums[fast] < nums[slow] ){
				
				int temp = nums[slow] - nums[fast] + 1;
				
				nums[fast] += temp;
				result += temp;
				
			}
			
			fast ++;
			slow ++;
			
		}
		
		
		return result;
	}
}
