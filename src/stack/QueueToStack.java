package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hyhcoder
 * @date 2020/3/6 22:27
 *
 * 225 用队列实现栈
 */
public class QueueToStack {
	
	
	/**
	 * 输入队列
	 */
	private Queue<Integer> queueA = new LinkedList<>();
	
	/**
	 * 输出队列
	 */
	private Queue<Integer> queueB = new LinkedList<>();
	
	private Integer top;
	/** Initialize your data structure here. */
	public QueueToStack() {
	
	}
	
	/** Push element x onto stack. */
	public void push(int x) {
	
		queueA.offer(x);
		// 将b队列中元素全部转给a队列
		while(!queueB.isEmpty())
			queueA.offer(queueB.poll());
		// 交换a和b,使得a队列没有在push()的时候始终为空队列
		Queue<Integer> temp = queueA;
		queueA = queueB;
		queueB = temp;
		
	}
	
	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
	
	   return queueB.poll();
	
	}
	
	/** Get the top element. */
	public int top() {
	
		return queueB.peek();
	}
	
	/** Returns whether the stack is empty. */
	public boolean empty() {
	
	return 	queueB.isEmpty();
	}
	
}
