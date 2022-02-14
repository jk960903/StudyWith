package ³ì»ö¿ÊÁ©´Ù;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	private static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				break;
			}
			int[][] array = new int[n][n];
			
			for(int i = 0 ; i < array.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < array[i].length; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = BFS(array);
			
			System.out.println("Problem 1: "+result);
		}
		
		br.close();
		
	}
	
	private static int BFS(int[][] array) {
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[array.length][array[0].length];
		Queue<dot> queue = new LinkedList<>();
		for(int i = 0 ; i< dp.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		queue.add(new dot(0, 0 , array[0][0]));
		
		while(!queue.isEmpty()) {
			dot d = queue.poll();
			if(d.x == array.length-1 && d.y == array[0].length-1) min = Math.min(min, d.count);
			for(int i = 0 ; i < 4; i++) {
				int tempx = d.x + dir[i][0];
				int tempy = d.y + dir[i][1];
				
				if(inbound(tempx,tempy,array) && d.count < dp[tempx][tempy]) {
					queue.add(new dot(tempx,tempy,d.count+array[tempx][tempy]));
					dp[tempx][tempy] = d.count + array[tempx][tempy];
					
				}
				
				
			}
			
			
		}
		return min;
	}
	
	private static boolean inbound(int tempx,int tempy, int[][] array) {
		if(tempx >= 0 && tempx < array.length && tempy>= 0 && tempy < array[0].length) return true;
		return false;
	}
}
class dot{
	public int x;
	public int y;
	public int count;
	
	public dot(int x, int y,int count) {
		this.x=x;
		this.y=y;
		this.count = count;
	}
}
