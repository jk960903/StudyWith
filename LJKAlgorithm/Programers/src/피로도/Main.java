package ÇÇ·Îµµ;

public class Main {

}
class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visit= new boolean[dungeons.length];
        int[] output = new int[dungeons.length];
        DFS(dungeons,0,k,dungeons.length,visit,output);
        return max;
    }
    
    private void DFS(int[][] dungeons,int depth , int k ,int n,boolean[] visit,int[] output){
        if(depth == n){
            max = count(dungeons,output,k);    
        }else{
            for(int i =0; i<n; i++){
                if(!visit[i]){
                    visit[i]=true;
                    output[depth]=i;
                    DFS(dungeons,depth+1,k,n,visit,output);
                    visit[i]=false;
                }
            }
        }
    }
    private int count(int[][] dungeons,int[] output, int k){
        int count = 0;
        for(int i = 0 ; i<output.length; i++){
            int index = output[i];
            int min = dungeons[index][0];
            int use = dungeons[index][1];
            if(k >= min){
                count++;
                k-=use;
            }
        }
        return Math.max(max,count);
    }
}