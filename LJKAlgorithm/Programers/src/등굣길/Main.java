package µî±·±æ;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp=new int[m+1][n+1];
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][0]][puddles[i][1]]=-1;
        }
        dp[1][1]=1;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
            	if(i==1&&j==1) continue;
                if(dp[i][j]!=-1&&dp[i-1][j]!=-1&&dp[i][j-1]!=-1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
                else if(dp[i][j]!=-1&&dp[i-1][j]==-1&&dp[i][j-1]!=-1){
                    dp[i][j]=dp[i][j-1];
                }else if(dp[i][j]!=-1&&dp[i-1][j]!=-1&&dp[i][j-1]==-1){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                System.out.println(dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
public class Main {
	public static void main(String[] args) {
		Solution solution=new Solution();
		int[][] puddles= {{2,2}};
		int answer=solution.solution(4, 3, puddles);
		System.out.println(answer);
	}
}
