package String;

/**
 * @author hyhcoder
 * @date 2020/10/17 10:32
 */
public class FindMaxNumWord {
	
	/**
	 *
	 * 找出出现频次最高的字母
	 *
	 */
	
	public static void main(String[] args) {
		
		String test = "aaabbbbccccddddaaaaaaaaaa";
		
		// 词频数组, 因为固定为a-z, 所以最小化使用即可;不然用hashmap
		int [] wordFreq = new int[26];
		// 先统计词频
		char[] testchar = test.toCharArray();
		for (char c : testchar) {
			wordFreq[c-'a'] ++;
		}
		
		// 再找出最高的, 因为可能重复, 所以用最前的覆盖最后的, 从后遍历;
		int maxNum = 0;
		char resultChar = 'a';
		for (int i = 25; i >= 0; i--) {
			if (wordFreq[i] >= maxNum) {
				maxNum = wordFreq[i];
				// 如果是遍历map, 这步其实就是key罢了
				resultChar = (char) ('z' - 25 + i);
			}
		}
		
		System.out.println(resultChar);
	}
}
