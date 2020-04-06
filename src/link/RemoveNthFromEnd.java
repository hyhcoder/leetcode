package link;

/**
 * @author hyhcoder
 * @date 2020/3/19 8:01
 *
 * 删除链表的倒数第N个节点
 *
 */
public class RemoveNthFromEnd {
	
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		
		RemoveNthFromEnd nthFromEnd = new RemoveNthFromEnd();
		ListNode listNode = nthFromEnd.removeNthFromEnd(listNode1, 1);
		
		System.out.println(listNode);
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		if (head == null) {
			return head;
		}
		
		//2n
		//找出长度
		ListNode listNode = head;
		int length = 0;
		while (listNode != null) {
			listNode = listNode.next;
			length ++;
		}
		
		if (n == length) {
			// 删头
			return head.next;
		}
		
		// 边界问题
		if (n > length) {
			return null;
		}
		//重新遍历
		//定位到要删的前一个
		listNode = head;
		for (int d = 1; d <= length - n - 1; d++) {
			listNode = listNode.next;
		}
		
		listNode.next = listNode.next.next;
		return head;
	}
	
}
