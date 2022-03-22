import java.util.*;
public class ÀÚÀü°Å {
	public static void main(String[] args) {
		int[] numbers = {3, 7, 2, 8, 6, 4, 5, 1};
		int k = 3;
		Solution solution = new Solution();
		int min = solution.solution(numbers, k);
		System.out.println(min);
	}
}

class Solution{
	static int min = Integer.MAX_VALUE;
	public int solution(int[] numbers , int K) {
		min = Integer.MAX_VALUE;
		int answer = 0 ;
		
		int[] list = new int[numbers.length];
		boolean[] visit = new boolean[numbers.length];
		DFS(numbers,K,0,visit,list);
		if(min == Integer.MAX_VALUE) return -1;
		return min;
	}
	
	private void DFS(int[] numbers, int k , int depth, boolean[] visit, int[] list) {
		if(depth == numbers.length) {
			min = Math.min(min, checkValue(numbers,list,k));
		}else {
			for(int i = 0 ; i < numbers.length; i++) {
				if(!visit[i]) {
					visit[i] = true;
					list[depth] = numbers[i];
					DFS(numbers,k,depth+1,visit,list);
					list[depth]= 0;
					visit[i] = false;
				}
			}
		}
	}
	
	
}
