package CombinationSum;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		
		Solution solution = new Solution();
		
		List<List<Integer>> lists = solution.combinationSum(candidates, target);
		
		for(List<Integer> list : lists) {
			for(int num : list) {
				System.out.print(num+" ");
			}
			
			System.out.println();
		}
		
		
	}
}
class Solution {
    private static List<List<Integer>> lists;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>>lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        DFS(candidates,target,0,0,list,lists);
        return lists;
    }
    
    public void DFS(int[] candidates , int target,int depth,int start,List<Integer> list,List<List<Integer>>lists){
    	if(depth == target){
        	List<Integer> tempList = new ArrayList<>();
        	for(int num : list) {
        		tempList.add(num);
        	}
            lists.add(tempList);
        }else{
            for(int i = start; i < candidates.length; i++){
            	if(depth+candidates[i] <= target) {
            		list.add(candidates[i]);
                    DFS(candidates,target,depth+candidates[i],i,list,lists);
            		list.remove(list.size()-1);
            	}
            	
                
            }
        }
    }
}