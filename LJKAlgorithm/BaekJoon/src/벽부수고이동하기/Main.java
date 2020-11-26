package 벽부수고이동하기;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	private static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	private static int realanswer=0;
	private static int min=9999999;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		LinkedList<dot> list=new LinkedList<dot>();
		int[][] map=new int[N][M];
		scan.nextLine();
		for(int i=0; i<N; i++) {
			String temp=scan.nextLine();
			char[] temp1=temp.toCharArray();
			for(int j=0; j<temp1.length; j++) {
				map[i][j]=temp1[j]-'0';
				if(map[i][j]==1) {
					list.add(new dot(i,j,0));
				}
			}
		}
		int answer=BFS(map,list);
		System.out.println(answer);
		
	}
	private static int BFS(int[][] map,LinkedList<dot> list) {
		int answer=0;
		for(int i=0; i<list.size(); i++) {
			dot d=list.get(i);
			map[d.x][d.y]=0;
			int[][] copymap=new int[map.length][map[0].length];
			boolean[][] visit;
			for(int j=0; j<map.length; j++) {
				for(int k=0; k<map[0].length; k++) {
					copymap[j][k]=map[j][k];
				}
			}
			answer=0;
			Queue<dot> queue=new LinkedList<dot>();
			visit=new boolean[map.length][map[0].length];
			queue.add(new dot(0,0,1));
			visit[0][0]=true;
			while(!queue.isEmpty()) {
				dot dd=queue.poll();
				int day=dd.day;
				for(int j=0; j<dir.length; j++) {
					int tempx=dd.x+dir[j][0];
					int tempy=dd.y+dir[j][1];
					if(inbound(tempx,tempy,map)&&copymap[tempx][tempy]==0&&!visit[tempx][tempy]){
						visit[tempx][tempy]=true;
						queue.add(new dot(tempx,tempy,day+1));
						if(tempx==map.length-1&&tempy==map[0].length-1) {
							if(day+1<min) {
								min=day+1;
							}
						}
					}
				}
				map[d.x][d.y]=1;
			}
			
			
		}
		if(min<10000) {
			return min;
		}else {
			return -1;
		}
	}
	private static boolean inbound(int x,int y,int[][] map) {
		if(x<0||y<0||x>=map.length||y>=map[0].length) {
			return false;
		}else {
			return true;
		}
	}
}
class dot{
	int x;
	int y;
	int day;
	public dot(int x,int y,int day) {
		this.x=x;
		this.y=y;
		this.day=day;
	}
}
