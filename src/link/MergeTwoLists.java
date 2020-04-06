package link;

/**
 * @author hyhcoder
 * @date 2020/3/19 22:35
 *
 * 合并两个有序链表
 */
public class MergeTwoLists {
	
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if (l1 == null && l2 == null) {
			return null;
		}
		
		
		if (l1 == null) {
			return l2;
		}
		
		if (l2 == null) {
			return l1;
		}
		
		ListNode head;
		if (l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode tempNode = head;
		while (true) {
			
			if (l1 == null) {
				tempNode.next = l2;
				break;
			} else if (l2 == null) {
				tempNode.next = l1;
				break;
			} else {
				if (l1.val <= l2.val) {
					tempNode.next = l1;
					l1 = l1.next;
					tempNode = tempNode.next;
				} else {
					tempNode.next = l2;
					l2 = l2.next;
					tempNode = tempNode.next;
				}
			}
		}
		
		return head;
	}
	
}
