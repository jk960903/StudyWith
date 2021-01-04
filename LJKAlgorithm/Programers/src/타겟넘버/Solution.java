package Å¸°Ù³Ñ¹ö;

public class Solution {
	public int solution(int[] numbers, int target) {
        int answer = DFS(numbers,target,numbers[0],1)+DFS(numbers,target,-numbers[0],1);
        return answer;
    }
    private int DFS(int[] numbers ,int target ,int sum,int depth){
        if(depth==numbers.length){
            if(sum==target){
                return 1;        
            }else{
                return 0;
            }
        }
        int result=0;
        result+=DFS(numbers,target,sum+numbers[depth],depth+1);
        result+=DFS(numbers,target,sum-numbers[depth],depth+1);
        return result;
        
    }
}
