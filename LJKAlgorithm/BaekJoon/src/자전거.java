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
	
	private int checkValue(int[] numbers, int[] list, int k) {
		boolean check = true;
		int count = Integer.MAX_VALUE;
		for(int i = 1; i < list.length; i++) {
			if(Math.abs(list[i] - list[i-1]) > k) {
				check = false;
				break;
			}
		}
		if(check) {
			count = 0 ; 
			boolean[] array = new boolean[numbers.length];
			int[] tempArray = new int[numbers.length];
			for(int i = 0 ; i < list.length; i++) {
				tempArray[i] = numbers[i];
				if(list[i] == numbers[i]) {
					array[i] = true;
				}
			}
			for(int i = 0 ; i <numbers.length; i++) {
				if(!array[i]) {
					for(int j = 0 ; j < list.length; j++) {
						if(tempArray[i] == list[j]) {
							int temp = tempArray[i];
							tempArray[i] = tempArray[j];
							tempArray[j] = temp;
							array[i] = true;
							if(tempArray[j] == list[j]) {
								array[j] = true;
							}
							count++;
						}
					}
				}
			}
		}
		return count;
	}
}
