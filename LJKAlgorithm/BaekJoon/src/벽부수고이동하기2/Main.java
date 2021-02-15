package 벽부수고이동하기2;
import java.io.*;
import java.util.*;
public class Main {
	public static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[][] array=new int[n][m];
		for(int i=0; i<n; i++) {
			String s=br.readLine();
			for(int j=0; j<s.length(); j++) {
				array[i][j]=s.charAt(j)-'0';
			}
		}
		int answer=BFS(array,k);
		System.out.println(answer);
	}
	public static int BFS(int[][] map,int k) {
		if(map.length==1&&map[0].length==1)return 0;
		int answer=-1;
		int min=Integer.MAX_VALUE;
		boolean[][] visit=new boolean[map.length][map[0].length];
		Queue<dot> queue=new LinkedList<>();
		queue.add(new dot(0,0,0,1));
		visit[0][0]=true;
		while(!queue.isEmpty()) {
			dot d=queue.poll();
			if(d.x==map.length-1&&d.y==map[0].length-1) {
				min=Math.min(d.time,min);
			}
			for(int i=0; i<dir.length; i++) {
				int tempx=d.x+dir[i][0];
				int tempy=d.y+dir[i][1];
				if(inbound(tempx,tempy,map)&&map[tempx][tempy]==0&&!visit[tempx][tempy]) {
					queue.add(new dot(tempx,tempy,d.drill,d.time+1));
					visit[tempx][tempy]=true;
				}
				if(inbound(tempx,tempy,map)&&map[tempx][tempy]==1&&!visit[tempx][tempy]&&d.drill<k) {
					queue.add(new dot(tempx,tempy,d.drill+1,d.time+1));
					visit[tempx][tempy]=true;
				}
			}
		}
		if(min==Integer.MAX_VALUE) return -1;
		return min;
	}
	public static boolean inbound(int x,int y,int[][] map) {
		if(x<0||y<0||x>=map.length||y>=map[0].length)return false;
		else return true;
	}
}
class dot{
	int x;
	int y;
	int drill;
	int time;
	dot(int x,int y, int drill,int time){
		this.x=x;
		this.y=y;
		this.drill=drill;
		this.time=time;
	}
}
