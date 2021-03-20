package 플로이드;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[][] distance =new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			Arrays.fill(distance[i],1000000);
			distance[i][i]=0;
		}
		for(int i=1; i<=m; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			
			distance[start][end]=Math.min(distance[start][end],cost);
		}
		Solution solution=new Solution();
		solution.floyWarshall(distance);
		
	}
}
class Solution{
	private final int INF=1000000;
	public void floyWarshall(int[][] distance) {
		for(int k=1; k<distance.length; k++) {
			for(int j=1; j<distance.length; j++) {
				for(int i=1; i<distance.length; i++) {
					distance[i][j]=Math.min(distance[i][k]+distance[k][j],distance[i][j]);
				}
			}
		}
		print(distance);
	}
	private void print(int[][] distance) {
		StringBuilder sb=new StringBuilder();
		for(int i=1; i<distance.length; i++) {
			for(int j=1; j<distance.length; j++) {
				if(distance[i][j]==INF)sb.append("0 ");
				else sb.append(distance[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
