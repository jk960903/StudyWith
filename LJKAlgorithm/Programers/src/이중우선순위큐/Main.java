package 이중우선순위큐;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Solution solution=new Solution();
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] result=solution.solution(operations);
		System.out.println(result[0]+" " +result[1]);
	}
}
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int [2];
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        int max=Integer.MAX_VALUE*-1;
        for(int i=0; i< operations.length; i++){
            String[] temp =operations[i].split(" ");
            if(temp[0].equals("I")){
            	max=Math.max(Integer.parseInt(temp[1]), max);
                queue.add(Integer.parseInt(temp[1]));
            }else{
                if(Integer.parseInt( temp[1] ) == -1){
                    if(!queue.isEmpty()){
                        queue.poll();
                    }else{
                        continue;
                    }
                }else if (Integer.parseInt( temp[1] ) == 1 ){
                    if(!queue.isEmpty()){
                        queue.remove(max);
                        max=Integer.MAX_VALUE*-1;
                    }else{
                        continue;
                    }
                }
            }
        }
        if(queue.isEmpty()){
            answer[0]=0;
            answer[1]=0;
            return answer;
        }
        if(queue.size() == 1){
            int num=queue.poll();
            if(num < 0){
                answer[1]=num;
            } 
            else if( num > 0 ){
                answer[0]=1;
            }
            return answer;
        }
        answer[1]=queue.poll();
        for(int i=0; i<queue.size()-1; i++){
            queue.poll();
        }
        answer[0]=queue.poll();
        return answer;
    }
}
