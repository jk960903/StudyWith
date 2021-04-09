package ÀüÀï³­Àü;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		Solution solution=new Solution();
		int[] result=new int[2];
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		char[][] map=new char[m][n];
		boolean[][] visit=new boolean[m][n];
		for(int i=0; i<m; i++) {
			map[i]=br.readLine().toCharArray();
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if( !visit[i][j] && map[i][j]=='W') {
					result[0]+=solution.BFS(i , j , map , visit);
				}else if( !visit[i][j] && map[i][j] == 'B') {
					result[1]+=solution.BFS(i, j, map , visit);
				}
			}
		}
		System.out.println(result[0] +" " + result[1]);
	}
}
class Solution{
	protected int BFS( int x, int y, char[][] map , boolean[][] visit) {
		int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
		int count=1;
		Queue<dot> queue=new LinkedList<>();
		queue.add(new dot(x,y));
		visit[x][y]=true;
		while(!queue.isEmpty()) {
			dot d=queue.poll();
			for(int i=0; i<4; i++) {
				int tempx = d.x+dir[i][0];
				int tempy = d.y+dir[i][1];
				
				if(inbound(tempx , tempy , map.length , map[0].length ) && map[tempx][tempy] == map[x][y]
						&& !visit[tempx][tempy]) {
					visit[tempx][tempy]=true;
					queue.add(new dot(tempx,tempy));
					count++;
				}
			}
		}
		return count*count;
	}
	private boolean inbound(int x,int y ,int xlen,int ylen) {
		if(x >= 0 && y >= 0 && x < xlen && y < ylen) return true;
		else return false;
	}
}
class dot{
	int x;
	int y;
	dot(int x,int y){
		this.x=x;
		this.y=y;
	}
}
