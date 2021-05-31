package 숫자판점프;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] array=new int[5][5];
		Solution solution = new Solution();
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < 5; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution.counttemp(array));
	}
}
class Solution{
	private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	protected int counttemp(int[][] array) {
		Queue<dot> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				queue.add(new dot(i , j , Integer.toString(array[i][j])));
			}
		}
		while(!queue.isEmpty()) {
			dot d = queue.poll();
			if(d.num.length() == 6) {
				set.add(d.num);
				continue;
			}
			for(int i = 0 ; i < 4; i++) {
				int tempx = d.x + dir[i][0];
				int tempy = d.y + dir[i][1];
				if(inbound(tempx,tempy) && d.num.length() <=5) {
					queue.add( new dot( tempx , tempy , d.num + Integer.toString(array[tempx][tempy])));
				}
			}
		}
		return set.size();
	}
	private boolean inbound(int x, int y) {
		if(x >= 0 && y>= 0 && x < 5 && y < 5) return true;
		else return false;
	}
}
class dot{
	int x;
	int y;
	String num;
	protected dot(int x, int y, String num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
	
}
