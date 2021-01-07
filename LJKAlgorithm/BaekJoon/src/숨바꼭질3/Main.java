package ¼û¹Ù²ÀÁú3;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		boolean[] visit=new boolean[100001];
		Queue<Subin> queue=new LinkedList<>();
		queue.add(new Subin(n,0));
		int min=Integer.MAX_VALUE;
		visit[n]=true;
		while(!queue.isEmpty()) {
			Subin temp=queue.poll();
			int tempx=temp.x;
			int time=temp.time;
			if(temp.x==k) {
				min=Math.min(time, min);
			}
			if(inbound(temp.x*2)&&!visit[tempx*2]) {
				visit[temp.x*2]=true;
				queue.add(new Subin(temp.x*2,time));
			}
			if(inbound(temp.x+1)&&!visit[tempx+1]) {
				visit[temp.x+1]=true;
				queue.add(new Subin(temp.x+1,time+1));
			}
			if(inbound(temp.x-1)&&!visit[tempx-1]) {
				visit[temp.x-1]=true;
				queue.add(new Subin(temp.x-1,time+1));
			}
			
		}
		System.out.println(min);
	}
	public static boolean inbound(int x) {
		if(x<0||x>100000)return false;
		return true;
	}
}
class Subin{
	int x;
	int time;
	public Subin(int x,int time) {
		this.x=x;
		this.time=time;
	}
	
}
