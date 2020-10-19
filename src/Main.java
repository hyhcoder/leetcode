import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<List<Integer>> inputList = new ArrayList<>();
		
		// 先把输入的数据整理了
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			String[] inputString = input.split(",");
			ArrayList<Integer> temp = new ArrayList<>();
			for (String s : inputString) {
				temp.add(Integer.valueOf(s));
			}
			inputList.add(temp);
		}
		
		// 先用粗暴解法, 默认5个, 这代码很不优雅
		//outNums(inputList.get(0), inputList.get(1), inputList.get(2), inputList.get(3), inputList.get(4));
		
		// 其实整个题目就是计算所有组合, 然后适当剪枝
		// 使用递归实现
		descartesRecus(inputList,0, new ArrayList<>());
	}
	
	
/*	private static void outNums(List<Integer> a1, List<Integer> a2, List<Integer> a3, List<Integer> a4,
			List<Integer> a5) {
		
		for (Integer n1 : a1) {
			
			for (Integer n2 : a2) {
				if (n2 <= n1) {
					continue;
				}
				for (Integer n3 : a3) {
					if (n3 <= n2) {
						continue;
					}
					for (Integer n4 : a4) {
						if (n4 <= n3) {
							continue;
						}
						for (Integer n5 : a5) {
							if (n5 <= n4) {
								continue;
							}
							System.out.println(n1 + "," + n2 + "," + n3 + "," + n4 + "," + n5);
						}
					}
				}
			}
		}
	}*/
	
	
	/**
	 * 用递归, 可以保证N个都可以实现
	 */
    private static void descartesRecus(List<List<Integer>> inputList, int ops, List<Integer> cacheList) {
    
    	// 每层遍历
    	List<Integer> tempList = inputList.get(ops);
	
		for (int i = 0; i < tempList.size(); i++) {
			
			List<Integer> cList;
			if (i == tempList.size() - 1) {
				// 如果是最后一次, 不用开辟地址空间, 省多一步
				cList = cacheList;
			} else {
				cList = new ArrayList<>(cacheList);
			}
			
		
			// 这里要剪枝, 去掉不符合的
			if (cList.size() > 0) {
				// 后面的小于或等于前面的, 跳过
				if (tempList.get(i) <= cList.get(cList.size() - 1)) {
					continue;
				}
			}
			// 拼接
			cList.add(tempList.get(i));
			
			if (ops == inputList.size() - 1) {
				//这里就是每个集合的结果
				StringBuilder stringBuilder = new StringBuilder();
				for (int i1 = 0; i1 < cList.size(); i1++) {
					if (i1 == cList.size() - 1) {
						stringBuilder.append(cList.get(i1));
					} else {
						stringBuilder.append(cList.get(i1)).append(",");
					}
				}
				System.out.println(stringBuilder.toString());
				continue;
			}
			descartesRecus(inputList, ops+1, cList);
		}
	}
}
