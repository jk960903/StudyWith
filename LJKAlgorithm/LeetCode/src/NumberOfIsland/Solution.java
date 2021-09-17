package NumberOfIsland;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    private static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        int result=0;
        Queue<dot> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j = 0 ; j<grid[0].length; j++){
                if(grid[i][j]=='1' && !visit[i][j]){
                    queue.add(new dot(i,j));
                    result+=BFS(queue,grid,visit);
                }
            }
        }
        return result;
    }
    
    private int BFS(Queue<dot> queue,char[][] grid,boolean[][] visit){
        int num = 0;
        while(!queue.isEmpty()){
            dot d = queue.poll();
            visit[d.x][d.y] = true;
            
            for(int i = 0 ; i<dir.length; i++){
                int tempx = d.x+dir[i][0];
                int tempy= d.y+dir[i][1];
                if(inbound(tempx,tempy,grid.length,grid[0].length) && grid[tempx][tempy] =='1' && !visit[tempx][tempy]){
                    visit[tempx][tempy]=true;
                    queue.add(new dot(tempx,tempy));
                }
            }
        }
        return 1;
    }
    
    private boolean inbound(int tempx,int tempy ,int xlen,int ylen){
        if(tempx <0 || tempx >=xlen ||tempy <0 || tempy >=ylen) return false;
        return true;
    }
    
    
}
class dot{
    int x;
    int y;
    
    public dot(int x, int y){
        this.x =x;
        this.y= y;
        
    }
}