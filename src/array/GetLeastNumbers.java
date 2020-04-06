package array;

import java.util.Arrays;

/**
 * @author hyhcoder
 * @date 2020/3/20 6:37
 *
 * 最小的k个数
 */
public class GetLeastNumbers {
	
	// 可以看看BFPRT算法
	// 排序, 最小堆, 快排思想
	public int[] getLeastNumbers(int[] arr, int k) {
		Arrays.sort(arr);
		return Arrays.copyOf(arr,k);
	}
}
