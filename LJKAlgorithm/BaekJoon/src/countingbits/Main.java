package countingbits;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		int n = 100;
		Solution solution = new Solution();
		
		int [] result = solution.countBits(n);
		
		for(int num : result) {
			System.out.print(num +" ");
		}
	}
}

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        
        if(n == 0){
            return dp;
        }
        
        dp[1] = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 2; i <= n; i*=2){
            list.add(i);
        }
        
        int listindex = 0 ;
        int index = 2;
        
        while(index <=n ){
            if(listindex+1 < list.size() && index == list.get(listindex+1)){
                if(listindex+1 != list.size()) {
                	listindex++;
                }
            	dp[index] = 1;
                index++;
            }else{
                dp[index] = dp[list.get(listindex)] + dp[index - list.get(listindex)];
                index++;
            }     
        }
        
        return dp;
        
        
    }
}
