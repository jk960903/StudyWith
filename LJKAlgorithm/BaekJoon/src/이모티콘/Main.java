package 이모티콘;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int s = Integer.parseInt(br.readLine());
		System.out.println(BFS(s));
	}
	
	static int BFS(int end) {
		Queue<emotion> queue= new LinkedList<>();
		boolean[][] visit = new boolean[1001][1001];
		queue.add(new emotion(0,1,0));
		visit[0][1] = true;
		int answer = 0 ;
		while(!queue.isEmpty()) {
			emotion e = queue.poll();
			
			if(e.screen == end) {
				 answer = e.second;
				 break;
			}
			queue.add(new emotion(e.screen,e.screen,e.second+1));
			
			if(e.clipboard != 0 && e.screen + e.clipboard <= end &&!visit[e.clipboard][e.screen+e.clipboard]) {
				queue.add(new emotion(e.clipboard,e.screen+e.clipboard, e.second+1));
				visit[e.clipboard][e.screen+e.clipboard] = true;
			}
			
			if(1 <= e.screen && !visit[e.clipboard][e.screen-1]) {
				queue.add(new emotion(e.clipboard,e.screen-1,e.second+1));
				visit[e.clipboard][e.screen-1]=true;
			}
		}
		return answer;
	}
}
class emotion{
	public int screen;
	public int clipboard;
	public int second;
	
	
	public emotion(int clipboard, int screen, int second) {
		this.screen = screen;
		this.clipboard = clipboard;
		this.second = second;
	}
}
