package array;

import java.util.Arrays;

/**
 * @author hyhcoder
 * @date 2020/3/17 8:13
 *
 * 1160. 拼写单词
 *
 */
public class CountCharacters {
	
	/**
	  思想就是使用了hash表来省时间
	 */
	public int countCharacters(String[] words, String chars) {
		
		int result = 0;
		int[] charsHash = new int[26];
		
		char[] tempChar = chars.toCharArray();
		
		// 这里得到一个hash表
		for (char a:tempChar) {
			charsHash[a - 'a'] ++;
		}
		
		for (String tempStr : words) {
			
			boolean add = true;
			char[] wordChar = tempStr.toCharArray();
			int[] tempHash = Arrays.copyOf(charsHash, charsHash.length);
			for (char cWord:wordChar) {
				tempHash[cWord - 'a'] --;
				// 重置
				if (tempHash[cWord - 'a'] < 0) {
					add = false;
					break;
				}
			}
			
			if (add) {
				result += tempStr.length();
			}
		}
		
		return result;
	}
}
