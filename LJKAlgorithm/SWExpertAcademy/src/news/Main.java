package news;
import java.util.*;
class Solution {
    public String[] solution(int[][] macaron) {
        String[] answer = {};
        int[] height = new int[6];
        for(int i = 0 ; i<height.length; i++){
            height[i]=5;
        }
        int[][] map = new int [6][6];
        for(int i = 0 ; i<macaron.length; i++){
            map[height[macaron[i][0]-1]][macaron[i][0]-1] = macaron[i][1];
            height[macaron[i][0]-1]--;
            while(true){
                if(!canBreak(map,height)){
                    break;
                }
                canBreak(map,height);
            }
            
        }
        answer = new String[6];
        for(int i = 0; i<map.length; i++) {
        	for(int j = 0; j<map[0].length; j++) {
        		answer[i]+=Integer.toString(map[i][j]);
        		System.out.print(map[i][j]);
        	}
        	System.out.println();
        }
        return answer;
    }
    
    private boolean canBreak(int[][] map,int[] height){

    	int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] visit = new boolean[6][6];
        for(int i = 0 ; i<map.length; i++){
            for(int j = 0 ; j<map[0].length; j++){
                if(map[i][j]!=0 && !visit[i][j]){
                    ArrayList<dot> list = new ArrayList<>();
                    visit[i][j] =true;
                    list.add(new dot(i,j,map[i][j]));
                    Queue<dot> queue = new LinkedList<>();
                    queue.add(new dot(i,j,map[i][j]));
                    while(!queue.isEmpty()){
                        dot d = queue.poll();
                        
                        for(int k = 0 ; k<dir.length; k++){
                            int tempx = d.x + dir[k][0];
                            int tempy = d.y + dir[k][1];
                            
                            if(inbound(tempx,tempy)&&!visit[tempx][tempy] && map[tempx][tempy]==d.data){
                                queue.add(new dot(tempx,tempy,d.data));
                                visit[tempx][tempy]=true;
                                list.add(new dot(tempx,tempy,d.data));
                            }
                        }
                    }
                    if(list.size() >=3){
                        for(int k = 0; k<list.size(); k++){
                            dot d = list.get(k);
                            map[d.x][d.y] = 0;
                        }
                        Queue<Integer> queues = new LinkedList<>();
                        for(int k = 0; k<6; k++){
                            for(int l = 5; l>=0; l--){
                                if(map[l][k] !=0){
                                    queues.add(map[l][k]);
                                    map[l][k]=0;
                                }
                            }
                            int length = 5;
                            while(!queues.isEmpty()){
                                map[length][k]=queues.poll();
                                length--;
                            }
                            height[k]=length;
                        }
                        return true;
                    }
                
                }
            }
        }
        return false;
    }
    private boolean inbound(int tempx, int tempy){
        if(tempx< 0 || tempx>5 || tempy < 0 || tempy>5) return false;
        return true;
    }
}
class dot{
    int x;
    int y;
    int data;
    public dot(int x, int y,int data){
        this.x= x;
        this.y = y;
        this.data = data;
    }
}

public class Main{
	public static void main(String[] args) {
		int[][] macaron= {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
		Solution solution = new Solution();
		solution.solution(macaron);
		
	}
}