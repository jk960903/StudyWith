package 입국심사;
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        return binarySearch(times,n,times[times.length-1]);
    }
    
    private long binarySearch(int[] times , int n , long max){
        long left = 1; 
        long right = max * n;
        long answer = Long.MAX_VALUE;
        
        while(left<=right){
            long mid = (left+right)/2;
            
            if(isPassed(times,n,mid)){
                answer = answer > mid ? mid : answer;
                right = mid - 1; 
            }else{
                left = mid +1;
            }
            
        }
        return answer;
    }
    
    private boolean isPassed(int[] times,int n , long mid){
        long answer = 0 ;
        
        for(int i = 0; i<times.length; i++){
            answer += mid / times[i];
        }
        
        if(answer >=n) return true;
        else return false;
    }
}

public class Main {

}
