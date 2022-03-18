package Å°¼ø¼­;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		final int INF = 1000000;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n][n];
		
		for(int i = 0 ; i < n; i++) {
			Arrays.fill(dp[i],INF);
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			
			dp[first][second] = 1;
		}
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0 ; k < n; k++) {
					if( j == i || j == k || i == k) continue;
					dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
				}
			}
		}
		int answer = 0;
		for(int i = 0 ; i < n; i ++) {
			boolean flag = true;
			
			for(int j = 0 ; j < n ; j++) {
				if(i == j || dp[i][j] != INF || dp[j][i] != INF) {
					continue;
				}
				flag = false;
				break;
			}
			if(flag) answer++;
		}
		
		System.out.println(answer);
	}
}
