package ¿ÏÀüÅ½»ö;
import java.util.ArrayList;
class Solution {
    static boolean[] visit;
    static boolean[] prime;
    static int count=0;
    public int solution(String numbers) {
        int answer = 0;
        ArrayList<Integer> list=new ArrayList<>();
        
        int[] num=new int[10];
        int size=1;
        for(int i=0; i<numbers.length(); i++){
            num[numbers.charAt(i)-'0']++;
            size*=10;
        }
        prime=new boolean[size+1];
        prime[0]=true;
        prime[1]=true;
        for(int i=2; i*i<size; i++){
            for(int j=i*i; j<size; j+=i){
                prime[j]=true;
            }
        }
        for(int i=1; i<=numbers.length(); i++){
            visit=new boolean[numbers.length()];
            StringBuilder sb=new StringBuilder();
            dfs(i,0,sb,numbers);
        }
        answer=count;
        
        
        
        return answer;
    }
    public void dfs(int length,int depth,StringBuilder sb,String number){
        if(length==depth){
            int answer=Integer.parseInt(sb.toString());
            if(!prime[answer]){
                prime[answer]=true;
                count++;
            }
        }else{
            for(int i=0; i<number.length(); i++){
                if(!visit[i]){
                    sb.append(number.charAt(i));
                    visit[i]=true;
                    dfs(length,depth+1,sb,number);
                    sb.deleteCharAt(sb.length()-1);
                    visit[i]=false;
                }
            }
        }
    }
}
public class Main {

}
