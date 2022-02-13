package ³ì»ö¿ÊÁ©´Ù;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			
		}
		
		
		
	}
	
	private static int BFS(int[][] array) {
		int min = Integer.MAX_VALUE;
		boolean[][] visit = new boolean[array.length][array[0].length];
		Queue<dot> queue = new LinkedList<>();
		
		queue.add(new dot(0, 0 , array[0][0]));
		
		while(!queue.isEmpty()) {
			dot d = queue.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int tempx = dir[i][0];
				int tempy = dir[i][1];
			}
		}
		return 0;
	}
	
	
}
public class dot{
	private int x;
	private int y;
	private int count;
	
	public dot(int x, int y,int count) {
		this.x=x;
		this.y=y;
		this.count = count;
	}
}
