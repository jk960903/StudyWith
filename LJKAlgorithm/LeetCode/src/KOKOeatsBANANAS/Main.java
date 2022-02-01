package KOKOeatsBANANAS;
import java.util.*;

public class Main{
	public static void main(String[] args) {
		
	}
}
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        
        int left = 0;
        int right = piles[piles.length-1];
        
        while(left < right){
            int mid = (left+right ) / 2;
            
            int count = 0;
            for(int num : piles){
                count += Math.ceil((double)num / mid);
            
            }
            
            if(count > h){
                left = mid+1;
            }
            
            else 
                right = mid;
        }
        
        return left;
    }
}