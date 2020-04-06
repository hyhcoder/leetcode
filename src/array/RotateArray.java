package array;

/**
 * @author hyhcoder
 * @date 2020/3/16 21:10
 *
 * 旋转数组
 */
public class RotateArray {
	
	
	//思想是环状替换
	//关键是找到结束点
	//变成圆环
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
			} while (start != current);
		}
	}
}
