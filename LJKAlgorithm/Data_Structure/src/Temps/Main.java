package Temps;
import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int indexi = 0;
        int indexj = 1;
        int indexk = 0;
        boolean check = true;
        while(true){
            while(indexi != arr.length && indexj != arr.length){
                if(!check){
                    break;
                }
                check = false;
                if(indexj < arr.length && arr[indexj] > arr[indexj-1]){
                    check = true;
                    indexj++;
                }else{
                    if(indexk == 0){
                        check = true;
                        indexk = indexj;
                    }
                    if(indexk+1 < arr.length && arr[indexk] > arr[indexk+1]){
                        check = true;
                        indexk++;
                    }
                }
            }
            int increase = indexj - indexi;
            int decrease = indexk - indexj;
            answer += ((increase -1) * (decrease+1))% 100000007;
            indexi = indexk;
            indexj = indexi+1;
            indexk = indexj;
            check = true;
            if(indexi >= arr.length || indexk >= arr.length) {break;}
        }
        
        return answer;
    }
}
/*class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        boolean[] visit = new boolean[s.length()];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<s.length(); i++){
            if(!visit[i]){
                Queue<dot> queue = new LinkedList<>();
                queue.add(new dot(i,s.charAt(i)));
                visit[i] = true;
                int count = 1;
                while(!queue.isEmpty()){
                    dot d = queue.poll();
                    
                    if(d.index+1 < s.length() && s.charAt(d.index+1) == d.now && !visit[d.index+1]){
                        queue.add(new dot(d.index+1 , s.charAt(d.index+1)));
                        visit[d.index+1] = true;
                        count++;
                    }
                    
                    if(d.index - 1 < 0 ){
                        int temp = d.index = s.length()-1;
                        if(s.charAt(temp) == d.now && !visit[temp]){
                            queue.add(new dot(temp, s.charAt(temp)));
                            visit[temp] = true;
                            count++;
                        }
                    }
                    else if(d.index - 1 >= 0 && s.charAt(d.index-1) == d.now && !visit[d.index-1]){
                        queue.add(new dot(d.index-1, s.charAt(d.index-1)));
                        visit[d.index-1] = true;
                        count++;
                    }
                }
                list.add(count);
            }
        }
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public String solution(double time, String[][] plans) {
        String answer = "";
        for(int i = 0 ; i < plans.length; i++){
            String now = plans[i][0];
            double FriIn = 9.5;
            double FriOut = 18.0;
            double MonOut = 18.0;
            double MonIn = 13.0;
            double temptime = time;
            if(plans[i][1].contains("PM")){
                String[] Time = plans[i][1].split("PM");
                double start = Double.parseDouble(Time[0]);
                if((int)start == 12){
                    start = 0.0;
                }
                start += 12.0;
                
                if(FriOut > start ){ // 근무시간중 퇴근
                    double use = FriOut - start;
                    temptime -= use;
                }
            }else{
                String[] Time = plans[i][1].split("AM");
                double start = Double.parseDouble(Time[0]);
                if(start < FriIn){//출근 이전에 가야할경우
                    temptime-=8.5;
                }else{
                    double worktime = 18 - start;
                    temptime -= worktime;
                }
            }
            
            if(plans[i][2].contains("PM")){
                String[] Time = plans[i][2].split("PM");
                double arrive = Double.parseDouble(Time[0]);
                if(arrive >= 12.0){
                    arrive = 0;
                }
                arrive+=12.0;
                if(arrive > MonIn && arrive <=MonOut){
                    double use = arrive - MonIn;
                    temptime -=use;
                    
                }else if(arrive > MonOut){
                    temptime -= 5.0;
                }
            }// 도착시간이 AM일경우 고려하지 않아도됨
            if(temptime >=0){
                answer = now;
                time = temptime;
            }
        }
        return answer;
    }
}
class dot{
    int index;
    char now;
    
    public dot(int index, char now){
        this.index = index;
        this.now = now;
    }
}*/
public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] map = new int[1000000][1000000];
		//String s = "aaabbaaa";
		//int[] answer = solution.solution(s);
		//String[][] plans = 	{ {"홍콩", "12PM", "9AM"}, {"엘에이", "8PM", "12PM"}};
		//System.out.println(solution.solution(3.5, plans));
		//int[] arr = {1,2,1,2,1};
		//int answer = solution.solution(arr);
		//System.out.println(answer);
	}
}
