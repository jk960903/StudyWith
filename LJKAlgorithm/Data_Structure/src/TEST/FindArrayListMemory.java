package TEST;

import java.util.ArrayList;

public class FindArrayListMemory {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i< 100000; i ++) {
			list.add(i);
			System.out.println(System.identityHashCode(list.get(i)));
		}
	}
}
