package 여행경로;
import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        HashMap<String,Boolean> visit=new HashMap<>();
        for(int i=0; i<tickets.length; i++){
            if(map.containsKey(tickets[i][0])){
                ArrayList<String> list=map.get(tickets[i][0]);
                list.add(tickets[i][1]);
                map.put(tickets[i][0],list);
            }else{
                ArrayList<String> list=new ArrayList<>();
                list.add(tickets[i][1]);
                map.put(tickets[i][0],list);
            }
            visit.put(tickets[i][0],false);
            visit.put(tickets[i][1],false);
        }
        ArrayList<String> list=new ArrayList<>();
        DFS(0,map,"ICN",list,tickets.length,"ICN",visit);
        Collections.sort(list);
        answer=list.get(0).split(" ");
        return answer;
    }
    private void DFS(int count,HashMap<String,ArrayList<String>> map,String start,ArrayList<String> list,int length,String answer,HashMap<String,Boolean> visit){
        if(count==length){
            list.add(answer);
            return;
        }else{
            if(map.containsKey(start)){
                ArrayList<String> destination=map.get(start);
                for(int i=0; i<destination.size(); i++){
                	if(visit.containsKey(destination.get(i))&&!visit.get(destination.get(i))){
                		visit.put(destination.get(i),true);
                		DFS(count+1,map,destination.get(i),list,length,answer+" "+destination.get(i),visit);
                		visit.put(destination.get(i),false);
                    }
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
		
	}
}
