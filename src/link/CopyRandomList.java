package link;

import java.util.HashMap;

/**
 * @author hyhcoder
 * @date 2020/3/21 10:31
 *
 * 复制带随机指针的链表
 */
public class CopyRandomList {
	
	class Node {
		int val;
		Node next;
		Node random;
		
		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	
	// 保存访问过的路径
	HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();
	//想象是一个图, 然后进行回溯
	public Node copyRandomList(Node head) {
	
		if (head == null) {
			return null;
		}
		
		if (visitedHash.containsKey(head)) {
			return visitedHash.get(head);
		}
		
		
		Node node = new Node(head.val);
		//存入hash
		this.visitedHash.put(head, node);
		
		// 递归复制;
		node.next = this.copyRandomList(head.next);
		node.random = this.copyRandomList(head.random);
		
		return node;
	}
}
