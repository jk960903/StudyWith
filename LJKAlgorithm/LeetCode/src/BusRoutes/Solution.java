package BusRoutes;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer,ArrayList<Integer>> stop=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> bus=new HashMap<>();
        int max=0;
        for(int i=0; i<routes.length; i++){
            int busnum=i+1;
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0; j<routes[i].length; j++){
                list.add(routes[i][j]);
                max=Math.max(routes[i][j],max);
                if(stop.containsKey(routes[i][j])){
                    ArrayList<Integer> buslist=stop.get(routes[i][j]);
                    buslist.add(busnum);
                    stop.put(routes[i][j],buslist);
                }else{
                    ArrayList<Integer> buslist=new ArrayList<>();
                    buslist.add(busnum);
                    stop.put(routes[i][j],buslist);
                }
            }
            
            bus.put(busnum,list);
        }
        boolean[] visit=new boolean[max+1];
        boolean[] rideline=new boolean[routes.length];
        visit[S]=true;
        Queue<Bus> queue=new LinkedList<>();
        queue.add(new Bus(S,0));
        int result=-1;
        while(!queue.isEmpty()){
            Bus tempstop=queue.poll();
            if(tempstop.stop==T){
                result=tempstop.time;
                break;
            }
            visit[tempstop.stop]=true;
            if(stop.containsKey(tempstop.stop)){
                ArrayList<Integer> busline=stop.get(tempstop.stop);
                for(int i=0; i<busline.size(); i++){
                    int busnum=busline.get(i);
                    if(rideline[busnum-1]) continue;
                    rideline[busnum-1]=true;
                    ArrayList<Integer> busroute=bus.get(busnum);
                    for(int j=0; j<busroute.size(); j++){
                        int linestop=busroute.get(j);
                        if(!visit[linestop]){
                            queue.add(new Bus(linestop,tempstop.time+1));
                            visit[linestop]=true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
class Bus{
    int stop;
    int time;
    protected Bus(int stop,int time){
        this.stop=stop;
        this.time=time;
    }
}