package array;

/**
 * @author hyhcoder
 * @date 2020/3/15 12:35
 *
 * 移动零
 */
public class MoveZeroes {
	
	public void moveZeroes(int[] nums) {
	
		int begin = 0;
		int end = 1;
		
		
		while (end < nums.length) {
			
			if (nums[begin] == 0) {
				if (nums[end] == 0) {
					end ++;
				} else {
					//表示可以交换
					int temp = nums[begin];
					nums[begin] = nums[end];
					nums[end] = temp;
					begin++;
					end ++;
				}
			} else {
				begin++;
				end ++;
			}
			
		}
		
	}
	
}
