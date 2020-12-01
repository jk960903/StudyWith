package Ʃ��;
import java.util.HashMap;
import java.util.ArrayList;
//https://programmers.co.kr/learn/courses/30/lessons/64065
//�����ִ� ������ �����ִ� ���� �Ǵ� � ������ ������ ��ҵ��� ������ Ʃ��(tuple)�̶�� �մϴ�. n���� ��Ҹ� ���� Ʃ���� n-Ʃ��(n-tuple)�̶�� �ϸ�, ������ ���� ǥ���� �� �ֽ��ϴ�.
public class Main {
	public static void main(String[] args) {
		String s="{{4,2,3},{3},{2,3,4,1},{2,3}}";//[3, 2, 4, 1]
		Solution solution=new Solution();
		int[] answer=solution.solution(s);
	}
	
}
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int max=0;
        s=s.substring(1,s.length()-1);
        HashMap<Integer,String[]> map=new HashMap<>(); 
        String[] element=s.split("}");
        for(int i=0; i<element.length; i++){
            element[i]=element[i].replace("{","");
            if(element[i].indexOf(",")==0){
                element[i]=element[i].substring(1);
            }
            String[] eachelement=element[i].split(",");
            map.put(eachelement.length,eachelement);
            if(eachelement.length>max){
                max=eachelement.length;
            }
        }
        boolean[] visit=new boolean[100000];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1; i<=max; i++){
            String[] elementeach=map.get(i);
            for(int j=0; j<elementeach.length; j++){
                int num=Integer.parseInt(elementeach[j]);
                if(!visit[num-1]){
                    visit[num-1]=true;
                    list.add(num);
                }
            }
        }
        answer=new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}
