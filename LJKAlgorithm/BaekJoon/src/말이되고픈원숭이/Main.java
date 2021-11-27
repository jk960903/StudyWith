package ¸»ÀÌµÇ°íÇÂ¿ø¼þÀÌ;
import java.util.*;
import java.io.*;
public class Main {
	static boolean[][][] visit;
	static int[][] map;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			for(int i = 0 ; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = BFS(k);
			System.out.println(answer);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int BFS(int k) {
		Queue<Monkey> queue = new LinkedList<>();
		visit = new boolean[k+1][map.length][map[0].length];
		int answer = 0;
		int[][] horseDir = {{-2,1},{1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		queue.add(new Monkey(0,0,0,0));
		visit[0][0][0] = true;
		while(!queue.isEmpty()) {
			Monkey m = queue.poll();
			
			if(m.x == map.length-1 && m.y == map[0].length-1) {
				return m.time;
			}
			if(m.horse < k) {
				for(int i = 0 ; i < horseDir.length; i++) {
					int tempx = horseDir[i][0] + m.x;
					int tempy = horseDir[i][1] + m.y;
					
					if(inbound(tempx,tempy,map.length,map[0].length) && ! visit[m.horse][tempx][tempy] && 
							map[tempx][tempy] != 1) {
						queue.add(new Monkey(tempx,tempy,m.time+1,m.horse+1));
						visit[m.horse+1][tempx][tempy] = true;
					}
				}
			}
			
			for(int i = 0 ; i < dir.length; i++) {
				int tempx = dir[i][0] + m.x;
				int tempy = dir[i][1] + m.y;
				
				if(inbound(tempx,tempy,map.length,map[0].length) && !visit[m.horse][tempx][tempy] && map[tempx][tempy]!=1) {
					queue.add(new Monkey(tempx,tempy,m.time+1,m.horse));
					visit[m.horse][tempx][tempy] = true;
				}
			}
		}
		if(answer == 0 ) {
			return -1;
		}else return answer;
	}
	
	private static boolean inbound(int tempx,int tempy, int x, int y) {
		if(tempx >= 0 && tempy >= 0 && tempx < x && tempy < y) return true;
		else return false;
	}
}

class Monkey{
	int x;
	int y;
	int time;
	int horse;
	
	public Monkey(int x, int y, int time , int horse) {
		this.x = x;
		this.y = y;
		this.time = time;
		this.horse = horse;
	}
	
}
