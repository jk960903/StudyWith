package sellstock;

public class Main {

}
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for(int price : prices){
            min = Math.min(min,price);
            max = Math.max(max,price - min);
        }
        
        return max;
    }
}