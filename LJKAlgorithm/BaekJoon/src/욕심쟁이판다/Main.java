package øÂΩ…¿Ô¿Ã∆«¥Ÿ;
import java.io.*;
import java.util.*;
public class Main {
	public static int[][] dp;
	public static int[][] map;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp = new int[n][n];
			int answer = 0;
			for(int i = 0 ; i < n; i++) {
				for(int j = 0 ; j< n; j++) {
					int dfss = dfs(i,j);
					answer = Math.max(answer, dfss);
				}
			}
			System.out.println(answer);
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int dfs(int x , int y) {
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		if(dp[x][y]!=0) return dp[x][y];
		dp[x][y] = 1;
		for(int i = 0 ; i<4; i++) {
			int tempx = x+ dir[i][0];
			int tempy = y + dir[i][1];
			
			if(inbound(tempx,tempy) && map[tempx][tempy] > map[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(tempx,tempy)+1);
			}
		}
		return dp[x][y];
	}
	
	private static boolean inbound(int tempx,int tempy) {
		if (tempx >=0 && tempy >= 0 && tempx < dp.length && tempy < dp[0].length) {
			return true;
		}else return false;
	}
}
