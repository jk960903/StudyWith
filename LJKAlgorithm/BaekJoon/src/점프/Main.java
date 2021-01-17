package มกวม;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) {
		try {
			long result=Solution();
			System.out.println(result);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static long Solution() throws IOException{
		long result=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] array=new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		long[][] dp=new long[n][n];
		if(array[0][0]<n) {
			dp[array[0][0]][0]=1;
			dp[0][array[0][0]]=1;
		}else {
			return 0;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==n-1&&j==n-1) {
					break;
				}
				if(dp[i][j]!=0) {
					if(i+array[i][j]<n) {
						if(dp[i+array[i][j]][j]==0)
							dp[i+array[i][j]][j]=dp[i][j];
						else {
							dp[i+array[i][j]][j]+=dp[i][j];
						}
					}
					if(j+array[i][j]<n) {
						if(dp[i][j+array[i][j]]==0) {
							dp[i][j+array[i][j]]=dp[i][j];
						}
						else {
							dp[i][array[i][j]+j]+=dp[i][j];
						}
					}
				}
			}
		}
		result=dp[n-1][n-1];
		return result;
	}
}
class Now{
	int x;
	int y;
	int jump;
	public Now(int x,int y, int jump) {
		this.x=x;
		this.y=y;
		this.jump=jump;
	}
}
