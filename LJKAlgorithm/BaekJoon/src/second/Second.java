package second;
import java.io.*;
import java.util.PriorityQueue;
import java.util.*;
class Solution {
    public String[] solution(String[] arr, String[] processes) {
        String[] answer = {};
        List<Process> read = new ArrayList<>();
        List<Process> write = new ArrayList<>();
        for(int i = 0 ; i < processes.length; i++){
            String[] temp = processes[i].split(" ");
            if(temp[0].equals("read")){
                String type = temp[0];
                int t1 = Integer.parseInt(temp[1]);
                int t2 = Integer.parseInt(temp[2]);
                int a = Integer.parseInt(temp[3]);
                int b = Integer.parseInt(temp[4]);
                read.add(new Process(type,t1,t2,a,b,-1));
            }else{
                String type = temp[0];
                int t1 = Integer.parseInt(temp[1]);
                int t2 = Integer.parseInt(temp[2]);
                int a = Integer.parseInt(temp[3]);
                int b = Integer.parseInt(temp[4]);
                int c = Integer.parseInt(temp[5]);
                write.add(new Process(type,t1,t2,a,b,c));
            }
        }
        int time = 0 ;
        int usetime = 0;
        int readindex = 0 ;
        int writeindex = 0 ;
        int index = 0;
        int count = 0;
        List<String> list = new ArrayList<>();
        Queue<Process> runningQueue = new LinkedList<>();
        Queue<Process> readReadyQueue = new LinkedList<>();
        Queue<Process> writeReadyQueue = new LinkedList<>();
        while(true){
        	if(!runningQueue.isEmpty()) {
        		Process p = runningQueue.peek();
        		usetime++;
        		if(p.t2 == time) {
        			if(p.type.equals("write")) {
        				for(int i = p.a1; i<= p.a2; i++) {
        					arr[i] = Integer.toString(p.c);
        				}
        			}else {
        				StringBuilder sb = new StringBuilder();
        				for(int i = p.a1; i<= p.a2; i++) {
        					sb.append(arr[i]);
        				}
        				list.add(sb.toString());
        			}
        			runningQueue.poll();
        			count++;
        			if(count == processes.length) {
        				break;
        			}
        			continue;
        		}
        	}
            
            if(writeindex < write.size() && time == write.get(writeindex).t1){
            	Process p = write.get(writeindex);
                if(runningQueue.isEmpty()){
                    runningQueue.add(new Process(p.type,p.t1,p.t1+p.t2,p.a1,p.a2,p.c));
                }else{
                    writeReadyQueue.add(new Process(p.type,p.t1,p.t2,p.a1,p.a2,p.c));
                }
                writeindex++;
            }
            if(readindex <read.size() && time == read.get(readindex).t1){
            	Process p = read.get(readindex);
                if(runningQueue.isEmpty() && writeReadyQueue.isEmpty()){
                    runningQueue.add(new Process(p.type,p.t1,p.t1+p.t2-1,p.a1,p.a2,-1));
                }else if(writeReadyQueue.isEmpty() && runningQueue.peek().type.equals("read")){
                    runningQueue.add(new Process(p.type,p.t1,p.t1+p.t2-1,p.a1,p.a2,-1));
                }else if(!writeReadyQueue.isEmpty() && !runningQueue.isEmpty() && !runningQueue.peek().type.equals("read")
                    ){
                        //running중인 큐가 read이나 대기상태 write가 먼저 와있음 -> 대기큐에 넣어야함
                    readReadyQueue.add(new Process(p.type,p.t1,p.t2,p.a1,p.a2,-1));
                }else if(!writeReadyQueue.isEmpty() && !runningQueue.isEmpty() && runningQueue.peek().type.equals("read")){
                    //running중인 큐가 read이나 대기상태 write가 먼저 와있음 -> 대기큐에 넣어야함
                	readReadyQueue.add(new Process(p.type,p.t1,p.t2,p.a1,p.a2,-1));
                }else if(writeReadyQueue.isEmpty() && !runningQueue.isEmpty() && !runningQueue.peek().type.equals("read")){
                    //running중인 큐가 read이나 대기상태 write가 먼저 와있음 -> 대기큐에 넣어야함
                	readReadyQueue.add(new Process(p.type,p.t1,p.t2,p.a1,p.a2,-1));
                }
                readindex++;
            }
            if(runningQueue.isEmpty()){//실행은 없으나 대기상태는 있을때
                if(writeReadyQueue.isEmpty()) {
                	while(!readReadyQueue.isEmpty()) {
                		Process p = readReadyQueue.poll();
                		runningQueue.add(new Process(p.type,time+1,time+p.t2,p.a1,p.a2,p.c));
                	}
                	
                }else {
                	Process p = writeReadyQueue.poll();
                	runningQueue.add(new Process(p.type,time+1,time+p.t2,p.a1,p.a2,p.c));
                }
            }
            time++;
        }
        list.add(Integer.toString(usetime-1));
        answer = new String[list.size()];
        for(int i = 0 ; i <list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}
public class Second {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.peek();
		Solution solution = new Solution();
		String[] arr = {"1","1","1","1","1","1","1"};
		String[] processes = {"write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5","write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5"};
		String[] answer = solution.solution(arr, processes);
		for(int i = 0 ; i <answer.length; i ++) {
			System.out.println(answer[i]);
		}
	}
}


class Process{
	String type;
	int t1;
	int t2;
	int a1;
	int a2;
	int c;

    public Process(String type, int t1, int t2, int a1, int a2,int c){
        this.type = type;
        this.t1 = t1;
        this.t2 =t2;
        this.a1 = a1;
        this.a2 = a2;
        this.c = c;
    }

	
}
