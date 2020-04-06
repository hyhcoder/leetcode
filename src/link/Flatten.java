package link;

/**
 * @author hyhcoder
 * @date 2020/3/21 10:29
 *
 * 扁平化多级双向链表
 */
public class Flatten {
	
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
		
		public Node(int val, Node prev, Node next, Node child) {
			this.val = val;
			this.prev = prev;
			this.next = next;
			this.child = child;
		}
	}
	
	// 深度优先遍历
	// 同比二叉树的先序遍历
	public Node flatten(Node head) {
		if (head == null) return head;
		
		// 用头结点, 哨兵
		Node pseudoHead = new Node(0, null, head, null);
		
		flattenDFS(pseudoHead, head);
		
		pseudoHead.next.prev = null;
		return pseudoHead.next;
	}
	/* return the tail of the flatten list */
	public Node flattenDFS(Node prev, Node curr) {
		if (curr == null) {
			return prev;
		}
		curr.prev = prev;
		prev.next = curr;
		
		Node tempNext = curr.next;
		
		Node tail = flattenDFS(curr, curr.child);
		curr.child = null;
		
		return flattenDFS(tail, tempNext);
	}
}
