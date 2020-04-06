package array;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author hyhcoder
 * @date 2020/3/16 8:01
 *
 * 找到重复的数字
 * 2 <= n <= 100000
 */
public class FindTheRepeatNum {
	
	
	public int findRepeatNumber(int[] nums) {
		
		Set<Integer> integerSet = new TreeSet<>();
		
		for (int d = 0; d < nums.length; d++) {
			
			if (!integerSet.add(nums[d])) {
				return nums[d];
			}
			
		}
		
		// 不存在
		return -1;
	}
}
