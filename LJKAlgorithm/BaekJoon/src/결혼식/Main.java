package °áÈ¥½Ä;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0 ;
		try {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] list = new ArrayList[n+1];
			for(int i = 0; i <list.length; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0 ; i<m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," " );
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			Queue<level> queue = new LinkedList<>();
			boolean[] visit = new boolean[n+1];
			visit[1] = true;
			for(int i = 0 ; i<list[1].size(); i++) {
				queue.add(new level(list[1].get(i),1));
			}
			while(!queue.isEmpty()) {
				level temp = queue.poll();
				if(temp.level<=2 && !visit[temp.num]) {
					visit[temp.num]=true;
					answer++;
				}else {
					continue;
				}
				for(int i = 0 ; i < list[temp.num].size(); i++) {
					queue.add(new level(list[temp.num].get(i),temp.level+1));
				}
					
				
			}
			
			System.out.println(answer);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
class level{
	int num;
	int level;
	public level(int num , int level) {
		this.num = num;
		this.level = level;
	}
}
