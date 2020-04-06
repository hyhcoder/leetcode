package link;

/**
 * @author hyhcoder
 * @date 2020/3/19 22:34
 *
 * 回文链表
 */
public class IsPalindrome {
	
	// 用数组存储, 变成判断数组回文;
	//有无O(1)方法
	//O(1)的方法就重点在于用双指针找到中间节点;
	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null) {
			return true;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		// 判断奇偶
		boolean flag = false;
		if (fast.next == null) {
			// 奇数
			flag = true;
		}
		
		ListNode head2 = slow.next;
		
		//翻转链表
		/*
		1.保存下个指针;
		2.指向pre;
		3.pre回到原点;
		4.返回之前的下个指针;
		*/
		ListNode pre = null;
		ListNode now = head;
		ListNode next = head;
		while (next != head2) {
			
			next = now.next;
			now.next = pre;
			pre = now;
			now = next;
		}
		
		if (flag) {
			//奇数的话, 要跳过中间的节点不比较;
			pre = pre.next;
		}
		
		while (head2 != null) {
			
			if (head2.val != pre.val) {
				return false;
			}
			head2 = head2.next;
			pre = pre.next;
		}
		return true;
	}
}
