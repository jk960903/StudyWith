package 가장가까운공통조상;
import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Deque;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> deque=new LinkedList<>();
		
		int testcase=Integer.parseInt(br.readLine());
		for(int i=0; i<testcase; i++) {
			int n=Integer.parseInt(br.readLine());
			int[] node=new int[n];
			for(int j=0; j<n-1; j++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				int parent=Integer.parseInt(st.nextToken());
				node[Integer.parseInt(st.nextToken())-1]=parent;
			}
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			ArrayList<Integer> one=new ArrayList<>();
			int now=first;
			HashMap<Integer,Integer> map=new HashMap<>();
			map.put(now,1);
			while(node[now-1]!=0) {
				int parent=node[now-1];
				now=parent;
				map.put(parent,1);
				
			}
			now=second;
			int result=second;
			while(node[now-1]!=0) {
				int parent=node[now-1];
				now=parent;
				if(map.containsKey(parent)){
					result=parent;
					break;
				}
			}
			System.out.println(result);
		}
	}
}
