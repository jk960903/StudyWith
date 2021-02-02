package 순위검색;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Queue;
public class Main {
	public static void main(String[] args) {
		Solution solution=new Solution();
		String[] info= {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
		String[] query= {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
		int[] answer=solution.solution(info, query);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        answer=new int[query.length];
        ArrayList<Integer>[] list=new ArrayList[24];
        for(int i=0; i<24; i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0; i<info.length; i++){
            String[] split=info[i].split(" ");
            int index=0;
            if(split[0].equals("java")){
                index=0;
            }else if(split[0].equals("cpp")){
                index=8;
            }else if(split[0].equals("python")){
                index=16;
            }
            if(split[1].equals("frontend")){
                index+=4;
            }
            if(split[2].equals("senior")){
                index+=2;
            }
            if(split[3].equals("chicken")){
                index+=1;
            }
            list[index].add(Integer.parseInt(split[4]));
        }
        for(int i=0; i<24; i++){
            Collections.sort(list[i]);
        }
        for(int i=0; i<query.length; i++){
            String[] split=query[i].split(" ");
            int index=0;
            Queue<Integer> queue=new LinkedList<>();
            if(split[0].equals("java")){
                queue.add(0);
            }else if(split[0].equals("cpp")){
                queue.add(8);
            }else if(split[0].equals("python")){
                queue.add(16);
            }else{
                queue.add(0);
                queue.add(8);
                queue.add(16);
            }
            if(split[2].equals("backend")){
                
            }else if(split[2].equals("frontend")){
                int size=queue.size();
                for(int j=0; j<size; j++){
                    int index1=queue.poll();
                    index1+=4;
                    queue.add(index1);
                }
            }else{
                int size=queue.size();
                for(int j=0; j<size; j++){
                    int index1=queue.poll();
                    queue.add(index1);
                    queue.add(index1+4);
                }
            }
            if(split[4].equals("junior")){
                
            }else if(split[4].equals("senior")){
                int size=queue.size();
                for(int j=0; j<size; j++){
                    int index1=queue.poll();
                    queue.add(index1+2);
                }
            }else{
                int size=queue.size();
                for(int j=0; j<size; j++){
                    int index1=queue.poll();
                    queue.add(index1);
                    queue.add(index1+2);
                }
            }
            if(split[6].equals("pizza")){
                
            }else if(split[6].equals("chicken")){
                int size=queue.size();
                for(int j=0; j<size; j++){
                    int index1=queue.poll();
                    queue.add(index1+1);
                }
            }else{
                int size=queue.size();
                for(int j=0; j<size; j++){
                    int index1=queue.poll();
                    queue.add(index1);
                    queue.add(index1+1);
                }
            }
            int find=Integer.parseInt(split[7]);
            int size=queue.size();
            int num=0;
            for(int j=0; j<size; j++){
                int index1=queue.poll();
                ArrayList<Integer> findlist=list[index1];
                int left=lowerBound(findlist,find);
                num+=findlist.size()-left;
            }
            answer[i]=num;
            
        }
        return answer;
    }
    private int lowerBound(ArrayList<Integer> list,int value) {
    	int left=0;
    	int right=list.size();
    	int mid=0;
    	while(left<right) {
    		mid=(left+right)/2;
    		if(value<=list.get(mid)) {
    			right=mid;
    		}else {
    			left=mid+1;
    		}
    	}
    	return left;
    }
}