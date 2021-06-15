package Thread;

import java.util.ArrayList;
import java.lang.Thread;
import java.util.*;
public class ThreadTest2 {
	public static void main(String[] args) {
		ThreadTest3 thread = new ThreadTest3();
		ThreadTest3 thread2 = new ThreadTest3();
		
		thread.start();
		thread2.start();
	}
}
class ThreadTest3 extends Thread{
	
	//static Vector<Integer> list = new Vector<>();
	static ArrayList<Integer> list =new ArrayList<>();
	static int num = 0;
	@Override
	public void run() {
		synchronized(list) {
			for(int i = 0; i<100000; i++) {
				list.add(num++);
				System.out.println(this.getName() + " " +list.get(num-1));
				System.out.println(list.size());
			}
			
		}
		int temp = 0;
	}
}
