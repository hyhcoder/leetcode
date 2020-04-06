package array;

/**
 * @author hyhcoder
 * @date 2020/3/16 8:04
 *
 * 27 移除数字
 */
public class RemoveElement {
	
	public int removeElement(int[] nums, int val) {
		int start = 0;
		int end = 0;
		
		if (nums[start] != val) {
			end++;
			start++;
		}
		while (end <= nums.length -1) {
			
			if (nums[start] == val) {
				while(end <= nums.length -1 && nums[end] == val) {
					end ++;
				}
				if (end <= nums.length -1 && nums[end] != val) {
					//只有移动才减少
					int temp = nums[start];
					nums[start] = nums[end];
					nums[end] = temp;
				}
			} else {
				
				start ++;
				end ++;
			}
		}
		
		return start;
	}
}
