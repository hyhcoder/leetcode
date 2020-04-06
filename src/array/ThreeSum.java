package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hyhcoder
 * @date 2020/3/7 8:43
 *
 * 15.三数之和
 *
 * 这题的思路其实可以跟滑块思想一致
 */
public class ThreeSum {
	
	public static void main(String[] args) {
	
		ThreeSum threeSum = new ThreeSum();
		int [] temp = new int [] {-2,0,0,2,2};
		threeSum.threeSum(temp);
		
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
	
		List<List<Integer>> resultArr = new ArrayList<>();
		int len = nums.length;
		
		// 过滤不符合的
		if (nums.length < 3) {
			return resultArr;
		}
		
		// 排序
		Arrays.sort(nums);
		
		for (int i=0; i<len; i++) {
			
			// 特殊情况过滤
			if (nums[i] > 0) {
				// 不可能找到
				break;
			}
			if (i > 0 && nums[i] == nums[i-1]) {
				//过滤重复值
				continue;
			}
			// 定值
			int end = len-1;
			for (int start=i+1; start < end; ) {
				if (nums[i] + nums[start] + nums[end] == 0) {
					List<Integer> integerList = new ArrayList<>();
					integerList.add(nums[i]);
					integerList.add(nums[start]);
					integerList.add(nums[end]);
					resultArr.add(integerList);
					// 双边缩小
					start++;
					end--;
					//过滤重复值
					while(start<end && nums[start-1]==nums[start]) {
						start++;
					}
					while(start<end && nums[end+1]==nums[end]) {
						end--;
					}
				}
				
				if (nums[i] + nums[start] + nums[end] > 0) {
					// 大于0的时候
					// 变小, end向左移动
					end--;
					while(start<end && nums[end+1]==nums[end]) {
						end--;
					}
				}
				
				if (nums[i] + nums[start] + nums[end] < 0) {
					// 小于0的时候
					// 变大, k向右移动
					start++;
					while(start<end && nums[start-1]==nums[start]) {
						start++;
					}
				}
			}
		}
		
		
		return resultArr;
	}
}
