package ÃÌ¼ö°è»ê;
import java.util.*;
import java.io.*;
public class Main {
	
	private static int result = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int find1 = Integer.parseInt(st.nextToken());
		
		int find2 = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		
		int m = Integer.parseInt(br.readLine());
		
		boolean[] visit = new boolean[n+1];
		
		
		for(int i = 0 ; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			map[first][second] = 1;
			map[second][first] = 1;
		}
		visit[find1] = true;
		DFS(map,visit,find1,find2,find1,0);
		System.out.println(result);
	}
	
	private static void DFS(int[][] map , boolean[] visit, int first, int second,int now, int count) {
		if(visit[first] && visit[second]) {
			result = count;
		}else {
			for(int i = 1; i < map.length; i++) {
				if(map[now][i] == 1 && !visit[i]) {
					visit[i] = true;
					DFS(map,visit,first,second,i,count+1);
					visit[i] = false;
				}
			}
		}
		
	}
}
