package 메뉴리뉴얼;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        HashMap<String,Integer> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0; i<orders.length; i++){
            char[] temp=orders[i].toCharArray();
            Arrays.sort(temp);
            for(int j=0; j<course.length; j++){
                if(temp.length<course[j]) break;
                int[] index=new int[course[j]];
                DFS(map,set,temp,index,course[j],0,0);
            }
        }
        int[] max=new int[course.length];
        for(int i=0; i<course.length; i++){
            for(String s : set){
                if(s.length()==course[i]){
                    int num=map.get(s);
                    max[i]=Math.max(max[i],num);
                }
            }    
        }
        ArrayList<String> list=new ArrayList<>();
        for(int i=0; i<max.length; i++){
            int tempmax=max[i];
            if(tempmax==1) continue;
            for(String s: set){
                if(course[i]==s.length()&&tempmax==map.get(s)){
                    list.add(s);
                }
            }
        }
        answer=new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void DFS(HashMap<String,Integer> map,HashSet<String> set,char[] array,int[] index,int course,int start,int depth){
        if(depth==course){
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<index.length; i++){
                sb.append(array[index[i]]);
            }
            if(map.containsKey(sb.toString())){
                int num=map.get(sb.toString());
                map.put(sb.toString(),num+1);
            }else{
                set.add(sb.toString());
                map.put(sb.toString(),1);
            }
        }else{
            for(int i=start; i<array.length; i++){
                index[depth]=i;
                DFS(map,set,array,index,course,i+1,depth+1);
            }
        }
    }
    public static void main(String[] args) {
    	String[] orders= {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
    	int[] course= {2,3,5};
    	String[] answer=solution(orders,course);
    	for(int i=0; i<answer.length; i++) {
    		System.out.println(answer[i]);
    	}
    }
}