package String;


/**
 * @author hyhcoder
 * @date 2020/3/15 11:17
 *
 * 14 最长公共前缀
 */
public class LongestCommonPre {
	
	public static void main(String[] args) {
		LongestCommonPre longestCommonPre = new LongestCommonPre();

		String[] temp = new String[]{"a"};
		System.out.println(longestCommonPre.longestCommonPrefix(temp));
	}
	public String longestCommonPrefix(String[] strs) {
	
		String result = "";
		if (strs.length == 0) {
			return "";
		}
		
		int minLength = strs[0].length();
		// 第一次遍历
		for (String tempStr : strs) {
			//找出最小的长度
			minLength = Math.min(tempStr.length(), minLength);
		}
		
		for (int d = 0; d <= minLength-1; d++) {
			String temp = strs[0].substring(0,d+1);
			for (String tempStr: strs) {
				if (!temp.equals(tempStr.substring(0,d+1))) {
					return strs[0].substring(0,d);
				}
			}
			
			result = temp;
			
		}
		
		return result;
	}
}
