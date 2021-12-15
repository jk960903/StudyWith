package Επ»η2;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		try {
			int n = Integer.parseInt(br.readLine());
			int[][] array = new int [n+2][2];
			int[] dp = new int[n+2];
			
			for(int i = 1; i<=n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				
				array[i][0] = Integer.parseInt(st.nextToken());
				array[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			
			for(int i =1; i <= n+1; i++) {
				if(max < dp[i]) {
					max = dp[i];
				}
				
				int next = i + array[i][0];
				
				if(next < n+2) {
					dp[next] = Math.max(dp[next], max + array[i][1]);
				}
			}
			
			System.out.println(dp[n+1]);
		}catch(Exception e) {
			
		}
	}
}
