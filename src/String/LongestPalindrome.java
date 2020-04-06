package String;

/**
 * @author hyhcoder
 * @date 2020/3/19 6:35
 *
 * 409 最长回文串
 */
public class LongestPalindrome {
	
	// 这个其实统计下字符串里面的字符重复多少, 即可算出;
	// 还要计算下是否有一个落单的;
	public int longestPalindrome(String s) {
	
		int[] resultInteger = new int[58];
		
		//看有无单独的数字
		boolean flag = false;
		int result = 0;
		char[] charStr = s.toCharArray();
		
		for (char tempChar:charStr) {
			resultInteger[tempChar - 'A'] ++;
		}
		
		for (int a : resultInteger) {
			
			result += (a/2)*2;
			
			if (!flag) {
				if (a%2 == 1) {
					flag = true;
				}
			}
			
		}
		
		if (flag) {
			result += 1;
		}
		
		return result;
	}
}
