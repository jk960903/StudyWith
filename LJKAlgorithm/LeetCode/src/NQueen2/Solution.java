package NQueen2;

public class Solution {
    static int count=0;
    public int totalNQueens(int n) {
        count=0;
        int result=0;
        for(int i=0; i<n; i++){
            int[] array=new int[n];
            array[0]=i;
            DFS(array,0);
        }
        return count;
    }
    private void DFS(int[] array,int n){
        if(array.length-1==n){
            count++;
            return;
        }
        else{
            for(int i=0; i<array.length; i++){
                array[n+1]=i;
                if(possible(array,n+1)){
                    DFS(array,n+1);
                }
            }
        }
    }
    private boolean possible(int[] array,int n){
        for(int i=0; i<n; i++){
            if(array[i]==array[n]){
                return false;
            }
            if(Math.abs(i-n)==Math.abs(array[i]-array[n])){
                return false;
            }
        }
        return true;
    }
}
