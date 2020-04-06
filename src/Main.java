import link.ListNode;
import link.RemoveNthFromEnd;

import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
	
		Main main = new Main();
		main.sortArray(new int[]{5,2,3,1});
	}
	
	public int[] sortArray(int[] nums) {
	
		int[] temp = new int[nums.length];
		mergeSort(nums, 0, nums.length-1, temp);
	
		return nums;
	}
	
	public void mergeSort(int[] nums, int p, int r, int[] temp) {
		
		//递归终止
		if (p >= r) {
			return;
		}
		
		//q 取中间
		int q = (p + r) /2;
		
		//递归
		mergeSort(nums, p, q, temp);
		mergeSort(nums, q+1, r, temp);

		// 最后合并
		merge(nums, p, q, r, temp);
	}
	
	
	public void merge(int[] nums, int p, int q, int r, int[] temp){
		
		int i = p, j = q+1, k = 0;
		
		while (i<= q && j <= r) {
			
			if (nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}
		
		// 判断剩余数组
		int start = i, end = q;
		if (j <= r) {
			start = j;
			end = r;
		}
		
		while (start <= end) {
			temp[k++] = nums[start++];
		}
		
		// 将temp数组拷贝回原数组
		for (i = 0; i <= r-p; i++) {
			nums[p+i] = temp[i];
		}
		
	}
}
