package QueensAttack2;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Solution {
    static int[][] dir={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    	HashMap<String,Integer> wall=new HashMap<>();
    	for(int i=0; i<obstacles.length; i++) {
    		int x=obstacles[i][0]-1;
    		int y=obstacles[i][1]-1;
    		String key=Integer.toString(x)+" "+Integer.toString(y);
    		wall.put(key,1);
    	}
        int answer=0;
        int x=r_q-1;
        int y=c_q-1;
        for(int i=0; i<dir.length; i++){
            int tempx=x+dir[i][0];
            int tempy=y+dir[i][1];
            while(inbound(tempx,tempy,n)){
            	String key=Integer.toString(tempx)+" "+Integer.toString(tempy);
            	if(wall.containsKey(key))break;
            	answer++;
            	tempx+=dir[i][0];
            	tempy+=dir[i][1];
            }
        }
        return answer;
    }
    static boolean inbound(int x,int y,int n){
        if(x<0||y<0||x>=n||y>=n)return false;
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println(result);
        scanner.close();
    }
}
