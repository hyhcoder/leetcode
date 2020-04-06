package array;

/**
 * @author hyhcoder
 * @date 2020/3/11 22:02
 *
 * 724. 寻找数组的中心索引
 *
 */
public class FindPivotIndex {
	
	public static void main(String[] args) {
		FindPivotIndex findPivotIndex = new FindPivotIndex();
		System.out.println(findPivotIndex.pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
	}
	
	
	public int pivotIndex(int[] nums) {
		
		
		int length = nums.length;
		
		//if (nums.length <= 2) {
		//	return -1;
		//}
		
		int leftR = 0;
		
		int rightR = 0;
		
		int p = length-1;
		
		for (int i = 0; i <= length - 1; i++) {
			
			
			if (i > 0) {
				// 计算左侧求和
				leftR += nums[i - 1];
			}
			
			if (i == 0) {
				// 计算右侧求和
				while (p > i) {
					rightR += nums[p];
					p--;
				}
			} else {
				rightR -= nums[i];
			}
			
			if (leftR == rightR) {
				return i;
			}
		}
		
		return -1;
		
		
	}
}
