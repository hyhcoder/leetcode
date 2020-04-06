package other;

/**
 * @author hyhcoder
 * @date 2020/3/8 13:26
 *
 * 509 斐波那契数列
 */
public class FibonacciNumber {
	
	public static void main(String[] args) {
		FibonacciNumber fibonacciNumber = new FibonacciNumber();
		System.out.println(fibonacciNumber.fibUp(99));
	}
	
	/**
	 * 常规做法
	 */
	public int fib(int N) {
		if (N == 1 || N == 2) {
			return 1;
		}
		return fib(N - 1) + fib(N - 2);
	}
	
	
	/**
	 * 优化方案
	 */
	public int fibUp(int N) {
		
		if (N < 1) {
			return 0;
		}
		
		int[] temp = new int[N + 1];
		
		return youhua(temp, N);
	}
	
	public int youhua(int[] memery, int n) {
		
		if (n == 1 || n == 2) {
			return 1;
		}
		if (memery[n] != 0) {
			return memery[n];
		}
		
		memery[n] = (youhua(memery, n - 1) + youhua(memery, n - 2)) % 1000000007;
		return memery[n];
	}
	
	
	/**
	 * 动态规划做法
	 */
	public int fibDo(int n) {
		if (n == 2 || n == 1)
			return 1;
		int prev = 1, curr = 1;
		for (int i = 3; i <= n; i++) {
			int sum = prev + curr;
			prev = curr;
			curr = sum;
		}
		return curr;
	}
	
}
