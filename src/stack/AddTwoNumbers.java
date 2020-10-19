package stack;

import link.ListNode;

import java.util.Stack;

/**
 * @author hyhcoder
 * @date 2020/4/14 21:40
 */
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(7);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		ListNode listNode7 = new ListNode(4);
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		addTwoNumbers.addTwoNumbers(listNode1, listNode5);
		
		
	}
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		//得到第一个stack
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		
		//得到第二个stack
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		
		// 进位
		int addNum = 0;
		
		ListNode resultNode = null;
		
		while (!stack1.empty() && !stack2.empty()) {
			
			int a = stack1.pop();
			int b = stack2.pop();
			
			int c = a + b + addNum;
			
			if (c >= 10) {
				c = c % 10;
				addNum = 1;
			} else {
				addNum = 0;
			}
			
			ListNode listNode = new ListNode(c);
			listNode.next = resultNode;
		    resultNode = listNode;
		}
		
		while (!stack1.empty()) {
			int a = stack1.pop() + addNum;
			
			if (a >= 10) {
				a = a % 10;
				addNum = 1;
			} else {
				addNum = 0;
			}
			
			ListNode listNode = new ListNode(a);
			listNode.next = resultNode;
			resultNode = listNode;
		}
		
		while (!stack2.empty()) {
			int a = stack2.pop() + addNum;
			
			if (a >= 10) {
				a = a % 10;
				addNum = 1;
			} else {
				addNum = 0;
			}
			
			ListNode listNode = new ListNode(a);
			listNode.next = resultNode;
			resultNode = listNode;
		}
		
		if (addNum == 1) {
			ListNode listNode = new ListNode(1);
			listNode.next = resultNode;
			resultNode = listNode;
		}
		
		
		return resultNode;
	}
}
