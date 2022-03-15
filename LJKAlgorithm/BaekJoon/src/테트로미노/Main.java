package 테트로미노;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		boolean[][] visit = new boolean[n][m];
		for(int i = 0 ; i < map.length; i++) {
			for(int j = 0 ; j < map[0].length; j++) {
				visit[i][j] = true;
				max = Math.max(max,DFS(map,dir,i,j,map[i][j],1,max,visit));
				max = Math.max(max, BFS(map,i,j,map[i][j],dir,0));
				max = Math.max(max, BFS(map,i,j,map[i][j],dir,1));
				max = Math.max(max, BFS(map,i,j,map[i][j],dir,2));
				max = Math.max(max, BFS(map,i,j,map[i][j],dir,3));
				visit[i][j] = false;
			}
		}
		
		
		System.out.println(max);
	}
	
	private static int DFS(int[][] map , int[][] dir , int x, int y,int score,int depth,int max,boolean[][] visit) {
		if(depth == 4) {
			max = Math.max(score, max);
		}else {
			for(int i = 0 ; i < dir.length; i++) {
				int tempx = x+dir[i][0];
				int tempy = y+dir[i][1];
				if(inbound(map,tempx,tempy) && !visit[tempx][tempy]) {
					visit[tempx][tempy] = true;
					max = Math.max(max,DFS(map,dir,tempx,tempy,score+map[tempx][tempy],depth+1,max,visit));
					visit[tempx][tempy] = false;
				}
			}
		}
		return max;
	}
	
	private static int BFS(int[][] map , int x, int y , int score,int[][] dir,int index) {
		int count = 0 ;
		
		for(int i = index; i < index+3; i++) {
			int tempx = x + dir[i%4][0];
			int tempy = y + dir[i%4][1];
			
			if(inbound(map,tempx,tempy)) {
				count++;
				score+=map[tempx][tempy];
			}
		}
		if(count != 3) {
			return 0;
		}
		return score;
	}
	
	private static boolean inbound(int[][] map, int tempx, int tempy) {
		if(tempx < 0 || tempy < 0 || tempx >= map.length || tempy >= map[0].length) return false;
		return true;
	}
}
