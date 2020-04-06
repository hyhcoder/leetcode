package array;

/**
 * @author hyhcoder
 * @date 2020/3/7 18:16
 *
 * 4.寻找两个有序数组的中位数
 */
public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		
		int [] temp1 = new int[]{1,2};
		int [] temp2 = new int[]{3,4};
		MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
		medianOfTwoSortedArrays.findMedianSortedArrays(temp1, temp2);
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	
		// 判断两个长度相加的奇偶数
		// 偶数取中间的相加/2
		// 奇数取中间
		
		int totalLength = nums1.length + nums2.length;
		int key1, key2;
		int result1 = 0, result2 = 0;
		if (totalLength % 2 == 0) {
			key1 = totalLength/2-1;
			key2 = totalLength/2;
		} else {
			key1 = (totalLength-1)/2;
			key2 = key1;
		}
		
		if (nums1.length == 0) {
			result1 = nums2[key1];
			result2 = nums2[key2];
		} else if (nums2.length == 0) {
			result1 = nums1[key1];
			result2 = nums1[key2];
		}
		int tempKey = 0;
		int i = 0;
		int j = 0;
		if (nums1.length != 0 && nums2.length !=0) {

			while (i<=nums1.length-1 && j<=nums2.length-1) {
				
				if (nums1[i] < nums2[j]) {
					
					if (tempKey == key1) {
						result1 = nums1[i];
					}
					if (tempKey == key2) {
						result2 = nums1[i];
					}
					i++;
				} else {
					
					if (tempKey == key1) {
						result1 = nums2[j];
					}
					if (tempKey == key2) {
						result2 = nums2[j];
					}
					j++;
				}
				
				tempKey++;
			}
			
		}
		
		// 理论上这个tempKey应该是大于key2的; 如果小于key2, 就取没拿完的数
		if (tempKey <= key1 || tempKey <= key2) {
			
			while (i <= nums1.length-1) {
				if (tempKey == key1) {
					result1 = nums1[i];
				}
				if (tempKey == key2) {
					result2 = nums1[i];
				}
				i++;
				tempKey ++;
			}
			
			while (j <= nums2.length-1) {
				
				if (tempKey == key1) {
					result1 = nums2[j];
				}
				if (tempKey == key2) {
					result2 = nums2[j];
				}
				j++;
				tempKey ++;
			}
			
		}
		
		
		return Double.valueOf(result1+result2)/2;
	}
	
}
