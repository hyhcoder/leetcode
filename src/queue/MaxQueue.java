package queue;

import java.util.ArrayList;


/**
 * @author hyhcoder
 * @date 2020/3/7 7:13
 *
 * 面试题  队列中的最大值
 */
public class MaxQueue {

	private ArrayList<Integer> integerQueue = new ArrayList<>();
	private Integer max = -1;
	
	private int begin = 0;
	private int end = 0;
	
	
	public MaxQueue() {
	
	}
	
	public int max_value() {
	
		for (int i = begin; i <= end; i++) {
			if (integerQueue.get(i) > max) {
				max = integerQueue.get(i);
			}
		}
	   	return max;
	}
	
	public void push_back(int value) {
		
		integerQueue.add(value);
		end++;
	}
	
	public int pop_front() {
		if (end == 0 || (begin == end)) {
			return -1;
		}
		Integer result = integerQueue.get(begin);
		begin++;
		max = -1;
		return result;
	}
}

/**
 * Your queue.MaxQueue object will be instantiated and called as such:
 * queue.MaxQueue obj = new queue.MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */