package dp;

/**
 * @author hyhcoder
 * @date 2020/4/6 10:14
 *
 * 72. 编辑距离
 */
public class EditDistance {
	
	public int minDistance(String word1, String word2) {
	
		char[] word1char = word1.toCharArray();
		char[] word2char = word2.toCharArray();
		int[][] dpnum = new int[word1.length()][word2.length()];
		return dp(word1char, word2char, word1.length()-1, word2.length()-1, dpnum);
	}

	public int dp(char[] word1, char[] word2, int i, int j,int[][] dpnum) {
		
		if (i == -1) {
			return j + 1;
		}
		
		if (j == -1) {
			return i + 1;
		}
		
		if (dpnum[i][j] != 0) {
			return dpnum[i][j];
		}
		
		if (word1[i] == word2[j]) {
			//若一样就什么都不做
			int result = dp(word1, word2, i - 1, j -1,dpnum);
			dpnum[i][j] = result;
			return result;
		}else {
			//插入
			int a = dp(word1, word2, i, j-1, dpnum) + 1;
			//删除
			int b = dp(word1, word2, i-1, j, dpnum) + 1;
			//替换
			int c = dp(word1, word2, i-1, j-1, dpnum) + 1;
			int result = Math.min(Math.min(a, b),c);
			dpnum[i][j] = result;
			return result;
		}
	}
}
