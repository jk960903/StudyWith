package SpiralMatrix2;

public class Main {

}
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num =1 ;
        int dir = 1;
        int maxx = n;
        int maxy = n;
        int minx = 0;
        int miny = 0;
        while(num<=n*n){
            for(int i = miny; i<maxy; i++){
                result[minx][i]=num;
                num++;
            }
            for(int i = minx+1; i<maxx; i++){
                result[i][maxy-1] = num;
                num++;
            }
            for(int i = maxy-2; i>miny; i--){
                result[maxx-1][i]=num;
                num++;
            }
            for(int i = maxx-1; i>minx; i--){
                result[i][miny]=num;
                num++;
            }
            maxx--;
            maxy--;
            minx++;
            miny++;
        }
        return result;
    }
}