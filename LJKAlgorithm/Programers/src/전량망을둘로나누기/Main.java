package 전량망을둘로나누기;
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer>[] lists=new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            lists[i]=new ArrayList<Integer>();
        }
        for(int i= 0; i<wires.length; i++){
            lists[wires[i][0]].add(wires[i][1]);
            lists[wires[i][1]].add(wires[i][0]);
        }
        for(int i = 0 ; i<wires.length; i++){
            boolean[] visit = new boolean[n+1];
            visit[wires[i][0]]=true;
            visit[wires[i][1]]=true;
            Queue<Integer> queue1 = new LinkedList<>();
            Queue<Integer> queue2= new LinkedList<>();
            queue1.add(wires[i][0]);
            queue2.add(wires[i][1]);
            int queue1size=0;
            int queue2size=0;
            while(!queue1.isEmpty()){
                int num=queue1.poll();
                queue1size++;
                
                for(int j=0; j<lists[num].size(); j++){
                    if(!visit[lists[num].get(j)]){
                        visit[lists[num].get(j)]=true;
                        queue1.add(lists[num].get(j));
                    }
                }
            }
            while(!queue2.isEmpty()){
                int num =queue2.poll();
                queue2size++;
                
                for(int j=0; j<lists[num].size(); j++){
                    if(!visit[lists[num].get(j)]){
                        visit[lists[num].get(j)]=true;
                        queue2.add(lists[num].get(j));
                    }
                }
            }
            min = Math.min(min,Math.abs(queue1size-queue2size));
            
            
        }
        return min;
    }
}
public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n =9;
		int[][] wires={{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		
		int result = solution.solution(n, wires);
		System.out.println(result);
	}
}
