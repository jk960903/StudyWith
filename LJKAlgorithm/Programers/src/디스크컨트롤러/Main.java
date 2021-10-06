package ��ũ��Ʈ�ѷ�;
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //jobs�� �Է½ð� ������������(�Է� �ð� ���� �ð� ��������)
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0] -o2[0];
            }
        });
        
        //�켱���� ť
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
            
            //end �ð� ������ �ִ� ���۽ð��� �ִ°��� queue�� �ֱ�
            while(index < jobs.length && jobs[index][0] <= end){
                queue.add(jobs[index++]);
            }
            
            //queue�� ����ְ� index�� ������ �ʾҴٸ� 
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
