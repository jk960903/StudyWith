package 네트워크연결프림;
//https://www.acmicpc.net/problem/1922
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		ArrayList<ArrayList<Node>> graph=new ArrayList<>();
		PriorityQueue<Node> queue=new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			int s=scan.nextInt()-1;
			int e=scan.nextInt()-1;
			int size=scan.nextInt();
			
			graph.get(s).add(new Node(e,size));
			graph.get(e).add(new Node(s,size));
		}
		queue.add(new Node(0,0));
		int answer=0;
		int count=0;
		boolean[] visit=new boolean[n];
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			if(visit[node.e]) continue;
			visit[node.e]=true;
			answer+=node.v;
			
			for (Node next:graph.get(node.e)) {
				if(!visit[next.e]) {
					queue.add(next);
				}
			}
			if(++count==n) break;
		}
		System.out.println(answer);
	}
	
}
class Node implements Comparable<Node>{
	int e;
	int v;
	public Node(int e, int v) {
		super();
		this.e=e;
		this.v=v;
	}
	@Override
	public int compareTo(Node arg) {
		return arg.v>=this.v ? -1 : 1;
	}
}
