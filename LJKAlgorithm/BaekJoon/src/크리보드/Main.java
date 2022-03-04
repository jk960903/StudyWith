package 크리보드;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		long[] dp = new long[101];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 4;
		dp[5] = 5;
		
		for(int i = 6; i<= 100; i++) {
			for(int j = 2; j <= 5; j++) {
				dp[i] = Math.max(dp[i-(j+1)] * j , dp[i]);
			}
		}
		
		System.out.println(dp[n]);
		
	}
}
