package SpiralMatrix;

import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int x=0;
        int y=0;
        int dir=1;//1¿À/
        List<Integer> list=new ArrayList<>();
        boolean[][] visit=new boolean[matrix.length][matrix[0].length];
        int num=0;
        while(true){
            if(dir==1){
                while(inbound(x,y,matrix)&&!visit[x][y]){
                    list.add(matrix[x][y]);
                    visit[x][y]=true;
                    y=y+1;
                    num++;
                }
                y=y-1;
                x=x+1;
                dir=2;
            }else if(dir==2){
                while(inbound(x,y,matrix)&&!visit[x][y]){
                    list.add(matrix[x][y]);
                    visit[x][y]=true;
                    x++;
                    num++;
                }
                x--;
                y--;
                dir=3;
            }else if(dir==3){
                while(inbound(x,y,matrix)&&!visit[x][y]){
                    list.add(matrix[x][y]);
                    visit[x][y]=true;
                    y--;
                    num++;
                }
                y++;
                x--;
                dir=4;
            }else if(dir==4){
                while(inbound(x,y,matrix)&&!visit[x][y]){
                    list.add(matrix[x][y]);
                    visit[x][y]=true;
                    x--;
                    num++;
                }
                x++;
                y++;
                dir=1;
            }
            if(num>=matrix.length*matrix[0].length)break;
        }
        return list;
    }
    public boolean inbound(int x,int y,int[][] map){
        if(x<0||y<0||x>=map.length||y>=map[0].length)return false;
        return true;
    }
}