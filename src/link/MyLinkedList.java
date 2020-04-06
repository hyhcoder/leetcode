package link;


/**
 * @author hyhcoder
 * @date 2020/3/17 8:11
 *
 * 设计单链表
 *
 */
public class MyLinkedList {
	
	/**
	 * 第一个指针
	 */
	private Node first;
	/**
	 * 最后一个指针
	 */
	private Node last;
	
	/**
	 * 总长度
	 */
	private int size = 0;
	/**
	 * 基本结构
	 */
	class Node {
		Node next;
		Node pre;
		int item;
		Node(Node next, int element, Node pre) {
			this.next = next;
			this.pre = pre;
			item = element;
		}
		
	}
	
	/** Initialize your data structure here. */
	public MyLinkedList() {
	
	}
	
	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
 
		if (!adjustIndex(index)) {
			return -1;
		}

		int temp = 0;
		Node tempNode = first;
		while (temp < index) {
			tempNode = tempNode.next;
			temp++;
		}
		return tempNode.item;
	}
	
	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
	
		Node head = new Node(null, val, null);
		
		if (first == null) {
			first = head;
			last = head;
		} else {
			head.next = first;
			first.pre = head;
			first = head;
		}
		size++;
	}
	
	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		
		Node tail = new Node(null, val, null);
		
		if (last == null) {
			first = tail;
			last = tail;
		} else {
			tail.pre = last;
			last.next = tail;
			last = tail;
		}
		size++;
	}
	
	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		
		if (index <= 0) {
			addAtHead(val);
			return;
		}
		
		if (index == size) {
			addAtTail(val);
			return;
		}
		

		if (!adjustIndex(index)) {
			return;
		}
		
		// 这里就是中间的状态了
		Node node = new Node(null, val, null);
		int tempIndex = 0;
		Node tempNode = first;
		while (tempIndex < index) {
			tempNode = tempNode.next;
			tempIndex++;
		}
		node.pre = tempNode.pre;
		node.next = tempNode;
		tempNode.pre.next= node;
		tempNode.pre = node;
		size++;
		
	}
	
	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		
		if (!adjustIndex(index)) {
			return;
		}
		if (index == 0) {
			removeFirst();
			return;
		}
		
		if (index == size - 1) {
			removeLast();
			return;
		}
		
		// 中间删除
		int tempIndex = 0;
		Node tempNode = first;
		
		while (tempIndex < index) {
			tempNode = tempNode.next;
			tempIndex++;
		}
		
		tempNode = tempNode.pre;
		tempNode.next = tempNode.next.next;
		tempNode.next.pre = tempNode;
		size --;
	}
	
	private void removeFirst() {
		
		if (first == null) {
			return;
		}
		first = first.next;
		if (first != null) {
			first.pre = null;
		}
		size --;
	}
	
	private void removeLast() {
		
		if (last == null) {
			return;
		}
		last = last.pre;
		if (last != null) {
			last.next = null;
		}
		size --;
	}
	
	private boolean adjustIndex(int index) {
		return index >= 0 && index < size;
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
