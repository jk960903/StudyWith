package �����ﰢ��;
//���� ���� �ﰢ���� ����⿡�� �ٴڱ��� �̾����� ��� ��, ���İ� ������ ���� ���� ū ��츦 ã�ƺ����� �մϴ�. 
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		int[][] triangle= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4},{4, 5, 2, 6, 5}};
		int[][] dp=new int[triangle.length][triangle.length];
	 
	    int max=0;
	    int answer=0;
	    dp[0][0]=triangle[0][0];
	    for(int i=1; i<dp.length; i++){
	        dp[i][0]=dp[i-1][0]+triangle[i][0];
	        for(int j=1; j<triangle[i].length; j++){
	            dp[i][j]=dp[i-1][j-1]+triangle[i][j]>dp[i-1][j]+triangle[i][j] ? dp[i-1][j-1]+triangle[i][j]:dp[i-1][j]+triangle[i][j];
	            if(dp[i][j]>max){
	                max=dp[i][j];
	            }
	        }
	    }
	    answer=max;
	    System.out.println(max);

	    
	}
}
