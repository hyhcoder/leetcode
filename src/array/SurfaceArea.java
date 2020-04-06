package array;

/**
 * @author hyhcoder
 * @date 2020/3/25 21:31
 *
 * 三维形体的表面积
 */
public class SurfaceArea {
	
	
	public int surfaceArea(int[][] grid) {
		
		//记录4个方向的值
		int[] dr = new int[]{0, 1, 0, -1};
		int[] dc = new int[]{1, 0, -1, 0};
		
		// 从6面来算面积;
		
		int res = 0;
		for (int d = 0; d < grid[0].length; d++) {
			
			for (int i = 0; i < grid.length; i++) {
			
				int temp = 0;
				int val = grid[d][i];
				
				if (val > 0) {
					temp += 2;
					
					//4个方向判断;
					for (int k = 0; k < 4; ++k) {
						int nr = d + dr[k];
						int nc = i + dc[k];
						int nv = 0;
						if (0 <= nr && nr < grid[0].length && 0 <= nc && nc < grid.length) {
							nv = grid[nr][nc];
						}
						temp += Math.max(grid[d][i] - nv, 0);
					}
				}
				res += temp;
			
			}
			
		}
		
		return res;
	}
	
}
