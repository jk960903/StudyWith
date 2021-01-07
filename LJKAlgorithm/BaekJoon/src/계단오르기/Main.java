package 계단오르기;
//https://www.acmicpc.net/problem/2579
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] array=new int[n];
		for(int i=0; i<n; i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		int[] dp=new int[n];
		dp[0]=array[0];
		try {
			dp[1]=array[0]+array[1];
			dp[2]=Math.max(array[0]+array[2],array[1]+array[2]);
			for(int i=3; i<n; i++) {
				dp[i]=Math.max(dp[i-3]+array[i-1]+array[i],array[i]+dp[i-2]);
			}
			
		}catch(Exception e) {
		}
		finally {
			System.out.println(dp[n-1]);
		}
	}
}
