package 미로탈출하기;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		char[][] array=new char[n][m];
		boolean[][] result=new boolean[n][m];
		boolean[][] visit=new boolean[n][m];
		int count=0;
		for(int i=0; i<n; i++) {
			array[i]=br.readLine().toCharArray();
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				DFS(i,j,array,visit,result);
				if(result[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
		
	}
	private static boolean DFS(int x,int y,char[][] map,boolean[][] visit,boolean[][] result) {
		if(!inbound(x,y,map)||result[x][y]) {
			return true;
		}
		if(map[x][y]=='U') {
			if(!visit[x][y]) {
				int tempx=x-1;
				visit[x][y]=true;
				result[x][y]=DFS(tempx,y,map,visit,result);
			}
		}else if(map[x][y]=='R') {
			if(!visit[x][y]) {
				int tempy=y+1;
				visit[x][y]=true;
				result[x][y]=DFS(x,tempy,map,visit,result);
			}
		}else if(map[x][y]=='D') {
			if(!visit[x][y]) {
				int tempx=x+1;
				visit[x][y]=true;
				result[x][y]=DFS(tempx,y,map,visit,result);
			}
		}else if(map[x][y]=='L') {
			if(!visit[x][y]) {
				int tempy=y-1;
				visit[x][y]=true;
				result[x][y]=DFS(x,tempy,map,visit,result);
			}
		}
		return result[x][y];
	}
	private static boolean inbound(int x,int y,char[][] map) {
		if(x>=map.length||x<0||y>=map[0].length||y<0) return false;
		return true;
	}
}
