package test;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		String[] id_list= {"con", "ryan"};
		String[] report= {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;
		int[] fees = {180, 5000, 10, 600};
		String[] records= {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		Solution solution = new Solution();
		//int[] result = solution.solution(id_list,report,k);
		//int[] result = solution.solution(fees, records);
		//for(int i = 0; i<result.length; i++) {
		//	System.out.print(result[i]+" ");
		//}
		/*HashSet set=getPrime();
		for(int i = 1000000; i>=1; i--) {
			for(int j=2; j<10; j++) {
				solution.solution(i, j,set);
			}
		}*/
		int[] info={0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges={{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		System.out.println(solution.solution(info, edges));
	}
	public static HashSet<Integer> getPrime(){
        boolean[] prime = new boolean[5000001];
        HashSet<Integer> set = new HashSet<>();
        prime[0]=true;
        prime[1]=true;
        for(int i = 2; (i*i)<prime.length; i++){
            for(int j =i*i; j <prime.length; j+=i){
                prime[j]=true;
            }
        }
        for(int i = 2; i<prime.length; i++){
            if(!prime[i]) set.add(i);
        }
        return set;
        
    }
}
class Solution {
    /*public int[] solution(String[] id_list, String[] report, int k) {
    	int[] answer = {};
        //신고당한사람 , 신고한사람 list
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        //신고당한사람 , 신고당한 수
        HashMap<String,Integer> countmap=new HashMap<>();
        HashMap<String,Integer> user=new HashMap<>();
        HashSet<String> duple =new HashSet<>();
        int[] result= new int[id_list.length];
        for(int i = 0; i<id_list.length; i++){
            countmap.put(id_list[i],0);
            map.put(id_list[i],new ArrayList<>());
            set.add(id_list[i]);
            user.put(id_list[i],i);
        }
        for(int i = 0; i<report.length; i++){
        	if(duple.contains(report[i])) {
        		continue;
        	}
        	duple.add(report[i]);
            String[] split= report[i].split(" ");
            int num = countmap.get(split[1]);
            
            ArrayList<String> tempList=map.get(split[1]);
            tempList.add(split[0]);
            map.put(split[1],tempList);
            countmap.put(split[1],num+1);
        }
        for(String id : set){
            int num = countmap.get(id);
            if(num >=k){
                ArrayList<String> tempList = map.get(id);
                for(String reporter : tempList){
                    int userId = user.get(reporter);
                    result[userId]++;
                }
            }
        }
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
        return answer;
    }
	public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String,Integer> map=new HashMap<>();
        HashSet<String> set= new HashSet<>();
        HashSet<String> remainCar = new HashSet<>();
        for(int i = 0; i <records.length; i++){
            String[] split = records[i].split(" ");
            String[] splitTime=split[0].split(":");
            int time = Integer.parseInt(splitTime[0])*60 + Integer.parseInt(splitTime[1]);
            String carNum = split[1];
            set.add(carNum);
            if(!map.containsKey(carNum)){
                map.put(carNum,0);
            }
            if(split[2].equals("IN")){
                int num = map.get(carNum);
                map.put(carNum,time-num);
                remainCar.add(carNum);
            }else{
                int num = map.get(carNum);
                map.put(carNum,time-num);
                remainCar.remove(carNum);
            }
        }
        String[] carNums = new String[set.size()];
        answer= new int[carNums.length];
        int index=0;
        for(String carNum: set) {
        	carNums[index]=carNum;
        	index++;
        }
        Arrays.sort(carNums);
        for(int i = 0 ; i< carNums.length; i++){
        	int num;
        	if(remainCar.contains(carNums[i])) {
        		num=1439-map.get(carNums[i]);
        	}else {
        		num = map.get(carNums[i]);
        	}
            
            if(num <= fees[0]){
                answer[i]=fees[1];
            }else{
            	
                int remain = (int)Math.ceil((double)(num-fees[0])/fees[2]);
                answer[i] = fees[1]+remain*fees[3];
            }
        }
        return answer;
    }*/
	/*public int solution(int n, int k,HashSet<Integer> primeSet) {
        int answer = 0;
        String jinsu = conversion(n,k);
        StringBuilder sb = new StringBuilder();
        //HashSet<Integer> primeSet = getPrime();
        for(int i =0; i<jinsu.length(); i++){
            int num = jinsu.charAt(i)-'0';
            if(num !=0){
                sb.append(num);
            }else{
                if(sb.length()>0){
                    long nums =Long.parseLong(sb.toString());
                    if(primeSet.contains(nums)){
                        if(i-sb.length()-1==-1){//P0
                            answer++;
                        }else if(i-sb.length()-1>=0){//0p0
                            answer++;
                        }
                    }
                    sb=new StringBuilder();
                }
            }
        }
        if(sb.length()>0){
            long nums = Long.parseLong(sb.toString());
            if(primeSet.contains(nums)){//0p인경우
                answer++;
            }
        }
        return answer;
    }
    public String conversion(int n, int k){
        StringBuilder sb= new StringBuilder();
        while(n>0){
            sb.append(n%k);
            n/=k;
        }
        return sb.reverse().toString();
    }
    /*public HashSet<Integer> getPrime(){
        boolean[] prime = new boolean[5000001];
        HashSet<Integer> set = new HashSet<>();
        prime[0]=true;
        prime[1]=true;
        for(int i = 2; (i*i)<prime.length; i++){
            for(int j =i*i; j <prime.length; j+=i){
                prime[j]=true;
            }
        }
        for(int i = 2; i<prime.length; i++){
            if(!prime[i]) set.add(i);
        }
        return set;
        
    }*/
	public int solution(int[] info, int[][] edges) {
        //canmove -> 고려하지않고 움직일수있는곳 
        //move -> 
        int max=1;
        int[][] move = new int[info.length][info.length];
        PriorityQueue<dot> queue=new PriorityQueue<>();
        for(int i = 0; i<edges.length; i++){
            move[edges[i][0]][edges[i][1]]=1;
        }
        for(int i = 0 ; i<move[0].length; i++){
        	if(move[0][i]==1) {
        		dot d = new dot(i,info[i]);
        		queue.add(new dot(i,info[i]));//node i 번째에 동물 +1점 토탈 1마리
        	}
            
        }
        int now=1;
        int total=1;
        while(!queue.isEmpty()) {
        	dot d= queue.poll();
        	
        	if(d.type==0) {
        		now+=1;
        		total+=1;
        		max=Math.max(max, total);
        		for(int i =0; i<move[d.node].length; i++) {
        			if(move[d.node][i]==1) {
        				queue.add(new dot(i,info[i]));
        			}
        		}
        	}else {
        		if(now-1==0) {
        			queue.add(d);
        			continue;
        		}else {
        			now--;
        			for(int i=0; i<move[d.node].length; i++) {
        				if(move[d.node][i]==1) {
            				queue.add(new dot(i,info[i]));
            			}
        			}
        		}
        	}
        }
        
        return max;
    }
    
}
class dot implements Comparable<dot>{
    int node;
    int type;
    int level;
    
    public dot(int node,int type){
        this.node=node;
        this.type=type;
    }
    
    @Override
    public int compareTo(dot d){
        if(this.type <d.type){
            return -1;
        }else{
            return 1;
        }
    }
}
