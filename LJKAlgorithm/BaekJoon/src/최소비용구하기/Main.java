package 최소비용구하기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		ArrayList<Node>[] Node=new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			Node[i]=new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			
			Node[from].add(new Node(to,weight));
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		Solution solution=new Solution();
		System.out.println(solution.dijkstra(start, end, Node, n));
		
		
	}
}
class Solution{
	public int dijkstra(int start,int end,ArrayList<Node>[] node,int n){
		int result=0;
		int[] dist=new int[n+1];
		boolean[] visit=new boolean[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		PriorityQueue<Node> queue=new PriorityQueue<>();
		queue.add(new Node(start,0));
		dist[start]=0;
		while(!queue.isEmpty()) {
			Node bus=queue.poll();
			
			if(dist[bus.num]<bus.cost) {
				continue;
			}
			for(int i=0; i<node[bus.num].size(); i++) {
				Node temp=node[bus.num].get(i);
				if(dist[temp.num]>dist[bus.num]+temp.cost) {
					dist[temp.num]=dist[bus.num]+temp.cost;
					queue.add(new Node(temp.num,temp.cost));
				}
			}
		}
		return dist[end];
	}
}
class Node implements Comparable<Node>{
	int num;
	int cost;
	public Node(int num,int cost) {
		this.num=num;
		this.cost=cost;
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost,o.cost);
	}
}
