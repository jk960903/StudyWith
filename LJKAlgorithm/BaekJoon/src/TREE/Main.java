package TREE;
import java.util.*;
import java.io.*;
public class Main {
	
	private static int result = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer>[] lists = new ArrayList[n];
		
		for(int i = 0 ; i < n ; i++) {
			lists[i] = new ArrayList<>();
		}
		int root = -1;
		for(int i = 0 ; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				root = i;
				continue;
			}
			lists[parent].add(i);
		}
		int delete = Integer.parseInt(br.readLine());
		
		if(delete == root) {
			System.out.println(0);
		}else {
			DFS(lists,delete,root);
			System.out.println(result);
		}
		
	}
	
	
	private static void DFS(List<Integer>[] lists ,int delete,int now) {
		if(lists[now].size() == 0) {
			result ++;
		}else {
			for(int i = 0; i < lists[now].size(); i++) {
				if(lists[now].get(i) != delete) {
					DFS(lists,delete,lists[now].get(i));
				}if(lists[now].get(i) == delete && lists[now].size() == 1) {
					result++;
				}
			}
		}
	}
	
}
