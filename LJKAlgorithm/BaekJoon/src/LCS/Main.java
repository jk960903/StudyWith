package LCS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] s1=br.readLine().toCharArray();
		char[] s2=br.readLine().toCharArray();
		int[][] dp=new int[s1.length+1][s2.length+1];
		for(int i=1; i<=s2.length; i++) {
			for(int j=1; j<=s1.length; j++) {
				if(s1[j-1]==s2[i-1]) {
					dp[j][i]=dp[j-1][i-1]+1;
				}else {
					dp[j][i]=Math.max(dp[j-1][i],dp[j][i-1]);
				}
			}
		}
		int max=0;
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[1].length; j++) {
				max=Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
		
	}
}
