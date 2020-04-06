package link;

/**
 * @author hyhcoder
 * @date 2020/3/19 22:28
 *
 * 移除链表元素
 */
public class RemoveElements {
	
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(6);
		ListNode listNode4 = new ListNode(3);
		ListNode listNode5 = new ListNode(4);
		ListNode listNode6 = new ListNode(5);
		ListNode listNode7 = new ListNode(6);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		
		RemoveElements removeElements = new RemoveElements();
		ListNode listNode = removeElements.removeElements(listNode1, 6);
		System.out.println(listNode);
	}
	
	
	
	public ListNode removeElements(ListNode head, int val) {
		
		//哨兵, 看是不是要删头;
		while (head != null && head.val == val) {
			head = head.next;
		}
		
		if (head == null) {
			return null;
		}
		// 使用双指针; 一个记录前指针;
		ListNode prelistNode = head;
		ListNode listNode = head.next;
		
		while (listNode != null) {
			if (listNode.val == val) {
				listNode = listNode.next;
				prelistNode.next = prelistNode.next.next;
			} else {
				listNode = listNode.next;
				prelistNode = prelistNode.next;
			}
		}
		
		return head;
	}
}
