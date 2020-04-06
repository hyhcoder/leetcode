package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author hyhcoder
 * @date 2020/3/13 22:08
 *
 * 498 对角线遍历
 */
public class DiagonalTraverse {
	
	
	// 重点是找出规律
	public int[] findDiagonalOrder(int[][] matrix) {
		
		// 前置校验
		if (matrix == null || matrix.length == 0) {
			return new int[0];
		}
		
		// 两个长度
		int n = matrix.length;
		int m = matrix[0].length;
		
		// 结果
		int[] result = new int[n*m];
		int k = 0;
		ArrayList<Integer> intermediate = new ArrayList<>();
		
		
		// 开始遍历
		for (int d = 0; d<n+m; d++) {
			//初始化
			intermediate.clear();
			
			int r = d < m ? 0 : d-m+1; // 因为所有的都在一开始那层遍历
			int c = d < m ? d : m-1;
			
			// 看那边先触壁
			// 这里找出那斜面
			while (r<n && c>-1) {
				
				intermediate.add(matrix[r][c]);
				++r;
				--c;
			}
			
			// 偶数的要翻转
			if (d%2 == 0) {
				
				Collections.reverse(intermediate);
			}
			
			// 变成一个结果
			for (int i = 0 ; i < intermediate.size(); i++) {
				result[k++] = intermediate.get(i);
			}
			
		}
		return result;
	}
}
