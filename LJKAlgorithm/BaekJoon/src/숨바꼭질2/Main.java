package ¼û¹Ù²ÀÁú2;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] result=BFS(n,k);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	private static int[] BFS(int n,int k) {
		int[] result=new int[2];
		int count=0;
		int min=Integer.MAX_VALUE;
		if(n>=k) {
			result[0]=n-k;
			result[1]=1;
			return result;
		}
		Queue<man> queue=new LinkedList<>();
		queue.add(new man(n,0));
		boolean[] visit=new boolean[k+1];
		visit[n]=true;
		while(!queue.isEmpty()) {
			man man=queue.poll();
			int x=man.x;
			int time=man.time;
			if(man.x==k) {
				count++;
				min=man.time;
				break;
			}
			if(man.x+1<=k&&!visit[man.x+1]) {
				visit[man.x+1]=true;
				queue.add(new man(man.x+1,man.time+1));
			}
			if(man.x-1>=0&&!visit[man.x-1]) {
				visit[man.x-1]=true;
				queue.add(new man(man.x-1,man.time+1));
			}
			if(man.x*2<=k&&!visit[man.x*2]) {
				visit[man.x*2]=true;
				queue.add(new man(man.x*2,man.time+1));
			}
		}
		while(!queue.isEmpty()) {
			man man=queue.poll();
			if(man.x==k) {
				count++;
			}
		}
		result[0]=min;
		result[1]=count;
		return result;
	}
}
class man{
	int x;
	int time;
	public man(int x,int time) {
		this.x=x;
		this.time=time;
	}
}
