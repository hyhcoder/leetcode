package array;

/**
 * @author hyhcoder
 * @date 2020/4/7 20:56
 *
 * 面试题 01.07. 旋转矩阵
 */
public class RotateMatrix {
	
	public static void main(String[] args) {
		RotateMatrix rotateMatrix = new RotateMatrix();
		rotateMatrix.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	}
	
	public void rotate(int[][] matrix) {
		int[][] tempMatrix = new int[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				tempMatrix[i][j] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int r = matrix.length - j - 1;
				matrix[i][j] = tempMatrix[r][i];
			}
		}
	}

}
