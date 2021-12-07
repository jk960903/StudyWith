package µ¿Àü;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int t = Integer.parseInt(br.readLine());
			for(int testcase = 0 ; testcase < t; testcase++) {
				int n = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int[] array= new int[n];
				for(int i = 0 ; i < n; i++) {
					array[i] = Integer.parseInt(st.nextToken());	
				}
				int find = Integer.parseInt(br.readLine());
				int[] dp = new int[find+1];
				dp[0] = 1;
				
				for(int i = 0 ; i < array.length; i++) {
					for(int j = array[i]; j <= find; j++) {
						dp[j] += dp[j-array[i]];
					}
				}
				System.out.println(dp[find]);
			}
		}catch(Exception e) {
			
		}
	}
}
