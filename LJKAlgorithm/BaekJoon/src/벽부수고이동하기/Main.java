package 벽부수고이동하기;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
public class Main {
	private static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	private static int realanswer=0;
	private static int min=9999999;
	private static int[][] visit;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		LinkedList<dot> list=new LinkedList<dot>();
		int[][] map=new int[N][M];
		visit=new int[N][M];
		scan.nextLine();
		for(int i=0; i<N; i++) {
			String temp=scan.nextLine();
			char[] temp1=temp.toCharArray();
			for(int j=0; j<temp1.length; j++) {
				map[i][j]=temp1[j]-'0';
				visit[i][j]=Integer.MAX_VALUE;
			}
		}
		int answer=BFS(map);
		if(visit[N-1][M-1]==Integer.MAX_VALUE)System.out.println(-1);
		else
			System.out.println(answer);
		
	}
	private static int BFS(int[][] map) {
		int answer=0;
		Queue<dot> queue=new LinkedList<dot>();
		queue.add(new dot(0,0,1,0));
		visit[0][0]=0;
		while(!queue.isEmpty()) {
			dot dd=queue.poll();
			if(dd.x==map.length-1&&dd.y==map[0].length-1) {
				answer=dd.day;
				break;
			}
			for(int j=0; j<dir.length; j++) {
				int tempx=dd.x+dir[j][0];
				int tempy=dd.y+dir[j][1];
				if(!inbound(tempx,tempy,map)) continue;
				if(visit[tempx][tempy]<=dd.boom) continue;
				if(map[tempx][tempy]==0) {
					visit[tempx][tempy]=dd.boom;
					queue.add(new dot(tempx,tempy,dd.day+1,dd.boom));
				}else {
					if(dd.boom==0) {
						visit[tempx][tempy]=dd.boom+1;
						queue.add(new dot(tempx,tempy,dd.day+1,dd.boom+1));
					}
				}
			}
			
			
		}
		return answer;
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
	int boom;
	public dot(int x,int y,int day,int boom) {
		this.x=x;
		this.y=y;
		this.day=day;
		this.boom=boom;
	}
}
