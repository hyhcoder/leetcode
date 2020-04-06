package link;

/**
 * @author hyhcoder
 * @date 2020/3/21 10:27
 *
 * 旋转链表
 */
public class RotateRight {
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		/*ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);*/
		
		listNode1.next = listNode2;
		/*listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;*/
		
		RotateRight rotateRight = new RotateRight();
		ListNode listNode = rotateRight.rotateRight(listNode1,2);
		System.out.println(listNode);
	}
	
	public ListNode rotateRight(ListNode head, int k) {
		
		if (k <= 0 || head == null || head.next == null) {
			return head;
		}
		
		int length = 1;
		
		ListNode tempNode = head;
		
		while (tempNode.next != null) {
			
			tempNode = tempNode.next;
			length++;
		}
		
		int t = length - (k % length);
		if (t == length) {
			return head;
		}
		
		tempNode = head;
		for (int d = 0; d < t - 1; d++) {
			tempNode = tempNode.next;
		}
		
		// 这个就是切断
		ListNode resultNode = tempNode.next;
		tempNode.next = null;
		
		// 找到尾部, 接入头部
		tempNode = resultNode;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		tempNode.next = head;
		
		return resultNode;
	}
}
