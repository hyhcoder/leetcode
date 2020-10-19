package dfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hyhcoder
 * @date 2020/4/8 17:02
 *
 * 面试题13. 机器人能走的格子
 */
public class FindRobotWay {
	
	public static void main(String[] args) {
		FindRobotWay findRobotWay = new FindRobotWay();
		System.out.println(findRobotWay.movingCount(2, 3, 1));
	}
	
	public int movingCount(int m, int n, int k) {
	
		int totalNum = 1;
		// 走过的路设置为1, 不能走的也是设置为1
		int[][] reslutMap = new int[m][n];
		
		reslutMap[0][0] = 1;
		Queue<Way> wayQueue = new ArrayDeque<>();
		
		Way aWay = new Way(1, 0);
		Way bWay = new Way(0, 1);
		// 初始化遍历值
		wayQueue.offer(aWay);
		wayQueue.offer(bWay);
		
		while (!wayQueue.isEmpty()) {
			
			Way tempWay = wayQueue.poll();
			
			if (!(tempWay.x >= m || tempWay.y >= n || tempWay.x < 0 || tempWay.y < 0)) {
				
				if (reslutMap[tempWay.x][tempWay.y] != 1) {
				
					int countNum = (tempWay.x/10 + tempWay.x%10) + (tempWay.y/10 + tempWay.y%10);
				
					if (countNum <= k) {
						totalNum ++;
						wayQueue.offer(new Way(tempWay.x + 1, tempWay.y));
						wayQueue.offer(new Way(tempWay.x - 1, tempWay.y));
						wayQueue.offer(new Way(tempWay.x, tempWay.y + 1));
						wayQueue.offer(new Way(tempWay.x, tempWay.y - 1));
					}
					reslutMap[tempWay.x][tempWay.y] = 1;
				}
				
			}
		}
		
		return totalNum;
	}
	
	class Way{
		int x;
		int y;
		public Way(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	

}
