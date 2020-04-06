package link;

/**
 * @author hyhcoder
 * @date 2020/3/19 7:58
 *
 *  环形链表 II
 *
 */
public class DetectCycle {
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode2;
		
		DetectCycle detectCycle = new DetectCycle();
		ListNode listNode = detectCycle.detectCycle(listNode1);
		
		System.out.println(listNode);
		
	}
	public ListNode detectCycle(ListNode head) {
	
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		
		ListNode qlistNode = head.next.next;
		ListNode slistNode = head.next;
		
		while (qlistNode != slistNode) {
			if (qlistNode == null ||qlistNode.next == null) {
				return  null;
			}
			qlistNode = qlistNode.next.next;
			slistNode = slistNode.next;
		}
		
		// 这个时候把快指针置为头指针
		qlistNode = head;
		while (qlistNode != slistNode) {
			qlistNode = qlistNode.next;
			slistNode = slistNode.next;
		}
		
		return qlistNode;
	}
}
