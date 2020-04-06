package tree; /**
 * @author hyhcoder
 * @date 2020/3/10 20:55
 *
 * 543 二叉树的直径
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class DiameterOfBinaryTree {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	int result;
	public int diameterOfBinaryTree(TreeNode root) {
		
		// 求左边的最长
		// 求右边的最长
		// 相加即可
		result = 1;
		getHeight(root);
		return result - 1;
	}
	
	
	public int getHeight(TreeNode root) {
		
		if (root == null) {
			// 空节点, 为0
			return 0;
		}
		
		// 求左边深度
		int L = getHeight(root.left);
		// 求右边深度
		int R = getHeight(root.right);
		
		result = Math.max(result, L+R+1);
		return Math.max(L, R) + 1;
	}
	
	

}
