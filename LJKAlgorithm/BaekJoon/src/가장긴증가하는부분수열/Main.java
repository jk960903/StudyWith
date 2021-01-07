package ����������ϴºκм���;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int[] array=new int[a];
		int[] dp=new int[a];
		for(int i=0; i<a; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=array[0];
		for(int i=1; i<a; i++) {
			dp[i]=array[i];
			for(int j=0; j<i; j++) {
				if(array[i]>array[j]) {
					dp[i]=Math.max(dp[j]+array[i],dp[i]);
				}
			}
		}
		int max=0;
		for(int num : dp) {
			if(max<num) {
				max=num;
			}
		}
		System.out.println(max);
	}
}
