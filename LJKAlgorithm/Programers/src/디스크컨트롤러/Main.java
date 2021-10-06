package 디스크컨트롤러;
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //jobs를 입력시간 기준으로정렬(입력 시간 실행 시간 기준으로)
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0] -o2[0];
            }
        });
        
        //우선순위 큐
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        
        queue.add(jobs[0]);
        int end = jobs[0][0];
        int sum = 0 ; 
        int index = 1;
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            end += temp[1];
            sum += end - temp[0];
            
            //end 시간 이전에 있는 시작시간이 있는것을 queue에 넣기
            while(index < jobs.length && jobs[index][0] <= end){
                queue.add(jobs[index++]);
            }
            
            //queue가 비어있고 index가 끝나지 않았다면 
            if(index <jobs.length && queue.isEmpty()){
                end = jobs[index][0];
                queue.add(jobs[index++]);
            }
        }
        return sum/jobs.length;
    }
}
public class Main {

}
