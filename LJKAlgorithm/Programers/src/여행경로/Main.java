package 여행경로;
import java.util.*;
class Solution {
	boolean[] visit;
	ArrayList<String> answers;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visit = new boolean[tickets.length];
        answers = new ArrayList<String>();
        int count = 0 ;
        DFS(count,"ICN","ICN",tickets);
        Collections.sort(answers);
        answer= answers.get(0).split(" ");
        return answer;
    }
    private void DFS(int count,String start , String answer,String[][] tickets){
        if(count==tickets.length){
            answers.add(answer);
            return;
        }else{
        	for(int i = 0 ; i<tickets.length; i++) {
        		if(!visit[i]&& tickets[i][0].equals(start)) {
        			visit[i]=true;
        			DFS(count+1,tickets[i][1],answer+" "+tickets[i][1],tickets);
        			visit[i]=false;
        		}
        	}
        }
    }
}
public class Main {
	public static void main(String[] args) {
		Solution solution=new Solution();
		String[][] tickets={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] answer=solution.solution(tickets);
		for(int i = 0 ; i<answer.length; i++) {
			System.out.print(answer[i]);
		}
	}
}
