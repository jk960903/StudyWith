package ´õ¸Ê°Ô;
import java.util.*;
public class Solution {

}
class Solution1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            queue.add(scoville[i]);
        }
        while(queue.peek() <= K){
            if(queue.size() >= 2){
                int a=queue.poll();
                int b=queue.poll();
                if(a < K){
                    int sco=a+b*2;
                    queue.add(sco);
                    answer++;
                }else{
                    break;
                }
            }else{
                answer=-1;
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        
        return answer;
    }
}