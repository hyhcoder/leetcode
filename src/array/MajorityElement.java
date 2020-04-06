package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author hyhcoder
 * @date 2020/3/7 13:50
 *
 * 169 多数元素
 *
 */
public class MajorityElement {
	
	/**
	 * 哈希表法
	 */
	public int majorityElement(int[] nums) {
		
		HashMap<Integer, Integer> integerHashMap = new HashMap<>();
		
		int result = 0;
		
		for (int temp:nums) {
			
			// 特殊情况
			if (nums.length == 1) {
				return temp;
			}
			
			if (integerHashMap.containsKey(temp)) {
				int a = integerHashMap.get(temp);
				a++;
				if (a > nums.length/2) {
					result = temp;
				}
				integerHashMap.put(temp,a);
			} else {
				integerHashMap.put(temp, 1);
			}
		}
		
		return result;
	}
	
	/**
	 * 排序法
	 */
	public int majorityElementSort(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
}
