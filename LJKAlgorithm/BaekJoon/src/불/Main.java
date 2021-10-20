package บา;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testcase = Integer.parseInt(br.readLine());
			for(int tc = 0 ; tc<testcase; tc++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				char[][] map = new char[m][n];
				for(int i = 0; i<map.length; i++) {
					map[i]=br.readLine().toCharArray();
				}
				Solution solution = new Solution();
				int num = solution.BFS(map);
				if(num==0) {
					System.out.println("IMPOSSIBLE");
				}else {
					System.out.println(num);
				}
				
			}
		}catch(Exception e) {
			
		}
	}
}
class Solution{
	public int BFS(char[][] map) {
		boolean[][] visit = new boolean[map.length][map[0].length];
		int x=-1,y = -1;
		List<dot> firelist = new ArrayList<>();
		for(int i = 0 ; i<map.length; i++) {
			for(int j = 0; j<map[0].length; j++) {
				if(map[i][j]=='@') {
					x=i;
					y=j;
				}
				if(map[i][j]=='*') {
					firelist.add(new dot(i,j,'*'));
				}
			}
		}
		visit[x][y]=true;
		Queue<dot> queue = new LinkedList<>();
		for(int i = 0 ; i<firelist.size(); i++) {
			dot d = firelist.get(i);
			queue.add(new dot(d.x,d.y,d.data,0));
		}
		queue.add(new dot(x,y,'@',0));
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		while(!queue.isEmpty()) {
			dot d = queue.poll();
			
			for(int i = 0 ; i<dir.length; i++) {
				int tempx = d.x + dir[i][0];
				int tempy = d.y + dir[i][1];
				if(d.data=='*') {
					if(inbound(tempx,tempy,map) && map[tempx][tempy] !='#' && map[tempx][tempy] !='*') {
						map[tempx][tempy]='*';
						queue.add(new dot(tempx,tempy,'*',d.day+1));
					}
				}else if(d.data=='@') {
					if(!inbound(tempx,tempy,map)) {
						return d.day+1;
					}else if(inbound(tempx,tempy,map) && map[tempx][tempy]=='.' && !visit[tempx][tempy]) {
						visit[tempx][tempy]=true;
						map[tempx][tempy]='@';
						queue.add(new dot(tempx,tempy,'@',d.day+1));
					}
				}
			}
		}
		return 0;
	}
	
	private boolean inbound(int tempx, int tempy , char[][] map) {
		if(tempx>=0 && tempy>= 0 && tempx < map.length && tempy < map[0].length) {
			return true;
		}
		return false;
	}
}
class dot{
	public int x;
	public int y;
	public char data;
	int day;
	public dot(int x, int y,char data,int day) {
		this.x=x;
		this.y=y;
		this.data=data;
		this.day = day;
	}
	
	public dot(int x, int y,char data) {
		this.x=x;
		this.y=y;
		this.data=data;
	}
}
