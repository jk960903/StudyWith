package 최단경로;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int v=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		ArrayList<Node>[] list=new ArrayList[v];
		int[] array=new int[v];
		for(int i=0; i<v; i++) {
			array[i]=1000000;
			list[i]=new ArrayList<>();
		}
		for(int i=0; i<e; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int startnode=Integer.parseInt(st.nextToken());
			int endnode=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			list[startnode-1].add(new Node(endnode-1,weight));
		}
		Dijkstra(start-1,array,list);
		for(int i=0; i<array.length; i++) {
			if(array[i]==1000000)sb.append("INF\n");
			else sb.append(array[i]+"\n");
		}
		System.out.println(sb.toString());
	}
	private static void Dijkstra(int start,int[] array,ArrayList<Node>[] list) {
		PriorityQueue<Node> queue=new PriorityQueue<>();
		boolean[] check=new boolean[array.length];
		queue.add(new Node(start,0));
		array[start]=0;
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			if(check[node.end]) continue;
			check[node.end]=true;
			for(Node connect : list[node.end]) {
				if(array[connect.end]>array[node.end]+connect.weight) {
					array[connect.end]=array[node.end]+connect.weight;
					queue.add(new Node(connect.end,array[connect.end]));
				}
			}
		}
	}
}
class Node implements Comparable<Node>{
	int end,weight;
	public Node(int end,int weight) {
		this.end=end;
		this.weight=weight;
	}
	@Override
	public int compareTo(Node o) {
		return this.weight-o.weight;
	}
}
