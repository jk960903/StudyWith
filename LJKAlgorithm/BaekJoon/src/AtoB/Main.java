package AtoB;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		long a=scan.nextInt();
		long b=scan.nextInt();
		Queue<Num> queue=new LinkedList<>();
		queue.add(new Num(a,1));
		int real =0;
		while(!queue.isEmpty()) {
			Num now=queue.poll();
			if(now.x*2<b) {
				queue.add(new Num(now.x*2,now.count+1));
				real++;
			}
			if(now.x*10+1<b) {
				queue.add(new Num(now.x*10+1,now.count+1));
				real++;
			}
			if(now.x*2==b) {
				System.out.println(now.count+1);
				System.out.println(real);
				return;
			}
			if(now.x*10+1==b) {
				System.out.println(now.count+1);
				System.out.println(real);
				return;
			}
		}
		System.out.println(-1);
		System.out.println(real);
		return;
	}
}
class Num{
	long x;
	int count;
	public Num(long x,int count) {
		this.x=x;
		this.count=count;
	}
}
