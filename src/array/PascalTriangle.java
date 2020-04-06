package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyhcoder
 * @date 2020/3/13 22:04
 * 118 杨辉三角
 */
public class PascalTriangle {
	
	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		pascalTriangle.generate(5);
	}
	
	public List<List<Integer>> generate(int numRows) {
	
		List<List<Integer>> resultList = new ArrayList<>(numRows);
		
		for (int i = 1 ; i <= numRows; i ++) {
			
			List<Integer> tempInteger = new ArrayList<>(i);
			for (int j = 1; j <= i; j ++) {
				
				if (j == 1 || j == i) {
					// 边界
					tempInteger.add(1);
				} else {
					List<Integer> preList = resultList.get(i-2);
					tempInteger.add(preList.get(j-2) + preList.get(j-1));
				}
			}
			resultList.add(tempInteger);
		}
		
		return resultList;
	}
	
}
