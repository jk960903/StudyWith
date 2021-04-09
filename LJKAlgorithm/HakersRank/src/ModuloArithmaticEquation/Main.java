package ModuloArithmaticEquation;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		int N=1000000;
		int answer=1;
		long count=0;
        boolean[] prime=new boolean[N+1];
        Arrays.fill(prime,true);
        for(int i = 2 ; i*i<=N; i+=1){
            for(int j= i*i; j<=N; j+=i){
                prime[j]=false;
            }   
        }
        prime[0]=false;
        prime[1]=false;
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=2; i<prime.length; i++){
            if(prime[i]){
                list.add(i);
            }
        }
        Maps[] maps=new Maps[N+1];
        for(int i=2; i<=N; i++) {
        	maps[i]=new Maps();
        	int remain=i;
        	if(prime[i]) {
        		maps[i].map.put(i,1);
        		maps[i].set.add(i);
        		set.add(i);
        	}else {
        		for(int j=0; j<list.size(); j++) {
        			int divide=list.get(j);
        			if(remain < divide) break;
        			if( i % divide ==0) {
        				remain/=divide;
        				if(prime[i/divide]) {
        					int num=maps[i/divide].map.getOrDefault(i/divide, 0);
        					if(i==(i/divide)*(i/divide)) {
        						maps[i].map.put(i/divide,num+1);
        						maps[i].set.add(i/divide);
        						break;
        					}else {
        						maps[i].map.put(i/divide,num);
            					
        					}
        					maps[i].set.add(i/divide);
        					continue;
        				}else {
        					for(int num: maps[i/divide].set) {
        						int get=maps[i/divide].map.get(num);
        						maps[i].map.put(num,get);
        						maps[i].set.add(num);
        					}
        					int real=i/(i/divide);
        					int num=maps[i].map.getOrDefault(real, 0);
        					maps[i].set.add(real);
        					maps[i].map.put(real,num+1);
        					break;
        					
        				}
        				
        			}
        		}
        	}
        }
        long temp=1;
        for(int i=2; i<=N; i++) {
        	for(int num : maps[i].set) {
        		int get=maps[i].map.get(num);
        		int getmap=map.getOrDefault(num, 0);
        		map.put(num,get+getmap);
        	}
        }
        for(int num : set) {
        	int get=map.get(num)*2+1;
        	temp=get*temp%1000007;
        }
        answer=(int)temp;
		System.out.println(answer + " " +count);
	}
}
class Maps{
	HashMap<Integer,Integer> map;
	HashSet<Integer> set;
	public Maps() {
		this.map=new HashMap<>();
		this.set=new HashSet<>();
	}
}
