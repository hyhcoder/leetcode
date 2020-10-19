package String;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author hyhcoder
 * @date 2020/10/17 11:01
 */
public class SortWordByFreq {
	
	
	/**
	 * 根据出现频次排序
	 */
	public static void main(String[] args) {
		
		String test = "aaaaabfdfdfdfdfsdfsfszzdfdiouo";
		
		// 统计词频
		int[] wordFreq = new int[128];
		
		char[] testChar = test.toCharArray();
		for (char c : testChar) {
			wordFreq[c] ++;
		}
		
		
		// 累积字母
		HashMap<Integer, String> wordMap = new HashMap<>(128);
		
		// 把次数相同的累积, 然后字母表前面的放在前面
		for (int i = 0; i < 128; i++) {
			if (wordFreq[i] != 0) {
				if (wordMap.containsKey(wordFreq[i])) {
					String newStr = wordMap.get(wordFreq[i]).concat(buildString(wordFreq[i], (char)i));
					wordMap.put(wordFreq[i],newStr);
				
				} else {
					wordMap.put(wordFreq[i],buildString(wordFreq[i], (char)i));
				}
			}
		}
		
		Integer[] nums = wordMap.keySet().toArray(new Integer[]{});
		// 需要排序
		Arrays.sort(nums, (n1, n2) ->  n2 - n1);
		
		StringBuilder resultStringBuilder = new StringBuilder();
		for (Integer num : nums) {
			
			resultStringBuilder.append(wordMap.get(num));
			
		}
		
		System.out.println(resultStringBuilder);
	}
	
	private static String buildString(int times, char word) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i = 0; i < times; i ++) {
			stringBuilder.append(word);
		}
		
		return stringBuilder.toString();
	}
}
