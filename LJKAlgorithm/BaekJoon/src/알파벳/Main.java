package ¾ËÆÄºª;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	public static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	public static int max=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		char[][] map=new char[r][c];
		for(int i=0; i<r; i++) {
			String temp=br.readLine();
			map[i]=temp.toCharArray();
		}
		BFS(map);
		System.out.println(max);
		
	}
	
	private static int BFS(char[][] map) {
		Queue<Build> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append(map[0][0]);
		queue.add(new Build(sb.toString(),1,0,0));
		
		while(!queue.isEmpty()) {
			Build b = queue.poll();
			
			for(int i = 0; i<dir.length; i++) {
				int tempx = b.x + dir[i][0];
				int tempy= b.y + dir[i][1];
				
				if(inbound(tempx,tempy,map)){
					StringBuilder temps = new StringBuilder();
					temps.append(map[tempx][tempy]);
					if(!b.s.contains(temps)) {
						queue.add(new Build(b.s+temps.toString(),b.day+1,tempx,tempy));
						max=Math.max(max, b.day+1);
					}
					
				}
					
			}
		}
		return max;
	}
	
	private static boolean inbound(int tempx, int tempy, char[][] map) {
		if(tempx>=0 && tempx<map.length && tempy>=0 && tempy < map[0].length) return true;
		return false;
	}
	
}
class Build{
	String s;
	int day;
	int x;
	int y;
	
	public Build(String s, int day,int x, int y) {
		this.s=s;
		this.day=day;
		this.x=x;
		this.y=y;
	}
}
