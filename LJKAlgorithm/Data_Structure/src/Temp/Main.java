package Temp;
import java.util.*;

public class Main{
	public static void main(String[] args) {
		int n = 5;
		int k = 12;
		Solution solution = new Solution();
		int[] result = solution.solution(n, k);
	}
}
class Solution {
    public int[] solution(int n, int k) {
        int[] answer = {};
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                map[i][j] = 10000000;
            }
        }
        Queue<dot> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int tempk = 1;
        queue.add(new dot(0,0,0));
        map[0][0] = -1;
        while(tempk < k){
        	visit = new boolean[n][n];
            while(!queue.isEmpty()){
                dot d = queue.poll();
                
                for(int i = 0 ; i<dir.length; i++){
                    int tempx = d.x + dir[i][0];
                    int tempy = d.y + dir[i][1];
                    
                    if(inbound(tempx,tempy,n) && !visit[tempx][tempy] && d.time+1 < map[tempx][tempy] && map[tempx][tempy]!=-1){
                        visit[tempx][tempy] = true;
                        map[tempx][tempy] = d.time+1;
                        queue.add(new dot(tempx,tempy,d.time+1));
                    }
                }
            }
            int max = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0 ; j < n; j++){
                    max = Math.max(max,map[i][j]);
                }
            }
            PriorityQueue<dot> pq = new PriorityQueue<>();
            for(int i = 0; i < n; i++){
                for(int j = 0 ; j < n; j++){
                    if(map[i][j] == max){
                        pq.add(new dot(i,j));
                    }
                }
            }
            
            dot pqd = pq.poll();
            map[pqd.x][pqd.y] = -1;
            queue.add(new dot(pqd.x,pqd.y,0));
            
            tempk++;
            
        }
        dot d = queue.poll();
        answer = new int[2];
        answer[0] = d.x+1;
        answer[1] = d.y+1;
        
        return answer;
    }
    private boolean inbound(int tempx,int tempy, int n){
        if(tempx >=0 && tempy >= 0 && tempx < n && tempy < n) return true;
        else return false;
    }
}
class dot implements Comparable<dot>{
    int x;
    int y;
    int time;
    public dot(int x , int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
    
    public dot(int x, int y){
        this.x =x;
        this.y =y;
    }
    

	@Override
	public int compareTo(dot arg0) {
		if(arg0.y == this.y) {
			return this.x- arg0.x;
		}
		return this.y-arg0.y;
	}
}