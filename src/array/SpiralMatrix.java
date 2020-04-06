package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyhcoder
 * @date 2020/3/13 22:06
 *
 * 54 螺旋矩阵
 *
 */
public class SpiralMatrix {
	
	public static void main(String[] args) {
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		spiralMatrix.spiralOrder(new int[][]{{1}});
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> resultList = new ArrayList<>();
		
		if (matrix == null || matrix.length == 0) {
			return resultList;
		}
		
		int m = matrix[0].length;
		int n = matrix.length;
		int total = m*n;
		// 限制向左
		int l = 0;
		// 限制向上
		int u = 1;
		
		int r = 0;
		int c = 0;
		
		// 1-4, 4种模式, 一种是向右, 一种是向下, 一种是向左, 一种是向上;
		int model = 1;
		
		for (int d = 0 ; d < total; d++) {
			if (c == m-1 && model == 1) {
				model = 2;
			}
			
			if (c < m-1 && model == 1) {
				// 第一种
				resultList.add(matrix[r][c]);
				c++;
				if (c == m -1) {
					model = 2;
					m--;
					continue;
				}
			}
			
			if (model == 2) {
				// 第二种模式
				resultList.add(matrix[r][c]);
				r++;
				if (r == n - 1) {
					model = 3;
					n--;
					continue;
				}
			}
			
			if (model == 3) {
				// 第三种模式
				resultList.add(matrix[r][c]);
				c--;
				if (c == l) {
					model = 4;
					l++;
					continue;
				}
			}
			
			if (model == 4) {
				// 第四种模式
				resultList.add(matrix[r][c]);
				r--;
				if (r == u) {
					model = 1;
					u++;
				}
			}
			
		}
		
		return resultList;
		
	}
	
}
