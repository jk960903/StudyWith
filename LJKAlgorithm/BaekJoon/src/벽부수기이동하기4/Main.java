package 벽부수기이동하기4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		
		for(int i = 0 ; i < n ; i++) {
			char[] array = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				map[i][j] = array[j]-'0';
			}
		}
		
		int[][] result = BFS(map);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < map.length; i++) {
			for(int j = 0 ; j< map[i].length; j++) {
				sb.append(result[i][j] % 10);
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
		
		br.close();
	}
	
	private static int[][] BFS(int[][] map){
		int[][] result = new int[map.length][map[0].length];
		boolean[][] visit = new boolean[map.length][map[0].length];
		Queue<Dot> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		int count = 2;
		for(int i = 0; i< map.length; i++) {
			for(int j = 0; j< map[0].length; j++) {
				if(map[i][j] ==0 && !visit[i][j]) {
					queue.add(new Dot(i,j,1));
					makeMap(map,visit,queue,hashMap,count,i,j);
					count++;
				}
			}
		}
		
		for(int i = 0; i< map.length; i++) {
			for(int j = 0; j< map[0].length; j++) {
				if(map[i][j] ==1 && !visit[i][j]) {
					int resultCount = 1;
					
					boolean[] temp = new boolean[count];
					for(int k = 0 ; k <dir.length; k++) {
						int tempx = dir[k][0] + i;
						int tempy = dir[k][1] + j;
						
						if(inbound(tempx,tempy,map) && map[tempx][tempy] != 1 && !temp[map[tempx][tempy]]) {
							resultCount += hashMap.get(map[tempx][tempy]);
							temp[map[tempx][tempy]] = true;
						}
					}
					result[i][j] = resultCount;
				}
			}
		}
		
		
		
		return result;
	}
	
	private static void makeMap(int[][] map, boolean[][] visit,Queue<Dot> queue,
			HashMap<Integer,Integer> hashmap,int count,int startx , int starty){
		visit[startx][starty] = true;
		map[startx][starty] = count;
		int result = 1;
		while(!queue.isEmpty()) {
			Dot d = queue.poll();
			
			for(int i = 0; i< dir.length; i++) {
				int tempx = dir[i][0] + d.x;
				int tempy = dir[i][1] + d.y;
				
				if(inbound(tempx,tempy,map) && !visit[tempx][tempy] && map[tempx][tempy] == 0) {
					map[tempx][tempy] = count;
					result++;
					queue.add(new Dot(tempx,tempy,d.count+1));
					visit[tempx][tempy] = true;
				}
			}
			
		}
		
		hashmap.put(count,result);
		
	}
	
	private static boolean inbound(int tempx,int tempy, int[][] array) {
		if(tempx >= 0 && tempx < array.length && tempy>= 0 && tempy < array[0].length) return true;
		return false;
	}
}

class Dot{
	int x;
	int y;
	int count;
	
	public Dot(int x,int y ,int count) {
		this.x=x;
		this.y=y;
		this.count = count;
	}
}


