package ¼û¹Ù²ÀÁú;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		Queue<subin> queue=new LinkedList<>();
		boolean[] visit=new boolean[1000001];
		subin now=new subin(n,0);
		int answer=0;
		queue.add(now);
		int min=Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			subin temp=queue.poll();
			int tempnow=temp.time;
			if(temp.x==k) {
				if(tempnow<min) {
					min=tempnow;
				}
			}
			if(inbound((temp.x)+1)&&!visit[(temp.x)+1]) {
				visit[temp.x+1]=true;
				queue.add(new subin((temp.x)+1,tempnow+1));
			}
			if(inbound((temp.x)-1)&&!visit[(temp.x)-1]) {
				visit[(temp.x)-1]=true;
				queue.add(new subin((temp.x)-1,tempnow+1));
			}
			if(inbound(2*temp.x)&&!visit[2*temp.x]) {
				visit[2*temp.x]=true;
				queue.add(new subin(temp.x*2,tempnow+1));
			}
		}
		System.out.println(min);
	}
	public static boolean inbound(int x) {
		if(x<0||x>100000)return false;
		return true;
	}
}
class subin{
	int x;
	int time;
	public subin(int x, int time) {
		this.x=x;
		this.time=time;
	}
}
