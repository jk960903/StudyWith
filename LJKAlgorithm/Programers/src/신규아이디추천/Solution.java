package 신규아이디추천;
import java.util.LinkedList;
import java.util.Deque;
public class Solution {
    public static String solution(String new_id) {
    	String answer = new_id.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<answer.length(); i++){
            if((answer.charAt(i)>='a'&&answer.charAt(i)<='z')||(answer.charAt(i)>='0'&&answer.charAt(i)<='9')||
               answer.charAt(i)=='-'||answer.charAt(i)=='_'||answer.charAt(i)=='.')
                sb.append(answer.charAt(i));
        }
        answer=sb.toString();
        Deque<Character> deque=new LinkedList<>();
        deque.add(answer.charAt(0));
        for(int i=1; i<answer.length(); i++){
            if(deque.size()>0&&deque.getLast()=='.'&&answer.charAt(i)=='.'){
                continue;
            }
            else{
                deque.add(answer.charAt(i));
            }
        }
        if(!deque.isEmpty()&&deque.peek()=='.') deque.poll();
        if(!deque.isEmpty()&&deque.getLast()=='.')deque.removeLast();
        sb=new StringBuilder();
        int size=deque.size();
        for(int i=0; i<size; i++){
            sb.append(deque.poll());
        }
        answer=sb.toString();
        if(answer.length()==0) answer="a";
        else if(answer.length()>=16) answer=answer.substring(0,15);
        if(answer.charAt(answer.length()-1)=='.')answer=answer.substring(0,answer.length()-1);
        if(answer.length()<=2){
            char add=answer.charAt(answer.length()-1);
            while(answer.length()!=3){
                answer=answer.concat(Character.toString(add));
            }
        }
        return answer;
    }
    public static void main(String[] args) {
    	String new_id="abcdefghijklmn.p";
    	solution(new_id);
    }
}