package «¡∏∞≈Õ;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Solution solution=new Solution();
		int[] priorities= {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
		int location=0;
		int answer=solution.solution(priorities, location);
		System.out.println(answer);
	}
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<document> list=new LinkedList<>();
        int max=0;
        int[] wait=new int[9];
        for(int i=0; i<priorities.length; i++){
            list.add(new document(priorities[i],i));
            wait[priorities[i]-1]++;
        }
        for(int i=8; i>=0; i--){
            if(wait[i]!=0){
                max=i+1;
                break;
            } 
        }
        while(true){
            document paper=list.get(0);
            if(paper.priority<max){
                list.remove(0);
                list.addLast(paper);
            }else{
                answer++;
                if(paper.paper==location){
                    break;
                }
                wait[paper.priority-1]--;
                list.remove(0);
                if(wait[paper.priority-1]==0){
                    for(int i=paper.priority-1; i>=0; i--){
                        if(wait[i]!=0){
                            max=i+1;
                            break;
                        }
                    }
                }
                
            }
        }
        
        return answer;
    }
}
class document{
    int priority;
    int paper;
    document(int priority,int paper){
        this.priority=priority;
        this.paper=paper;
    }
}