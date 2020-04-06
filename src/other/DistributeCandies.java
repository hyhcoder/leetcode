package other;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author hyhcoder
 * @date 2020/3/5 21:48
 *
 * 分糖果  575
 */
public class DistributeCandies {
	
	
	public static void main(String[] args) {
	
	}
	
	
	public int distributeCandies(int[] candies) {
	
		int count = 0;
		
		Set<Integer> candieSet = new TreeSet<>();
		
		for (int i=0; i < candies.length; i++) {
			
			// 若满足最高
			if (candieSet.size() >= candies.length/2){
				count = candies.length/2;
				break;
			}
			
			// 如果不存在, 就放进set
			if (!candieSet.contains(candies[i])) {
				candieSet.add(candies[i]);
			}
		}
		
		if (count != candies.length/2) {
			count = candieSet.size();
		}
		
		
		return count;
		
	}
}
