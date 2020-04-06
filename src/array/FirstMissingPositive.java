package array;

import java.util.Arrays;

/**
 * @author hyhcoder
 * @date 2020/3/7 14:11
 *
 * 41 求缺少的第一个正数
 */
public class FirstMissingPositive {
	
	public static void main(String[] args) {
		int[] temp = new int[]{0,2,2,1,1};
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		firstMissingPositive.firstMissingPositive(temp);
	}
	
	public int firstMissingPositive(int[] nums) {
		
		// 先排序
		Arrays.sort(nums);
		
		// 最小正整数
		int resultNum = 1;
		// 遍历查找
		for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] <= 0) {
				// 跳过小于0的
				continue;
			}
			
			if (resultNum == nums[i]) {
				resultNum ++;
			} else if (resultNum < nums[i]){
				// 若是大于, 证明是之前的数字了;
				return resultNum;
			}
			
		}
		
		return resultNum;
	}
}
