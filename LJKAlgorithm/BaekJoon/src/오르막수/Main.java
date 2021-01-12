package 오르막수;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[][] dp=new int[n+1][10];
		for(int i=0; i<10; i++) {
			dp[0][i]=1;
			
		}
		for(int i=0; i<=n; i++) {
			dp[i][0]=1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<10; j++) {
				dp[i][j]=(dp[i][j-1]+dp[i-1][j])%10007;
			}
		}
		int a=0;
		System.out.println(dp[n][9]);
		
		
	}
}
