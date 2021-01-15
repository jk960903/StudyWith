package 파도반수열;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int testcase=0; testcase<t; testcase++) {
			int n=scan.nextInt();
			long[] dp=new long [100];
			dp[0]=1;
			dp[1]=1;
			dp[2]=1;
			dp[3]=2;
			dp[4]=2;
			dp[5]=3;
			for(int i=6; i<n; i++) {
				dp[i]=dp[i-1]+dp[i-4];
			}
			System.out.println(dp[n-1]);
		}
	}
}
