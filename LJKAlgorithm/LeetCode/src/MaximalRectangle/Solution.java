package MaximalRectangle;

public class Solution {
	public static int maximalRectangle(char[][] matrix) {
        square[][] dp=new square[matrix.length+1][matrix[0].length+1];
        for(int i=0; i<=matrix[0].length; i++){
            dp[0][i]=new square(0,0,0,0);
        }
        for(int i=0; i<=matrix.length; i++){
            dp[i][0]=new square(0,0,0,0);
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]-'0'==1){
                    dp[i+1][j+1]=new square(1,1,1,1);   
                }else{
                    dp[i+1][j+1]=new square(0,0,0,0);
                }
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(dp[i][j].x!=0){//1인위치
                    if(dp[i-1][j-1].sum!=0&&dp[i-1][j].sum!=0&&dp[i][j-1].sum!=0){
                    	if(dp[i-1][j].sum==dp[i][j-1].sum) {
                    		int num=(int)Math.sqrt(dp[i-1][j-1].sum);
                    		dp[i-1][j-1].sum=(num+1)*(num+1);
                    	}else if(dp[i-1][j-1].sum==dp[i-1][j].sum)
                    	
                    	dp[i][j].x=dp[i-1][j].x+1;
                        dp[i][j].y=dp[i][j-1].y+1;
                        dp[i][j].max=Math.max(dp[i][j].sum,Math.max(dp[i][j].x,dp[i][j].y));
                    }
                    else if(dp[i-1][j-1].sum==0&&dp[i][j-1].y!=0&&dp[i-1][j].x!=0){//대각선이 0 십자 모양
                        int x=dp[i-1][j].x;
                        int y=dp[i][j-1].y;
                        dp[i][j].x=x+1;
                        dp[i][j].y=y+1;
                        dp[i][j].max=Math.max(dp[i][j].x,dp[i][j].y);
                        dp[i][j].sum=dp[i][j].max;
                    }
                    else if(dp[i-1][j].x==0&&dp[i][j-1].y!=0){
                        dp[i][j].y=dp[i][j-1].y+1;
                        dp[i][j].max=dp[i][j].y;
                    }
                    else if(dp[i][j-1].y==0&&dp[i-1][j].x!=0){
                        dp[i][j].x=dp[i-1][j].x+1;
                        dp[i][j].max=dp[i][j].x;
                    }
                }
            }
        }
        int result=0;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                result=Math.max(dp[i][j].max,result);
            }
        }
        return result;    
	}
	public static void main(String[] args) {
		String[][] matrix= {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
		/*String[][] matrix= {{"0","0","0","0","0","0","1"},
							{"0","0","0","0","1","1","1"},
							{"1","1","1","1","1","1","1"},
							{"0","0","0","1","1","1","1"}};*/
		char[][] realmatrix=new char[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				char temp=matrix[i][j].charAt(0);
				realmatrix[i][j]=temp;
			}
		}
		char[][] temp= {{'0'}};
		int result=maximalRectangle(realmatrix);
		System.out.println(result);
	}
}
class square{
    int x;
    int y;
    int sum;
    int max;
    public square(int x,int y,int sum,int max){
        this.x=x;
        this.y=y;
        this.sum=sum;
        this.max=max;
    }
}

