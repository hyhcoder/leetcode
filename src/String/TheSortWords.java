package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hyhcoder
 * @date 2020/10/17 13:02
 */
public class TheSortWords {
	
	
	/**
	 * 多个有序集合排序
	 */
	public static void main(String[] args) {
		
		/*Integer[] a1 = new Integer[]{1, 5, 2, 4, 6, 7, 8};
		Integer[] a2 = new Integer[]{2, 3, 10, 5, 6, 7, 8};
		Integer[] a3 = new Integer[]{4, 5, 6, 2, 3, 46, 7, 8, 9};
		Integer[] a4 = new Integer[]{2, 7, 9, 2, 3, 3, 3, 5, 5, 6, 7};
		Integer[] a5 = new Integer[]{4, 9, 10, 3, 4, 5, 6, 6, 7, 7, 5};
		
		List<Integer[]> a = new ArrayList<>();
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		a.add(a5);*/
		
		Integer[] a11 = new Integer[]{1, 5, 2, 4, 6, 7, 8};
		
		List<Integer> a1 = new ArrayList<>(Arrays.asList(a11));
		List<Integer> a2 = new ArrayList<>(Arrays.asList(2, 3, 10, 5, 6, 7, 8));
		List<Integer> a3 = new ArrayList<>(Arrays.asList(4, 5, 6, 2, 3, 46, 7, 8, 9));
		List<Integer> a4 = new ArrayList<>(Arrays.asList(2, 7, 9, 2, 3, 3, 3, 5, 5, 6, 7));
		List<Integer> a5 = new ArrayList<>(Arrays.asList(4, 9, 10, 3, 4, 5, 6, 6, 7, 7, 5));
		
		List<List<Integer>> a = new ArrayList<>();
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		a.add(a5);
		
		List<List<Integer>> returnList = new ArrayList<>();
		
		long start = System.currentTimeMillis();
		descartRecursive(a, 0, returnList, new ArrayList<>());
		//descartesRecursive(a, 0,returnList, new ArrayList<>());
		
		for (List<Integer> integerList : returnList) {
			System.out.println(integerList);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		//printNums(a1, a2, a3, a4, a5);
		
	}
	
	private static void printNums(int[] a1, int[] a2, int[] a3, int[] a4, int[] a5) {
		
		long start = System.currentTimeMillis();
		// 保证a1小于a2, a2小于a3, a3小于a4, a4小于a5, 其实就是单调递增
		
		// 先来暴力解, 代码有点恶心
		// 剪枝
		for (int i : a1) {
			
			for (int i1 : a2) {
				if (i >= i1) {
					continue;
				}
				
				for (int i2 : a3) {
					if (i1 >= i2) {
						continue;
					}
					
					for (int i3 : a4) {
						if (i2 >= i3) {
							continue;
						}
						for (int i4 : a5) {
							if (i3 >= i4) {
								continue;
							}
							
							System.out.println(i + " " + i1 + " " + i2 + " " + i3 + " " + i4);
							
						}
					}
				}
				
			}
			
			
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
	
	/**
	 * 使用递归实现, 暴力一种, 需要剪枝
	 */
	private static void descartRecursive(List<List<Integer>> intputList, int position, List<List<Integer>> returnList, List<Integer> cacheList) {
		
		List<Integer> nums = intputList.get(position);
		
		
		for (int i = 0; i < nums.size(); i++) {
			
			List<Integer> cList;
			
			if (i == nums.size() - 1) {
				// 如果弄到最后, 就没必要新增list, 直接用旧的;
				cList = cacheList;
			} else {
				cList = new ArrayList<>(cacheList);
			}
			
			if (cacheList.size() > 0) {
				// 剪枝, 若后面的小于等于前面的, 去除
				if (nums.get(i) <= cacheList.get(cacheList.size() - 1)) {
					continue;
				}
			}
			
			cList.add(nums.get(i));
			// 遍历到最后退出递归
			if (position == intputList.size() - 1) {
				returnList.add(cList);
				continue;
			}
			descartRecursive(intputList, position + 1, returnList, cList);
		}
	}
	
	
	private static <T> void descartesRecursive(List<List<T>> originalList, int position, List<List<T>> returnList, List<T> cacheList) {
		List<T> originalItemList = originalList.get(position);
		for (int i = 0; i < originalItemList.size(); i++) {
			//最后一个复用cacheList，节省内存
			List<T> childCacheList = (i == originalItemList.size() - 1) ? cacheList : new ArrayList<>(cacheList);
			childCacheList.add(originalItemList.get(i));
			if (position == originalList.size() - 1) {//遍历到最后退出递归
				returnList.add(childCacheList);
				continue;
			}
			descartesRecursive(originalList, position + 1, returnList, childCacheList);
		}
	}
	
	
}
