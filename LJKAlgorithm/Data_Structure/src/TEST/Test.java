package TEST;
import java.util.*;
public class Test {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		queue.add(5);
		queue.add(3);
		queue.add(2);
		queue.add(1);
		queue.add(8);
		queue.add(4);
		queue.remove(3);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
