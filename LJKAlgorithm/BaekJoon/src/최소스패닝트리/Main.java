package 최소스패닝트리;
//Solve PrimAlgorithm
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int v=scan.nextInt();
		int e=scan.nextInt();
		ArrayList<ArrayList<node>> graph=new ArrayList<>();
		PriorityQueue<node> queue=new PriorityQueue<>();
		for(int i=0; i<v; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<e; i++) {
			
			int a=scan.nextInt()-1;
			int b=scan.nextInt()-1;
			int dis=scan.nextInt();
			
			graph.get(a).add(new node(b,dis));
			graph.get(b).add(new node(a,dis));
			
			
		}
		queue.add(new node(0,0));
		int answer=0;
		int cnt=0;
		boolean[] visit=new boolean[v];
		while(!queue.isEmpty()) {
			node node=queue.poll();
			if(visit[node.node])continue;
			visit[node.node]=true;
			answer+=node.dis;
			
			for(node next:graph.get(node.node)) {
				if(!visit[next.node]) {
					queue.add(next);
				}
			}
			if(++cnt==v)break;
		}
		System.out.println(answer);
	}
}
class node implements Comparable<node>{
	int node;
	long dis;
	public node(int node,long dis) {
		this.node=node;
		this.dis=dis;
	}
	@Override
	public int compareTo(node o) {
		return Long.compare(this.dis, o.dis);
	}
}
