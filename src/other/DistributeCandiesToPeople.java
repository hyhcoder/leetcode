package other;

/**
 * @author hyhcoder
 * @date 2020/3/5 22:09
 * 分糖果
 */
public class DistributeCandiesToPeople {
	
	
	public static void main(String[] args) {
	
		DistributeCandiesToPeople distributeCandiesToPeople = new DistributeCandiesToPeople();
		System.out.println(distributeCandiesToPeople.distributeCandies(1000000000,1000));
		
	}
	
	
	public int[] distributeCandies(long candies, int num_people) {
		
		// 求出等差数列最高分多少次
		int count = Double.valueOf((((Math.sqrt(1 + 8 * candies)) - 1 ) / 2)).intValue();
		
		// 分多少次后剩余多少;
		int leaveNum = Long.valueOf(candies - (count * (count + 1) / 2 )).intValue();
		
		// 分多少轮
		int n = Double.valueOf(count / num_people).intValue();
		// 剩余的数
		int leaveN = count - n * num_people;
		
		int[] result = new int[num_people];
		
		// 不够一轮
		if (n == 0) {
			for (int i=0; i < leaveN; i++) {
				result[i] = i + 1 ;
			}
			result[leaveN] = Long.valueOf(leaveNum).intValue();
			
		}
		
		// 至少够一轮的
		if (n > 0) {
			// 前半段
			for (int i = 0; i < leaveN; i++) {
				result[i] = ((i+1 + (num_people*n+i+1))) * (n+1)/2;
			}
			// 中间
			result[leaveN] = ((leaveN+1 + (num_people*(n-1)+leaveN+1))) * n/2 + leaveNum;
			
			// 后半段
			for (int p = leaveN + 1; p < num_people ; p ++) {
				result[p] = ((p+1 + (num_people*(n-1)+p+1))) * n/2;
			}
			
		}
		
		
		return result;
	}
	
}
