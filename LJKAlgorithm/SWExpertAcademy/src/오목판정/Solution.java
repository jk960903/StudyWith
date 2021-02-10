package 오목판정;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		int[][] dir= {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
		for(int i=1; i<=tc; i++) {
			int n=Integer.parseInt(br.readLine());
			boolean check=false;
			char[][] array=new char[n][n];
			for(int j=0; j<n; j++) {
				array[j]=br.readLine().toCharArray();
			}
			for(int j=0; j<n; j++) {
				if(check) break;
				for(int k=0; k<n; k++) {
					if(check) break;
					if(array[j][k]=='o') {
						for(int l=0; l<dir.length; l++) {
							int num=1;
							int tempx=j;
							int tempy=k;
							for(int count=0; count<4; count++) {
								tempx+=dir[l][0];
								tempy+=dir[l][1];
								if(inbound(tempx,tempy,n)&&array[tempx][tempy]=='o') {
									num++;
								}else {
									break;
								}
							}
							if(num>=5) {
								check=true;
								break;
							}
						}
					}
				}
			}
			if(check) System.out.println("#"+i+" YES");
			else System.out.println("#"+i+" NO");
		}
	}
	private static boolean inbound(int x,int y,int n) {
		if(x>=0&&y>=0&&x<n&&y<n) return true;
		return false;
	}
}
