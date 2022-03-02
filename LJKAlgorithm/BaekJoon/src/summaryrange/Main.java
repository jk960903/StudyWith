package summaryrange;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[] nums = {0,2,3,4,6,8,9};
		Solution solution = new Solution();
		List<String> list = solution.summaryRanges(nums);
		for(String s : list) {
			System.out.println(s);
		}
	}
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int index = 0;
        List<String> list = new ArrayList<>();
        while(index < nums.length){
            StringBuilder sb = new StringBuilder();
            sb.append(nums[index]);
            if( index + 1 < nums.length && nums[index]+1 != nums[index+1]){
                list.add(sb.toString());
                index++;
            }
            else if(index + 1 < nums.length && nums[index]+1 == nums[index+1]){
                while(index < nums.length){
                    if(index+1 < nums.length && nums[index] + 1 == nums[index+1]){
                        index ++;
                    }else{
                        sb.append("->");
                        sb.append(nums[index]);
                        index++;
                        list.add(sb.toString());
                        break;
                    }
                }    
            }else if(index + 1 == nums.length) {
            	list.add(sb.toString());
            	index++;
            }
            
        }
        return list;
    }
}