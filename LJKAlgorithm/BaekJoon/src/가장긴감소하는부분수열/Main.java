package 가장긴감소하는부분수열;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] array = new int[n+1];
			int[] dp = new int[n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 1; i<= n; i++) {
				array[i] = Integer.parseInt(st.nextToken());	
			}
			
			dp[1] = 1;
			
			for(int i = 2; i<=n; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(array[i] < array[j] && dp[i] <= dp[j]) {
						dp[i] = dp[j]+1;
					}else if(array[i] == array[j]){
						dp[i] = dp[j];
					}
				}
			}
			int max = 0;
			for(int i = 1 ; i<=n; i++) {
				max = Math.max(dp[i], max);
			}
			
			System.out.println(max);
			
		}catch(Exception e) {
			
		}
	}
}
