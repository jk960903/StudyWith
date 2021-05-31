package TEST;
import java.util.*;
import sort.Sort ;
public class Test {
	public static void main(String[] args) {
		int[] array = {1,4,2,6,5,3,9,7,8,10};
		Sort sort = new Sort() ;
		int[] temp = new int[array.length];
		int[] result = sort.mergeSort(array, 0, array.length-1, temp);
		for(int i = 0 ; i < temp.length; i++) {
			System.out.println(result[i]);
		}
	}
}
class Solution {
    static boolean[] visit;
    public int solution(String numbers) {
        int answer = 0;
        ArrayList<String> list=new ArrayList<>();
        list.add("1");
        list.add("@");
        list.add("3");
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
        System.out.println(list.size());
        list.remove("1");
        answer=list.size();
        for(int i=0; i<list.size(); i++) {
        	System.out.println(list.get(i));
        }
        return answer;
    }
    public void dfs(int length,int depth,String num){
        if(length==depth){
            
        }else{
            for(int i=0; i<length; i++){
                
            }
        }
    }
    public int solution1(String s) {
    	int answer=0;
    	for(int i=0; i<s.length(); i++) {
    		answer+=Find(s,i,i+1);
    		answer+=Find(s,i,i);
    	}
    	return answer;
    }
    public int Find(String s,int i,int j) {
    	int answer=0;
    	while(i>=0 && j<s.length() && i<=j) {
    		if(s.charAt(i) == s.charAt(j)) {
    			answer++;
    			i--;
    			j++;
    		}else {
    			break;
    		}
    	}
    	return answer;
    }
}
