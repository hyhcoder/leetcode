package array;

import java.util.HashMap;

/**
 * @author hyhcoder
 * @date 2020/3/7 8:23
 */
public class TwoSum {
	public static void main(String[] args) {
	
	}
	
	public int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer,Integer> integerHashMap = new HashMap<>();
		int [] resultInt = new int[2];
		
		for (int i = 0 ; i < nums.length; i++) {
			
			int result = target - nums[i];
			if (integerHashMap.containsKey(result)) {
				resultInt[0] = integerHashMap.get(result);
				resultInt[1] = i;
				return resultInt;
			}
			
			integerHashMap.put(nums[i], i);
			
		}
		
		return resultInt;
		
		
	}
}
