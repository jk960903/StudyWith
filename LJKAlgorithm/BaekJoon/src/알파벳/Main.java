package ¾ËÆÄºª;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
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
		HashSet<Character> set=new HashSet<>();
		DFS(map,set,map[0][0],0,0);
		System.out.println(max);
		
	}
	public static void DFS(char[][] map,HashSet<Character> set,char now,int startx,int starty) {
		StringBuilder sb=new StringBuilder();
		for(Character temp: set) {
			if(now==temp) {
				sb.append(now);
				if(max<sb.length()) {
					max=sb.length();
				}
				return;
			}else {
				sb.append(temp);
			}
		}
		sb.append(now);
		if(max<sb.length()) {
			max=sb.length();
		}
		for(int i=0; i<dir.length; i++)
		{
			int tempx=startx+dir[i][0];
			int tempy=starty+dir[i][1];
			if(inbound(tempx,tempy,map)) {
				set.add(now);
				DFS(map,set,map[tempx][tempy],tempx,tempy);
				set.remove(now);
			}
		}
	}
	public static boolean inbound(int x, int y,char[][] map) {
		if(x<0||y<0||x>=map.length||y>=map[0].length) {
			return false;
		}
		return true;
	}
}
