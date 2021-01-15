package FirstGrade;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long[][] dp=new long[n-1][21];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int[] array=new int[n];
		for(int i=0; i<n; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		dp[0][array[0]]=1;
		br.close();
		for(int i=1; i<n-1; i++) {
			for(int j=0; j<21; j++) {
				if(j+array[i]<=20) dp[i][j+array[i]]+=dp[i-1][j];
				if(j-array[i]>=0)dp[i][j-array[i]]+=dp[i-1][j];
			}
		}
		System.out.println(dp[n-2][array[n-1]]);
	}
}
