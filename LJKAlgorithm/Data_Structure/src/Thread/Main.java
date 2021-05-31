package Thread;
import java.util.*;
import java.lang.Thread;
import java.sql.Time;
public class Main {
	public static void main(String[] args) {
		ThreadTest thread1 = new ThreadTest();
		ThreadTest thread2 = new ThreadTest();
		try {
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(thread1.num);
	}
}
class ThreadTest extends Thread{
	
	static int num = 0;
	@Override
	public void run() {
		int temp = 0;
		for(int i = 0 ; i< 500; i++) {
			num++;
			System.out.println(this.getName() + " " + num);
		}
		//System.out.println(list.size());
	}
}
