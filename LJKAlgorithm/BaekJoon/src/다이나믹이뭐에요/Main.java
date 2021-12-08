package ¥Ÿ¿Ã≥™πÕ¿Ãππø°ø‰;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine()," " );
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][m];
			for(int i = 0 ; i< n ; i++) {
				map[i][0] = 1;
			}
			for(int i = 0 ; i< m; i++) {
				map[0][i] = 1;
			}
			for(int i = 1 ; i < n; i++) {
				for(int j = 1 ; j< m ; j++) {
					map[i][j] = (((map[i-1][j] + map[i-1][j-1]) % 1000000007) + map[i][j-1]) % 1000000007;
				}
			}
			
			System.out.println(map[n-1][m-1]);
		}catch(Exception e) {
			
		}
	}
	
	
}
