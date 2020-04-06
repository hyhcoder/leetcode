package link;

/**
 * @author hyhcoder
 * @date 2020/3/19 22:26
 *
 * 相交链表
 */
public class GetIntersectionNode {
	
	
	public static void main(String[] args) {
	
	}
	
	// 使用双指针
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		// 相交的话, 长度如果一致; 那就一起从头找起;
		// 如果长度不一致; 找出差值; 长度更长的先走差值;
		
		if (headA == null || headB == null) {
			return  null;
		}
		
		
		int lengthA = 0;
		int lengthB = 0;
		ListNode longListNode = headA;
		ListNode lowerListNode = headB;
		ListNode resultNode = null;
		
		while (longListNode != null) {
			longListNode = longListNode.next;
			lengthA ++;
		}
		while (lowerListNode != null) {
			lowerListNode = lowerListNode.next;
			lengthB ++;
		}
		
		//长度差值
		int count = 0;
		if (lengthA >= lengthB) {
			count = lengthA - lengthB;
			longListNode = headA;
			lowerListNode = headB;
		} else {
			count = lengthB - lengthA;
			longListNode = headB;
			lowerListNode = headA;
		}
		
		//先跑
		while (count > 0) {
			longListNode = longListNode.next;
			count --;
		}
		
		if (longListNode == lowerListNode) {
			//这个是一开始就匹配的情况;
			resultNode = longListNode;
		}
		//开始匹配;
		while (longListNode != null) {
			
			if (longListNode != lowerListNode) {
				// 重置
				resultNode = longListNode.next;
			}
			longListNode = longListNode.next;
			lowerListNode = lowerListNode.next;
		}
		
		
		return resultNode;
	}
}
