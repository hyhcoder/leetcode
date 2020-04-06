package String;

/**
 * @author hyhcoder
 * @date 2020/3/15 11:24
 */
public class ReverseString {
	
	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString();
		char[] temp = new char[]{'h','e','l','l','o'};
		reverseString.reverseString(temp);
	}
	public void reverseString(char[] s) {
	
		int begin = 0;
		int end = s.length -1;
		
		char temp;
		while (begin <= end) {
			
			temp = s[begin];
			s[begin] = s[end];
			s[end] = temp;
			
			begin++;
			end--;
		}
	}
}
