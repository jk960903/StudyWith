package 데브캣;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Solution solution =new Solution();
		//int[][] maps = {{1, 28, 41, 22, 25, 79, 4}, {39, 20, 10, 17, 19, 18, 8}, {21, 4, 13, 12, 9, 29, 19}, {58, 1, 20, 5, 8, 16, 9}, {5, 6, 15, 2, 39, 8, 29},{39, 7, 17, 5, 4, 49, 5}, {74, 46, 8, 11, 25, 2, 11}};
		//System.out.println(solution.solution(maps, 19, 4));
		//int[][] battery = {{5,30000},{3,18000},{7,28000},{2,9500}};
		int[][] battery = {{10000,10000},{2,20000}};
		System.out.println(solution.solution2(10000,battery));
	}
}
class Solution {
    public int solution(int[][] maps, int p, int r) {
        int answer = 0;
       
        for(int i = 0 ; i < maps.length; i++){
            for(int j = 0; j<= maps[0].length - r; j++){
                int count = 0; 
                count+= getSide(maps,p,r,i,j);
                count+= getInside(maps,p,r,i,j);
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
    public int getSide(int[][] maps , int p , int r , int x ,int y){
        int count = 0;
        for(int i = 1 ; i <= r/2; i++){
            if(inbound(maps,x-i,y+i-1) && maps[x-i][y+i-1] <= p/2) count++;
        }
        for(int i = 1; i <= r/2; i++){
            if(inbound(maps,x - r/2 + i - 1 , y + r/2 + i - 1) 
               && maps[x - r/2 + i -1][y + r/2 + i - 1] <= p/2) count++;
        }
        for(int i = 1; i <= r/2; i++){
            if(inbound(maps,x + i -1, y + r - i) && maps[x + i-1][y + r - i] <= p/2) count++;
        }
        for(int i =1; i<= r/2; i++){
            if(inbound (maps,x + i -1 , y +i -1) && maps[x + i -1][y +i -1] <= p/2) count++;
        }
        return count;
    }
    public int getInside(int[][] maps, int p , int r ,int x, int y){
        int count = 0;
        int tempr = r - 2;
        int tempx1 = x;
        int tempy = y;
        
        int tempx2 =x -1 ;
        int k = 1;
        while(tempr != 0 && inbound(maps,tempx1, tempy)){
            tempy = tempy + k;
            for(int i = 0; i<tempr; i++){
                if(inbound(maps,tempx1,tempy+i) && maps[tempx1][tempy+i] <= p){
                    count ++;
                }
            }
            tempx1++;
            tempr -= 2;
        }
        k = 1;
        tempy = y;
        tempr = r - 2;
        while(tempr != 0 && inbound(maps,tempx2, tempy)){
            tempy = tempy+k;
            for(int i = 0; i<tempr; i++){
                if(inbound(maps,tempx2,tempy+i) && maps[tempx2][tempy+i] <= p){
                    count ++;
                }
            }
            tempx2--;
            tempr -=2;
        }
        return count;
    }
    private boolean inbound(int[][] maps, int x , int y){
        if(x >= 0 && y >= 0 && x < maps.length && y < maps[0].length) return true;
        else return false;
    }
    
    public int solution2(int n, int[][] battery) {
    	int answer = 0;
        int[] dp =new int[2*n+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int nummin = 10001;
        int min = 10000000;
        //중복된 값이 있지않을까?
        for(int i = 0 ; i <battery.length; i++){
            nummin = Math.min(battery[i][0],nummin);
            if(battery[i][0] > dp.length){
                min = Math.min(min , battery[i][1]);
                continue;
            }
            if(map.containsKey(battery[i][0])){
                int temp = map.get(battery[i][0]);
                int temp2 = Math.min(temp,battery[i][1]);
                map.put(battery[i][0],temp2);
                dp[battery[i][0]] = battery[i][1];
            }else{
                set.add(battery[i][0]);
                map.put(battery[i][0],battery[i][1]);
                dp[battery[i][0]] = battery[i][1];
            }
        }
        for(int i = nummin; i <= n; i++){
            for(int num : set){
                if(i + num < dp.length){
                	if(dp[i] == 0 ) {
                		continue;
                	}else {
                		if(dp[i+num] == 0) dp[i+num] = dp[i] + map.get(num);
                		else dp[i+num] = Math.min(dp[i+num], dp[i]+map.get(num));
                	}
                    
                }
            }
        }
        for(int i = n ; i<= 2*n; i++) {
        	if(dp[i] == 0 ) continue;
            else{
                min = Math.min(dp[i] , min);
            }
        }
        return min;
        
    }
}