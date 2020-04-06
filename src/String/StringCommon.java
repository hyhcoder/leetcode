package String;

/**
 * @author hyhcoder
 * @date 2020/3/12 15:21
 *
 * 1071 求字符串的最大公约数
 */
public class StringCommon {
	
	
	public static void main(String[] args) {
		StringCommon stringCommon = new StringCommon();
		stringCommon.gcdOfStrings("CTCXKCTCXKCTCXKCTCXKCTCXKCTCXKCTCXKCTCXKCTCXKCTCXKCTCXK"
				,"CTCXKCTCXKCTCXKCTCXKCTCXKCTCXKCTCXKCTCXKCTCXK");
	}
	
	
	/**
	 * 也可以从数学角度出发, 求两个字符串长度的公约数, 然后截取那个最短的
	 *
	 */
	public String gcdOfStrings(String str1, String str2) {
		
		
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		}
		
		
		int n = Math.min(str1.length(), str2.length());
		
		for (int i = n ; i >= 0 ; i --) {
			
			String temp = str1.substring(0,i);
			
			if (str1.split(temp).length == 0 && str2.split(temp).length == 0) {
				return temp;
			}
			
		}
		
		return "";
	}

}
