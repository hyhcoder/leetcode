package doublepoint;

/**
 * @author hyhcoder
 * @date 2020/3/7 20:07
 *
 * 11 盛最多水的容器
 */
public class ContainerWater {
	
	public static void main(String[] args) {
		int[] temp = new int[]{2,3,4,5,18,17,6} ;
		ContainerWater containerWater = new ContainerWater();
		containerWater.maxArea(temp);
	}
	
	public int maxArea(int[] height) {
	
		int start = 0;
		int end = height.length - 1;
		int result = 0;
		
		int x;
		int y;
		for (;start<end;) {
			
			// 特殊处理
			/*if (height[start] < 2) {
				start ++;
			}
			if (height[end] < 2) {
				end --;
			}*/
			
			x = end - start;
			if (height[start] <= height[end]) {
				y = height[start];
			} else {
				y = height[end];
			}
			
			
			if (height[start] <= height[end]) {
				start ++;
			} else if (height[start] > height[end]) {
				end --;
			}
			
			if (result < x*y) {
				result = x*y;
			}
			
			if (x <= 1) {
				break;
			}
			
		}
		
		return result;
		
		
	}
	
}
