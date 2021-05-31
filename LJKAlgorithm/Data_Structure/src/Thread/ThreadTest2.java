package Thread;

import java.util.ArrayList;
import java.lang.Thread;
public class ThreadTest2 {
	public static void main(String[] args) {
		ThreadTest3 thread = new ThreadTest3();
		ThreadTest3 thread2 = new ThreadTest3();
		
		thread.start();
		thread2.start();
	}
}
class ThreadTest3 extends Thread{
	
	static ArrayList<Integer> list = new ArrayList<>();
	static Integer num = 0;
	public synchronized void run() {
		
			for(int i = 0; i<10000; i++) {
				num+=1;
				
				
				System.out.println(this.getName() + " " +num);
			}
		
		
		int temp = 0;
	}
}
