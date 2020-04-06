package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyhcoder
 * @date 2020/3/16 12:13
 *
 * 杨辉三角2
 */
public class PascalTriangle_ii {
	
	
	public List<Integer> getRow(int rowIndex) {
		
		List<Integer> integerList = new ArrayList<>(rowIndex+1);
		Long num = 1L;
		
		for (int j = 0; j <= rowIndex; j++) {
			
			integerList.add(num.intValue());
			num = num * (rowIndex - j) / (j + 1);
		}
		return integerList;
	}
	


}
