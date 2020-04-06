package link;

/**
 * @author hyhcoder
 * @date 2020/3/21 10:26
 *
 * 两数相加
 */
public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		if (l1 == null) {
			return l2;
		}
		
		if (l2 == null) {
			return l1;
		}
		
		int disgist = 0;
		ListNode res = new ListNode(1);
		ListNode tempNode = res;
		
		while (l1 != null) {
			int val = 0;
			if (l2 != null) {
				val = l1.val + l2.val + disgist;
				l1 = l1.next;
				l2 = l2.next;
			} else {
				val = l1.val + disgist;
				l1 = l1.next;
			}
			
			if (val >= 10) {
				disgist = 1;
			} else {
				disgist = 0;
			}
			val = val % 10;
			tempNode.next = new ListNode(val);
			tempNode = tempNode.next;
		}
		
		while (l2 != null) {
			int val = l2.val + disgist;
			l2 = l2.next;
			if (val >= 10) {
				disgist = 1;
			} else {
				disgist = 0;
			}
			val = val % 10;
			tempNode.next = new ListNode(val);
			tempNode = tempNode.next;
		}
		
		// 最后的进位
		if (disgist == 1) {
			tempNode.next = new ListNode(1);
		}
		
		// 删除初始值
		return res.next;
	}
}
