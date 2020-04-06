package other;

/**
 * @author hyhcoder
 * @date 2020/3/4 21:16
 */
public class OneToN {
	
	/**
	 * 从1加到100, 用了短路效应;
	 */
	
	public static void main(String[] args) {
		
		System.out.println(sumNums(2));
	
	}
	
	
	public static int sumNums(int n) {
		
		boolean b = (n > 0) && ((n += sumNums(n-1)) > 0);
		return n;
 	}
	
	
}
