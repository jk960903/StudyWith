import java.io.*;
import java.util.*;
public class Problem1 {
	public static void main(String[] args) {
		int n = 5;
		boolean clockwise = true;
		
		Solution solution = new Solution();
		int[][] result = solution.solution(n,clockwise);
	}
}

class Solution {
    //dir 1 ¿À 2 À§ 3 ¿Þ 4 ¾Æ·¡
    public int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];
        Queue<Dot> queue = new LinkedList<>();
        if(clockwise){
            queue.add(new Dot(0,0,1,1));
            queue.add(new Dot(0,n-1,4,1));
            queue.add(new Dot(n-1,n-1,3,1));
            queue.add(new Dot(n-1,0,2,1));

            int count = 0;
            
            while(!queue.isEmpty() && count <= n*n ){
                Dot d = queue.poll();
                answer[d.x][d.y] = d.num;
                if(inbound(d.x,d.y+1,n)&&d.dir == 1 && answer[d.x][d.y+1] != 0){
                    queue.add(new Dot(d.x+1,d.y,4,d.num+1));
                }else if(inbound(d.x,d.y+1,n)&&d.dir == 1 && answer[d.x][d.y+1] == 0){
                    queue.add(new Dot(d.x,d.y+1,d.dir,d.num+1));
                }else if(inbound(d.x-1,d.y,n)&&d.dir ==2 && answer[d.x-1][d.y] != 0){
                    queue.add(new Dot(d.x,d.y+1,1,d.num+1));
                }else if(inbound(d.x-1,d.y,n)&&d.dir ==2 && answer[d.x-1][d.y] == 0){
                    queue.add(new Dot(d.x-1,d.y,d.dir,d.num+1));
                }else if(inbound(d.x,d.y-1,n)&&d.dir ==3 && answer[d.x][d.y-1] != 0){
                    queue.add(new Dot(d.x-1,d.y,2,d.num+1));
                }else if(inbound(d.x,d.y-1,n)&&d.dir == 3 && answer[d.x][d.y-1] == 0){
                    queue.add(new Dot(d.x,d.y-1,d.dir,d.num+1));
                }else if(inbound(d.x+1,d.y,n)&&d.dir == 4 && answer[d.x+1][d.y] != 0){
                    queue.add(new Dot(d.x,d.y-1,3,d.num+1));
                }else if(inbound(d.x+1,d.y,n)&&d.dir == 4 && answer[d.x+1][d.y] == 0){
                    queue.add(new Dot(d.x,d.y-1,3,d.num+1));
                }
                count++;
                
            }
        }else{

        }
        return answer;
    }
    public boolean inbound(int x ,int y ,int n){
        if(x < 0 || x >= n || y < 0 || y >= n) return false;
        return true;
    }
    
}

class Dot{
    int x;
    int y;
    int dir;
    int num;

    public Dot(int x, int y, int dir , int num){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.num = num;
    }
}