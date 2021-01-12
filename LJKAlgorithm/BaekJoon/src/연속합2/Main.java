package ¿¬¼ÓÇÕ2;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		int[] array=new int[n];
		for(int i=0; i<n; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		int[] dp=new int[n];
		dp[0]=array[0];
		int max=dp[0];
		for(int i=1; i<n; i++) {
			dp[i]=Math.max(dp[i-1]+array[i],array[i]);
			max=Math.max(dp[i],max);
		}
		int[] dp2=new int[n];
		dp2[n-1]=array[n-1];
		for(int i=n-2; i>=0; i--) {
			dp2[i]=Math.max(dp2[i+1]+array[i],array[i]);
			
		}
		for(int i=1; i<n-1; i++) {
			int temp=dp[i-1]+dp2[i+1];
			max=Math.max(temp,max);
		}
		System.out.println(max);
	}
	
	
}

