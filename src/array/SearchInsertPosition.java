package array;

/**
 * @author hyhcoder
 * @date 2020/3/8 16:32
 *
 * 35 搜索插入位置
 */
public class SearchInsertPosition {
	
	public static void main(String[] args) {
		SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
		System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 7));
	}
	
	public int searchInsert(int[] nums, int target) {
	
		int result = 0;
		for (int i = 0 ; i< nums.length; i++) {
			
			if (nums[i] >= target) {
				result = i;
				break;
			}
			
			if (i == nums.length-1 && nums[i] < target) {
				result = i+1;
			}
		}
		
		return result;
	}
	
}
