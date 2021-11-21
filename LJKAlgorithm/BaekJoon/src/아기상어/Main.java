package 아기상어;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			fish baby;
			for(int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < n; i++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 9) {
						baby = new fish(i,j,2,0);
					}
				}
			}
		}catch(Exception e) {
			
		}
		
	}
	public static int BFS(fish baby, int[][] map) {
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		int result = 0;
		while(true) {
			boolean[][] visit = new boolean[map.length][map.length];
			Queue<fish> queue = new LinkedList<>();
			queue.add(new fish(baby.x,baby.y,baby.level,0));
			visit[baby.x][baby.y]= true; 
			while(!queue.isEmpty()) {
				fish f = queue.poll();
				
				for(int i = 0 ; i<dir.length; i++) {
					int tempx = dir[i][0] + f.x;
					int tempy = dir[i][1] + f.y;
					
					if(inbound(tempx,tempy,map) && !visit[tempx][tempy] && (map[tempx][tempy] == 0 || map[tempx][tempy] == f.level )) {
						queue.add(new fish(tempx,tempy,f.level,f.time+1));
						visit[tempx][tempy] = true;
					}else if(inbound(tempx,tempy,map) && !visit[tempx][tempy] && map[tempx][tempy] != 0 && map[tempx][tempy] < f.level){
						queue.add(new fish(tempx,tempy,f.level,f.time+1));
						visit[tempx][tempy]=true;
						
					}
				}
			}
		}
		return result;
	}
	
	public static boolean inbound(int tempx, int tempy , int[][] map) {
		if(tempx>=0 && tempy >= 0 && tempx < map.length && tempy < map[0].length) return true;
		return false;
	}
}
class fish{
	int x;
	int y;
	int level;
	int time;
	public fish(int x, int y, int level,int time) {
		this.x=x;
		this.y=y;
		this.level = level;
		this.time = time;
	}
}
class eat implements Comparable<eat>{
	int x;
	int y;
	int distance;
	
	public eat(int x, int y , int distance) {
		this.x =x;
		this.y= y;
		this.distance = distance;
	}

	@Override
	public int compareTo(eat o) {
		if(this.distance == o.distance) {
			return o.y - this.y;
		}
		return o.distance - this.distance;
		
	}
	
}