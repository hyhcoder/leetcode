package array;


/**
 * @author hyhcoder
 * @date 2020/3/22 12:13
 * 238 除自身以外数组的乘积
 */
public class ProductExceptSelf {
	
	
	public int[] productExceptSelf(int[] nums) {
	
		
		// 分拆成左右两个数组
		int[] L = new int[nums.length];
		int[] R = new int[nums.length];
		int[] result = new int[nums.length];
		
		
		// 初始化L
		L[0] = 1;
		for (int d = 1; d < nums.length; d++) {
			L[d] = nums[d - 1] * L[d -1];
		}
		
		// 初始化R
		R[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0 ; i -- ) {
			
			R[i] = nums[i+1] * R[i + 1];
		}
		
		for (int i = 0; i < nums.length; i ++) {
			result[i] = L[i] * R[i];
		}
		
		return result;
	}
	
	
	// 优化 O(1) 空间
	public int[] productExceptSelf2(int[] nums) {
		
		// 把res当成L;
		int[] res = new int[nums.length];
		
		res[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[i] = nums[i-1] * res[i-1];
		}
		
		// 把r在计算中就及时汇总
		int R = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			
			// For the index 'i', R would contain the
			// product of all elements to the right. We update R accordingly
			res[i] = res[i] * R;
			R *= nums[i];
		}
		
		return res;
	}
	
}
