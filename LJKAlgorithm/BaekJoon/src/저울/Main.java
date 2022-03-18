package Àú¿ï;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		
		boolean[][] dp = new boolean[n+1][n+1];
		boolean[][] reverse = new boolean[n+1][n+1];
		
		for(int i = 0 ; i < m; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			dp[start][end] = true;
			reverse[end][start] = true;
		}
		
		for(int k = 1 ; k <= n; k++) {
			for(int i = 1; i <= n; i++ ) {
				for(int j = 1; j <= n; j++) {
					if(dp[i][k] && dp[k][j]) dp[i][j] = true;
					if(reverse[i][k] && reverse[k][j]) reverse[i][j] = true;
				}
			}
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j <= n; j++) {
				dp[i][j] |= reverse[i][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n ; i ++) {
			int count = 0;
			for(int j = 1; j <=n; j++) {
				if(i==j) continue;
				if(!dp[i][j]) count++;
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
