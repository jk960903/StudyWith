package Ä«Ä«¿ÀÇÁ·»ÁîÄÃ·¯¸µºÏ;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Solution solution=new Solution();
		int m=6;
		int n=4;
		int[][] picture={{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] result=solution.solution(m, n, picture);
		System.out.println(result[0] + " " + result[1]);
	}
}
class Solution {
    private final int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static boolean[][] visit;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        Queue<Integer> queue=new LinkedList<>();
        visit=new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j] && picture[i][j]!=0){
                    numberOfArea++;
                    maxSizeOfOneArea=Math.max( maxSizeOfOneArea , 
                                              findArea( picture , i , j , picture[i][j]));
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private int findArea(int[][] picture , int x , int y , int data){
        Queue<dot> queue=new LinkedList<>();
        queue.add(new dot(x,y));
        visit[x][y]=true;
        int count=1;
        while(!queue.isEmpty()){
            dot d=queue.poll();
            for(int i=0; i<dir.length; i++){
                int tempx = d.x + dir[i][0];
                int tempy = d.y + dir[i][1];
                if(inbound(tempx , tempy , picture.length , picture[0].length) && !visit[tempx][tempy]
                   && picture[tempx][tempy] == data){
                    queue.add(new dot(tempx,tempy));
                    count++;
                    visit[tempx][tempy] = true;
                }
            }
        }
        return count;
    }
    private boolean inbound(int x,int y,int m ,int n){
        if(x < m && x >= 0 && y < n && y >= 0) return true;
        else return false;
    }
}
class dot{
    int x;
    int y;
    public dot(int x,int y){
        this.x=x;
        this.y=y;
    }
}