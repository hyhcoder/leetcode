package String;

/**
 * @author hyhcoder
 * @date 2020/3/16 8:02
 *
 * 字符串压缩
 *
 */
public class CompressString {
	
	public String compressString(String str) {
		// 压缩字符串
		StringBuilder res = new StringBuilder();
		
		if (str.length() == 1) {
			return str;
		}
		
		char[] chars = str.toCharArray();
		// 默认至少一个
		int num = 1;
		for(int i = 0; i < chars.length-1; i++) {
			
			if (chars[i] != chars[i+1]) {
				res.append(chars[i]);
				res.append(num);
				// 重置
				num = 1;
			} else {
				num++;
			}
			// 最后一种的情况
			if (i == chars.length - 2) {
				res.append(chars[i+1]);
				res.append(num);
			}
		}
		
		// 若压缩后还太长
		if (res.length() >= str.length()) {
			return str;
		}
		
		return res.toString();
	}
}
