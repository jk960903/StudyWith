package BABBA;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			BA[] dp = new BA[46];
			dp[1] = new BA(0,1);
			dp[2] = new BA(1,1);
			dp[3] = new BA(1,2);
			for(int i = 4; i < dp.length; i++) {
				dp[i] = new BA(dp[i-2].numA + dp[i-1].numA , dp[i-2].numB + dp[i-1].numB);
			}
			System.out.println(dp[n].numA+" "+dp[n].numB);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class BA{
	long numA;
	long numB;
	
	public BA(long numA,long numB) {
		this.numA = numA;
		this.numB = numB;
	}
}
