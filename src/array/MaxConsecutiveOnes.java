package array;

/**
 * @author hyhcoder
 * @date 2020/3/15 11:47
 *
 * 最大连续1的个数
 *
 */
public class MaxConsecutiveOnes {
	
	public static void main(String[] args) {
		MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
		maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1});
	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
		
		
		int result = 0;
		int temp = 0;
		for (int i = 0; i <= nums.length - 1; i++) {
			
			if (nums[i] == 1) {
				temp ++;
				result = Math.max(result, temp);
			} else {
				temp = 0;
			}
			
		}
		
		return result;
	}
	
}
