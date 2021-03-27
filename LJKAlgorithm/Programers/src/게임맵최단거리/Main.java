package 게임맵최단거리;
import java.util.*;
public class Main {

}
class Solution {
    final int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<dot> queue=new LinkedList<>();
        boolean[][] visit=new boolean[maps.length][maps[0].length];
        queue.add(new dot(0,0,1));
        visit[0][0]=true;
        while(!queue.isEmpty()){
            dot d=queue.poll();
            if(d.x == maps.length -1 && d.y == maps[0].length -1){
                answer = d.level;
                break;
            }
            for(int i = 0; i < 4; i++){
                int tempx=d.x+dir[i][0];
                int tempy=d.y+dir[i][1];
                
                if(inbound( tempx, tempy, maps.length, maps[0].length) && !visit[tempx][tempy] && maps[tempx][tempy]==1){
                    queue.add(new dot(tempx,tempy,d.level+1));
                    //System.out.println(d.level);
                    visit[tempx][tempy]=true;
                }
                
            }
        }
        return answer;
    }
    private boolean inbound(int x, int y, int sizex,int sizey){
        if(x >= 0 && y >= 0 && x <sizex && y < sizey) return true;
        else return false;
    }
}
class dot{
    int x;
    int y;
    int level;
    public dot(int x,int y,int level){
        this.x=x;
        this.y=y;
        this.level=level;
    }
}