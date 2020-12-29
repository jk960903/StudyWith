package 네트워크연결크루스칼;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		PriorityQueue<Node> queue=new PriorityQueue<>();
		for(int i=0; i<m; i++) {
			int s=scan.nextInt();
			int e=scan.nextInt();
			int size=scan.nextInt();
			queue.add(new Node(s,e,size));
		}
		int[] parent=new int[n+1];
		for(int i=0; i<n+1; i++) {
			parent[i]=i;
		}
		int result=0;
		for(int i=0; i<m; i++) {
			Node node=queue.poll();
			int a=Find(node.s,parent);
			int b=Find(node.e,parent);
			if(a==b)continue;
			else {
				Union(a,b,parent);
				result+=node.size;
			}
		}
		System.out.println(result);
	}
	private static int Find(int a , int[] parent) {
			if(a==parent[a]) return a;
			parent[a]=Find(parent[a],parent);
			return parent[a];
	}
	private static void Union(int a, int b ,int[] parent) {
		int aRoot=Find(a,parent);
		int bRoot=Find(b,parent);
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else {
			return;
		}
	}
	
}
class Node implements Comparable<Node>{
	int s;
	int e;
	int size;
	public Node(int s,int e,int size) {
		this.s=s;
		this.e=e;
		this.size=size;
	}
	@Override
	public int compareTo(Node node) {
		return node.size>=this.size ? -1 : 1;
	}
}
