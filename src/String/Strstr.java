package String;

/**
 * @author hyhcoder
 * @date 2020/3/15 10:18
 *
 * 28 实现strStr()
 */
public class Strstr {
	
	public static void main(String[] args) {
		Strstr strstr = new Strstr();
		System.out.println(strstr.strStr("mississippi","issip"));
	}
	
	/**
	 * 暴力方案
	 */
	public int strStr(String haystack, String needle) {
		
		if (needle.length() == 0) {
			return 0;
		}
		
		char[] aChars = haystack.toCharArray();
		char[] bChars = needle.toCharArray();
		
		int aLink = 0;
		int bLink = 0;
		
		while (aLink < haystack.length()) {
			
			bLink = 0;
			while (bLink < needle.length()) {
				if (aLink + bLink == haystack.length()) {
					return -1;
				}
				
				if (aChars[aLink+bLink] == bChars[bLink]) {
					
					if (bLink == needle.length()-1) {
						return aLink;
					}
					bLink++;
				} else {
					break;
				}
			}
			
			aLink++;
		}
		
		return -1;
	}
	
	
	/**
	 * 优化方案
	 */
	public int strStrYou(String haystack, String needle) {
		
		if (needle.length() == 0) {
			return 0;
		}
		int h = haystack.length();
		int n = needle.length();
		
		for (int i = 0; i < h-n+1; i++ ) {
			if (haystack.substring(i, i+n).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

}
