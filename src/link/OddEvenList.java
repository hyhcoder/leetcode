package link;


/**
 * @author hyhcoder
 * @date 2020/3/19 22:29
 *
 * 奇偶链表
 *
 * 把奇数和偶数的挪在一起
 */
public class OddEvenList {
	
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		//listNode3.next = listNode4;
		//listNode4.next = listNode5;
		
		OddEvenList oddEvenList = new OddEvenList();
		ListNode listNode = oddEvenList.oddEvenList(listNode1);
		System.out.println(listNode);
	}
	
	public ListNode oddEvenList(ListNode head) {
	
		// 空, 1个, 2个的情况
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		
		// 分拆两个, 再合并;
		ListNode head2;
		ListNode tempNode2;
		ListNode tempNode;
		
		head2 = head.next;
		tempNode2 = head2;
		tempNode = head;
		
		while (tempNode.next != null && tempNode.next.next != null) {
			tempNode.next = tempNode.next.next;
			tempNode = tempNode.next;
			tempNode2.next = tempNode.next;
			tempNode2 = tempNode2.next;
		}
		
		//两条合并
		tempNode.next = head2;
		
		return head;
	}
}
