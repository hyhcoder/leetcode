package String;

/**
 * @author hyhcoder
 * @date 2020/3/16 20:50
 *
 * 翻转字符串里的单词
 *
 */
public class ReverseWords {
	
	public static void main(String[] args) {
		ReverseWords reverseWords = new ReverseWords();
		reverseWords.reverseWords("  hello world!  ");
	}
	
	public String reverseWords(String s) {
		
		String[] temp = s.split(" ");
		
		StringBuilder stringBuilder = new StringBuilder();
		
		
		for (int d = temp.length -1; d >= 0; d--) {
			
			if ("".equals(temp[d])) {
				continue;
			}
			if (stringBuilder.length() != 0) {
				stringBuilder.append(" ");
			}
			//这里对于每个string再反转
			stringBuilder.append(temp[d]);
		}
		
		return stringBuilder.toString();
	}
}
