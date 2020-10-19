package array;

/**
 * @author hyhcoder
 * @date 2020/4/7 21:37
 *
 * 面试题, 寻找二维数组
 */
public class FindNumberIn2DArray {
	
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		
		if (matrix.length == 0) {
			return false;
		}
		int countNum = matrix.length * matrix[0].length;
		
		int i = matrix.length - 1;
		int j = 0;
		while (countNum > 0) {
			
			if (matrix[i][j] == target) {
				return true;
			}
			
			if (matrix[i][j] > target) {
				--i;
				if (i < 0) {
					return false;
				}
				countNum --;
			}
			
			if (matrix[i][j] < target) {
				++j;
				if (j >= matrix[0].length) {
					return false;
				}
				countNum --;
			}
		}
		
		return false;
	}

}
