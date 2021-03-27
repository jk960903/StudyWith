package TEST;
import java.util.*;
public class Test {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		/*queue.add(5);
		queue.add(3);
		queue.add(2);
		queue.add(1);
		queue.add(8);
		queue.add(4);
		queue.remove(3);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}*/
		/*ArrayList<Integer> list=new ArrayList<>();
        boolean[] prime=new boolean[10000001];
        prime[0]=true;
        prime[1]=true;
        int count=0;
        for(int i=2; i*i<10000000; i++){
            for(int j=i*i; j<10000000; j+=i){
            	if(!prime[j]) {
            		count++;
            		prime[j]=true;
            	}
            	
            }
        }
        System.out.println(count);*/
		Solution s=new Solution();
		String numbers="17";
		System.out.println(s.solution(numbers));
        
	}
}
class Solution {
    static boolean[] visit;
    public int solution(String numbers) {
        int answer = 0;
        ArrayList<Integer> list=new ArrayList<>();
        
        int[] num=new int[10];
        int size=1;
        for(int i=0; i<numbers.length(); i++){
            num[numbers.charAt(i)-'0']++;
            size*=10;
        }
        boolean[] prime=new boolean[size+1];
        prime[0]=true;
        prime[1]=true;
        for(int i=2; i*i<size; i++){
            for(int j=i*i; j<size; j+=i){
                prime[j]=true;
            }
        }
        String num1="";
        num1=num1+numbers.charAt(0);
        StringBuilder sb=new StringBuilder();
        sb.le
        
        
        
        
        return answer;
    }
    public void dfs(int length,int depth,String num){
        if(length==depth){
            
        }else{
            for(int i=0; i<length; i++){
                
            }
        }
    }
}
