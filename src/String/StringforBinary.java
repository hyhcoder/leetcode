package String;

import sun.print.SunMinMaxPage;

/**
 * @author hyhcoder
 * @date 2020/3/14 21:57
 *
 * 二进制求和
 */
public class StringforBinary {
	
	public static void main(String[] args) {
		StringforBinary stringforBinary = new StringforBinary();
		stringforBinary.addBinary("1010","1011");
	}
	
	public String addBinary(String a, String b) {
	
		int total = Math.max(a.length(), b.length());
		
		String result = "";
		char[] achar = a.toCharArray();
		char[] bchar = b.toCharArray();
		
		// 进位
		int digit = 0;
		for (int d = 0; d <= total-1; d++) {
			
			int tempA = a.length() - 1 - d < 0 ? 0 : achar[a.length() - 1 - d] -'0';
			int tempB = b.length() - 1 - d < 0 ? 0 : bchar[b.length() - 1 - d] -'0';
			
			int sum = tempA^tempB^digit;

			int digitSum = tempA + tempB + digit;
			if (digitSum == 3 || digitSum == 2) {
				digit = 1;
			} else {
				digit = 0;
			}
			
			result = sum + result;
		}
		
		if (digit == 1) {
			result  = "1" + result;
		}
		
		return result;
	}
	
}
