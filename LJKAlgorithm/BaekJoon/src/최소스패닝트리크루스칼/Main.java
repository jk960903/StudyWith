package 최소스패닝트리크루스칼;
import java.util.Scanner;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int v=scan.nextInt();
		int e=scan.nextInt();
		
		int[] parent=new int[v+1];
		for(int i=0; i<v+1; i++) {
			parent[i]=i;
		}
		PriorityQueue<Node> queue=new PriorityQueue<Node>();
		
		for(int i=0; i<e; i++) {
			int s=scan.nextInt();
			int end=scan.nextInt();
			int size=scan.nextInt();
			queue.add(new Node(s,end,size));
		}
		int result=0;
		for(int i=0; i<e; i++) {
			Node node=queue.poll();
			int a=find(node.s,parent);
			int b=find(node.e,parent);
			if(a==b) continue;
			union(a,b,parent);
			result+=node.v;
		}
		System.out.println(result);
		
	}
	public static int find(int a,int[] parent) {
		if(a==parent[a])return a;
		parent[a]=find(parent[a],parent);
		return parent[a];
	}
	public static void union(int a, int b,int[] parent) {
		int aRoot=find(a,parent);
		int bRoot=find(b,parent);
		
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else {
			return;
		}
	}
	static class Node implements Comparable<Node>{
		int s;
		int e;
		int v;
		public Node(int s,int e, int v) {
			this.s=s;
			this.e=e;
			this.v=v;
		}
		@Override
		public int compareTo(Node o) {
			return o.v>=this.v?-1:1;
		}
	}
}
