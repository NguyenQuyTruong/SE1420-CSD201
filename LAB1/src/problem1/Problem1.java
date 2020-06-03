package problem1;

public class Problem1 {
	public Problem1() {
		PriorityQueue queue = new PriorityQueue();
		
		queue.insert("khang", 5);
		queue.insert("khang2", 3);
		queue.insert("khang3", 6);
		queue.insert("khang5", 2);
		queue.insert("khang6", 10);
		queue.insert("khang6", 2);
		queue.insert("khang6", 0);
		queue.insert("khang4", 4);
		queue.insert("khang4", 7);
		queue.insert("khang4", 1);
		queue.insert("khang4", 9);
		queue.printAll();
	}
}
