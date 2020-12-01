package ��ɰ���;
//https://programmers.co.kr/learn/courses/30/lessons/42586
//�۾��� ���� progresses�� ���۾� ���� �ӵ��� ���� ���� �迭�� �־����� ��� ����� �����Ǵ���
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
	public static void main(String[] args) {
		int[] progresses={93, 30, 55};
		int[] speeds= {1, 30, 5};//	[2, 1]
		Solution s=new Solution();
		int[] answer=s.solution(progresses, speeds);
	}
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] work=new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            int remain=100-progresses[i];
            work[i]=remain/speeds[i];
            if(remain%speeds[i]!=0){
                work[i]+=1;
            }
            
        }
        ArrayList<Integer> list=new ArrayList<>();
        boolean[] visit=new boolean[work.length];
        for(int i=0; i<work.length; i++){
            Queue<Integer> queue=new LinkedList<>();
            if(!visit[i]){
                queue.add(work[i]);
                visit[i]=true;
            }
            for(int j=i+1; j<work.length; j++){
                if(work[j]<=work[i]&&!visit[j]){
                    queue.add(work[j]);
                    visit[j]=true;
                }else{
                    i=j-1;
                    break;
                }
            }
            if(queue.size()!=0)
                list.add(queue.size());
            
        }
        answer=new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i]=list.get(i);
        }
        return answer;
    }
}