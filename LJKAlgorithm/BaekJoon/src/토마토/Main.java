package ≈‰∏∂≈‰;
//https://www.acmicpc.net/problem/7569
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static int[][][] dir= {{{0,0,1},{0,-1,0},{0,0,-1},{0,1,0},{1,0,0},{-1,0,0}}};
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int h=scan.nextInt();
		int[][][] map=new int[h][m][n];
		for(int i=0; i<h; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<n; k++) {
					map[i][j][k]=scan.nextInt();
				}
			}
		}
		int answer=BFS(map);
		LinkedList<Integer> list=new LinkedList<>();
		System.out.println(answer);
		
	}
	public static int BFS(int[][][] map) {
		Queue<dot> queue=new LinkedList<>();
		boolean[][][] visit=new boolean[map.length][map[0].length][map[0][0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				for(int k=0; k<map[0][0].length; k++) {
					if(map[i][j][k]==1) {
						queue.add(new dot(k,j,i,1));
						visit[i][j][k]=true;
					}
				}
			}
		}
		while(!queue.isEmpty()) {
			dot d=queue.poll();
			map[d.z][d.y][d.x]=d.day;
			for(int i=0; i<6; i++) {
				int tempx=d.x+dir[0][i][2];
				int tempy=d.y+dir[0][i][1];
				int tempz=d.z+dir[0][i][0];
				if(inbound(tempx,tempy,tempz,map)&&!visit[tempz][tempy][tempx]&&map[tempz][tempy][tempx]==0) {
					queue.add(new dot(tempx,tempy,tempz,d.day+1));
					visit[tempz][tempy][tempx]=true;
				}
			}
		}
		int max=0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				for(int k=0; k<map[0][0].length; k++) {
					if(map[i][j][k]==0) {
						return -1;
					}
					else if(max<map[i][j][k]) {
						max=map[i][j][k];
					}
				}
			}
		}
		return max-1;
	}
	private static boolean inbound(int x,int y,int z,int[][][] map) {
		if(z>=map.length||z<0||x<0||y<0||x>=map[0][0].length||y>=map[0].length) {
			return false;
		}else {
			return true;
		}
	}

}
class dot{
	int x;
	int y;
	int z;
	int day;
	dot(int x,int y,int z,int day){
		this.x=x;
		this.y=y;
		this.z=z;
		this.day=day;
	}
}
