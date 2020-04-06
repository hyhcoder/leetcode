package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hyhcoder
 * @date 2020/3/4 21:31
 *
 * leetcode 994  广度优先搜索
 */
public class RottingOranges {
	
	public static void main(String[] args) {
		
		int [][] tempArray = {{0,2}};
		RottingOranges rottingOranges = new RottingOranges();
		System.out.println(rottingOranges.orangesRotting(tempArray));
	}
	
	class Orange{
		int x, y, minute;
		public Orange(int tempX, int tempY, int tempMinute) {
			x = tempX;
			y = tempY;
			minute = tempMinute;
		}
	}
	
	public int orangesRotting(int[][] grid) {
	
		// 记录时间
		int minute = 0;
		
		//用于存储腐烂点
		Queue<Orange> orangeQueue = new LinkedList<>();
		
		//第一步, 找出所有的腐烂点
		int h = grid.length;
		int w = grid[0].length;
		int count = 0;
		for (int i = 0; i < h; i ++) {
			for (int p = 0; p < w; p ++) {
				
				// 偷偷记录新鲜的果子数
				if (grid[i][p] == 1) {
					count ++;
				}
				
				if (grid[i][p] == 2) {
					orangeQueue.add(new Orange(i,p,minute));
				}
			}
		}
		
		//第二步, 对所有腐烂点进行扩散
		while (!orangeQueue.isEmpty()) {
			
			Orange orange = orangeQueue.poll();
			int x = orange.x;
			int y = orange.y;
			minute = orange.minute;
			
			// 感染一圈, 变成下一代;
            // 左边
			if (y-1 >= 0 && grid[x][y-1] == 1) {
				grid[x][y-1] = 2;
				orangeQueue.add(new Orange(x, y-1, minute + 1));
				count --;
			}
			
			// 右边
			if (y+1 < w && grid[x][y+1] == 1) {
				grid[x][y+1] = 2;
				orangeQueue.add(new Orange(x, y+1, minute + 1));
				count --;
			}
			
			// 上边
			if (x-1 >= 0 && grid[x-1][y] == 1) {
				grid[x-1][y] = 2;
				orangeQueue.add(new Orange(x-1, y, minute + 1));
				count --;
			}
			
			// 下边
			if (x+1 < h && grid[x+1][y] == 1) {
				grid[x+1][y] = 2;
				orangeQueue.add(new Orange(x+1, y, minute + 1));
				count --;
			}
			
		}
		
		if (count > 0) {
			// 还留有新鲜橘子
			return  -1;
		}
		
		return minute;
	}
	
}
