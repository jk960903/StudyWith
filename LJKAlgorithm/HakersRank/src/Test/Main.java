package Test;

import java.util.Arrays;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		int N=1000000;
		long num=1;
		boolean[] prime=new boolean[N+1];
        Arrays.fill(prime,true);
        for(int i = 2 ; i*i<=N; i+=1){
            for(int j= i*i; j<=N; j+=i){
                prime[j]=false;
            }   
        }
		for(int i=1; i<=N; i++) {
			num=num*i*i%1000007;
		}
		ArrayList<Integer> list=new ArrayList<>();
		HashMap<Integer,Integer> map=new HashMap<>();
		HashSet<Integer> set=new HashSet<>();
		for(int i=2; i<prime.length; i++) {
			if(prime[i]) {
				list.add(i);
				set.add(i);
				map.put(i,0);
			}
		}
		for(int i=0; i<list.size(); i++) {
			int divide=list.get(i);
			while(num % divide ==0) {
				num /=divide;
				map.put(divide,map.get(divide)+1);
				if(num <list.get(i)) break;
			}
		}
		int answer=1;
		for(int temp : set) {
			int prime1 = map.get(temp);
			if(prime1 == 0) break;
			answer=answer*(prime1+1) % 1000007;
		}
		System.out.println(answer);
	}
}
