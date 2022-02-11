package SubarraySumEqualsK;
import java.util.*;
public class Main {

}
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        map.put(0,1);
        int answer = 0 ;
        
        int total = 0 ;
        for(int num : nums){
            total += num;
            
            if(map.containsKey(total-k)){
                answer += map.get(total-k);
            }
            
            
            map.put(total,map.getOrDefault(total,0)+1);
        }
        
        return answer;
    }
}