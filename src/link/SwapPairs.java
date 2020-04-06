package link;


/**
 * @author hyhcoder
 * @date 2020/3/18 13:40
 *
 * 24 两两交换链表中的节点
 */
public class SwapPairs {
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		
		SwapPairs swapPairs = new SwapPairs();
		ListNode listNode = swapPairs.swap(listNode1);
		
		
		System.out.println(listNode);
	}
	
	public ListNode swapPairs(ListNode head) {
	
    	
    	return swap(head);
	}
	
	
	public ListNode swap(ListNode head) {
    	// 递归
		if (head == null) {
			return null;
		}
		
		//如果head.next为空;直接返回
		if (head.next == null) {
			return head;
		}
		
		ListNode tempNode = head.next;
		head.next = head.next.next;
		tempNode.next = head;
		
		if (tempNode.next.next != null) {
			tempNode.next.next = swap(tempNode.next.next);
		}
		return tempNode;
  
	}
}
