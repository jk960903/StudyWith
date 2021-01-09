package 트리의지름0;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static int max=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		LinkedList<LinkedList<node>> list=new LinkedList<>();
		LinkedList<LinkedList<node>> start=new LinkedList<>();
		for(int i=0; i<n; i++) {
			list.add(new LinkedList<node>());
			start.add(new LinkedList<>());
		}
		for(int i=0; i<n-1; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int parent=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			LinkedList<node> temp=list.get(parent-1);
			LinkedList<node> chile=list.get(child-1);
			temp.add(new node(child-1,num));
			chile.add(new node(parent-1,num));
		}
		boolean[] visit=new boolean[n];
		node max=BFS(0,list,visit);
		visit=new boolean[n];
		node realmax=BFS(max.temp,list,visit);
		System.out.println(realmax.size);
		
	}
	public static node BFS(int s,LinkedList<LinkedList<node>> list,boolean[] visit) {
		int max=0;
		int n=0;
		Queue<node> queue =new LinkedList<>();
		visit[s]=true;
		queue.add(new node(s,0));
		while(!queue.isEmpty()) {
			node temp=queue.poll();
			int now=temp.temp;
			for(int i=0; i<list.get(now).size(); i++) {
				node node=list.get(now).get(i);
				if(!visit[node.temp]) {
					int nowsize=temp.size+node.size;
					queue.add(new node(node.temp,nowsize));
					if(max<nowsize) {
						max=nowsize;
						n=node.temp;
					}
					visit[node.temp]=true;
				}
			}
		}
		return new node(n,max);
	}
	

}
class node{
	int temp;
	int size;
	public node(int temp,int size) {
		this.temp=temp;
		this.size=size;
	}
}
