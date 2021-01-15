package 경사로;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int l=Integer.parseInt(st.nextToken());
		int[][] array=new int[n][n];
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int num=0;
		
		for(int i=0; i<n; i++) {
			num+=makeSlope(i,0,array,0,l);
			num+=makeSlope(0,i,array,1,l);
		}
		System.out.println(num);
	}
	public static int makeSlope(int x,int y,int[][] map,int dir,int length) {
		int[] slope=new int[map.length];
		boolean[] visit=new boolean[map.length];
		for(int i=0; i<map.length; i++) {
			slope[i]=dir==0 ? map[x][y+i] : map[x+i][y];
		}
		for(int i=0; i<map.length-1; i++) {
			if(slope[i]==slope[i+1]) continue;
			if(Math.abs(slope[i]-slope[i+1])>1) return 0;
			if(slope[i]-1==slope[i+1]) {
				for(int j=i+1; j<=i+length; j++) {
					if(!inbound(i,j,map)||visit[j]||slope[j]!=slope[i+1]) {
						return 0;
					}
					visit[j]=true;//경사로 세움
				}
			}else if(slope[i]+1==slope[i+1]) {
				for(int j=i; j>i-length; j--) {
					if(!inbound(i,j,map)||visit[j]||slope[j]!=slope[i])return 0;
					visit[j]=true;
				}
			}
		}
		return 1;
	}
	public static boolean inbound(int x,int y,int[][] map) {
		if(x<0||y<0||x>=map.length||y>=map.length)return false;
		else return true;
	}
}
