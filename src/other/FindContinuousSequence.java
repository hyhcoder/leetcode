package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyhcoder
 * @date 2020/3/6 20:28
 *
 * 和为s的连续正数序列 面试题57
 */
public class FindContinuousSequence {
	
	
	public static void main(String[] args) {
	
		FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
		findContinuousSequence.findContinuousSequence(9);
		
	}
	
	
	/**
	 * 暴力解法
	 */
	public int[][] findContinuousSequence(int target) {
		
		// 暴力解法
		
		//结果集
		List<int[]> res = new ArrayList<>();
		
		int sum = 0;
		
		for (int i = 1; i <= (target-1)/2 ; i++) {
		 
			for (int j = i; ; j++) {
				
				sum += j;
				// 若大于, 归零
				if (sum > target) {
					sum = 0;
					break;
				} else if (sum == target) {
				
					int[] arr = new int[j-i+1];
					
					for (int k=i; k <= j; k++) {
						arr[k-i] = k;
					}
					res.add(arr);
					break;
				}
			}
		}
		
		return res.toArray(new int[res.size()][]);
	}
	
	/**
	 * 滑动窗口解法
	 */
	public int[][] findContinuous(int target) {
		// 滑动窗口的左边界
		int i = 1;
		// 滑动窗口的右边界
		int j = 1;
		// 滑动窗口中数字的和
		int sum = 0;
		List<int[]> res = new ArrayList<>();
		
		while (i <= target/2) {
			
			if (sum < target) {
				// 右边界向右移动
				sum += j;
				j++;
			} else if (sum > target){
				
				// 左边界向右移动
				sum -= i;
				i++;
				
			} else {
				// 正解
				int[] arr = new int[j-i];
				for (int k=i; k<j; k++) {
					arr[k-i] = k;
				}
				
				res.add(arr);
				
				// 左边界向右移动
				sum -= i;
				i++;
			}
			
			
		}
		
		
		return res.toArray(new int[res.size()][]);
	}
	
}
