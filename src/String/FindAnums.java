package String;

/**
 * @author hyhcoder
 * @date 2020/10/17 10:22
 */
public class FindAnums {
	
	/**
	 * 找出'a'的出现的次数
	 */
	public static void main(String[] args) {
		
		String test = "aaacccc";
		
		int result = 0;
		
		if (test != null) {
			char[] testChar = test.toCharArray();
			
			for (char c : testChar) {
				if (c == 'a') {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	
}
