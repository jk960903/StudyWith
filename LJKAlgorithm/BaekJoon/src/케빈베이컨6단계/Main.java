package 케빈베이컨6단계;

import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>());
		for(int i = 1 ; i <= n ; i ++) {
			lists.add(new ArrayList<>());
		}
		for(int i = 0 ; i < m ; i ++) {
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			List<Integer> startList = lists.get(start);
			startList.add(end);
			
			List<Integer> endList = lists.get(end);
			startList.add(start);
		}
		
		
	}
}
