package ²Ü¹ú½Â¿¬ÀÌ;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		try {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			long[][] dp = new long[n+1][m+1];
			int k = Integer.parseInt(br.readLine());
			
			for(int i = 0; i< k; i++) {
				st = new StringTokenizer(br.readLine());
				int hx = Integer.parseInt(st.nextToken());
				int hy = Integer.parseInt(st.nextToken());
				
				dp[hx][hy]=-1;
			}
			dp[1][1] =1;
			int prime = 1000000007;
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=m; j++) {
					if(i==1&&j==1) continue;
					if(i==n && j%2==0) {
						if(dp[i][j]==-1) continue;
						else {
							long temp2 = dp[i-1][j];
							long temp3 = dp[i][j-1];
							if(temp2==-1) {
								temp2=0;
							}
							if(temp3 ==-1) {
								temp3=0;
							}
							dp[i][j]=(temp2+temp3)%prime;
						}
					}
					if(dp[i][j]==-1) continue;
					else {
						long temp1 = dp[i-1][j-1];
						long temp2 = dp[i-1][j];
						long temp3 = dp[i][j-1];
						if(temp1 == -1) {
							temp1=0;
						}
						if(temp2==-1) {
							temp2=0;
						}
						if(temp3 ==-1) {
							temp3=0;
						}
						dp[i][j]=(temp1+temp2+temp3)%prime;
					}
				}
			}
			result = (int)dp[n][m];
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	private static boolean intbound(int x, int y , int n , int m) {
		if(x>=1 && x<=n && y>=1 && y<=m) return true;
		return false;
	}
}
