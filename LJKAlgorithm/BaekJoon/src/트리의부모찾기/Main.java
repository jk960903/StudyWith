package 트리의부모찾기;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int c=' ';
		int n=Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		list.add(new ArrayList<>());
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
		int[] parents=new int[n+1];
		for(int i=1; i<n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		bfs(1,list,parents,n);
		String temp="s";
		int index=temp.charAt(0);
		
	}
	private static void bfs(int start,ArrayList<ArrayList<Integer>> list,int[] parents,int n) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(start);
		parents[start]=1;
		while(!queue.isEmpty()) {
			int parent=queue.poll();
			for(int item : list.get(parent)) {
				if(parents[item]==0) {
					parents[item]=parent;
					queue.add(item);
				}
			}
		}
		for(int i=2; i<parents.length; i++) {
			System.out.println(parents[i]);
		}
	}
}
