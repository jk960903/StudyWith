package MinimumPathSum;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] grid = {{1,2},{1,1}};
		System.out.println(solution.minPathSum(grid));
	}
}
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];

        for(int i = 1 ; i<dp[0].length; i++){
            dp[1][i]=grid[0][i-1]+dp[1][i-1];
        }
        for(int i = 1; i<dp.length; i++){
            dp[i][1] = grid[i-1][0]+dp[i-1][1];
        }
        for(int i=1; i<grid.length; i++){
            for(int j = 1 ; j<grid[0].length; j++){
                System.out.println(dp[i][j+1] + " " +dp[i+1][j]);
                dp[i+1][j+1]=Math.min(dp[i][j+1],dp[i+1][j])+grid[i][j];
            }
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}