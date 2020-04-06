package array;

/**
 * @author hyhcoder
 * @date 2020/3/11 20:59
 *
 * 1013 将数组分成和相等的三个部分
 */
public class ThreePartsWithEqualSum {
	
	
	public static void main(String[] args) {
		ThreePartsWithEqualSum threePartsWithEqualSum = new ThreePartsWithEqualSum();
		System.out.println(threePartsWithEqualSum.canThreePartsEqualSum(new int[]{10, -10, 10, -10, 10, -10, 10, -10}));
	}
	
	
	public boolean canThreePartsEqualSum(int[] A) {
		int totalSum = 0;
		// 遍历数组, 求和, 如果无法除以3, 那就无解了;
		int threeResult = -1;
		
		// 第一次遍历
		for (int i : A) {
			totalSum += i;
		}
		
		// 只有取余为0才有必要下面
		if (totalSum % 3 == 0) {
			threeResult = totalSum / 3;
			int count = 0;
			// 第二次遍历
			for (int k = 0; k < A.length; k++) {
				int tempSum = 0;
				while (k < A.length) {
					
					tempSum += A[k];
					if (tempSum == threeResult) {
						count++;
						break;
					}
					k++;
					
				}
				
				if (count == 3) {
					return true;
				}
			}
		}
		
		return false;
	}
	

	
}
