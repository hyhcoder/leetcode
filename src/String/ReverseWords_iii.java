package String;

/**
 * @author hyhcoder
 * @date 2020/3/16 20:45
 *
 * 反转字符串中的单词 III
 *
 */
public class ReverseWords_iii {
	
	
	public String reverseWords(String s) {
		
		char[] charStr = s.toCharArray();
		
		int begin = 0;
		int end = 0;
		
		int count = 0;
		// 记录空格所在位置
		int blackLocation = 0;
		
		while (begin <= charStr.length-1) {
			
			while (end <= charStr.length - 1 && charStr[end] != ' ') {
				end ++;
			}
			blackLocation = end;
			
			if (end != charStr.length-1) {
				--end;
			}
			count = end;
			while (begin <= end) {
				char temp = charStr[begin];
				charStr[begin] = charStr[end];
				charStr[end] = temp;
				begin ++;
				end --;
			}
			// 这里跳过空格
			begin = blackLocation + 1;
			while(begin <= charStr.length - 1 && charStr[begin] == ' ') {
				begin ++;
			}
			end = begin;
		}
		
		return String.copyValueOf(charStr);
	}
}
