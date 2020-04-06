package recursion;

/**
 * @author hyhcoder
 * @date 2020/3/18 13:38
 *
 * 递归-爬楼梯
 * 其实是就是斐波那契数列
 */
public class ClimbStairs {
	
	public int climbStairs(int n) {
		
		int[] temp = new int[n + 1];
		return climb(temp,n);
	}
	
	public int climb(int[] memery,int n) {
		
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		if (memery[n] != 0) {
			return memery[n];
		}
		
		memery[n] = (climb(memery, n - 1) + climb(memery, n - 2));
		
		return memery[n];
	}
	
}
