package array;

/**
 * @author hyhcoder
 * @date 2020/3/26 21:14
 *
 * 999.车的可用捕获量
 */
public class AvailableCapturesForRook {
	
	
	
	public int numRookCaptures(char[][] board) {
	
		int[] nr = new int[]{0,1,-1,0};
		int[] nc = new int[]{1,0,0,-1};
		
		int r = 0,c = 0;
		int res = 0;
		for (int i = 0; i < 8; i++) {
			
			for (int d = 0 ; d < 8 ; d ++) {
				
				if (board[i][d] == 'R') {
					r = i;
					c = d;
					break;
				}
			}
		}
		
		for (int k = 0; k < 4; k++) {
			int rr = r;
			int cc = c;
			
			while (0 < rr && rr < 8 && cc < 8 && cc >0) {
				if (board[rr][cc] == 'B') {
					break;
				}
				if (board[rr][cc] == 'p') {
					res++;
					break;
				}
				rr += nr[k];
				cc += nc[k];
			}
			
		}
		
		
		return res;
	}
}
