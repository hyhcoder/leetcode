package array;

import java.util.Arrays;

/**
 * @author hyhcoder
 * @date 2020/3/7 15:22
 *
 * 面试题 10.01. 合并排序的数组
 */
public class SortedMerge {
	
	/**
	 * 偷鸡做法
	 */
	public void merge(int[] A, int m, int[] B, int n) {
	
		for (int i = 0; i < n; i++ ) {
			
			A[m] = B[i];
			m++;
		}
		
		Arrays.sort(A);
		
	}
	
	/**
	 * 正规做法
	 */
	public void mergeByMe(int[] A, int m, int[] B, int n) {
		
		// 从后往前怼
		int i = m-1;
		int j = n-1;
		
		int end = n+m-1;
		
		while (i>=0&&j>=0) {
			
			if (A[i] > B[j]) {
				A[end--] = A[i--];
			}else {
				A[end--] = B[j--];
			}
			
		}
		
		while (j>=0) {
			// 若B没有合并完, 需要做最后的合并
			A[end--] = B[j--];
		}
		
	}
}
