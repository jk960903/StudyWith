package JumpGame3;
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0)return true;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        boolean[] visit=new boolean[arr.length];
        visit[start]=true;
        while(!queue.isEmpty()){
            int index=queue.poll();
            if(index+arr[index]<arr.length&&!visit[index+arr[index]]){
                if(arr[index+arr[index]]==0)return true;
                queue.add(index+arr[index]);
                visit[index+arr[index]]=true;    
            }
            
            if(index-arr[index]>=0&&!visit[index-arr[index]]){
                if(arr[index-arr[index]]==0)return true;
                queue.add(index-arr[index]);
                visit[index-arr[index]]=true;
            }
        }   
        return false;
    }
}