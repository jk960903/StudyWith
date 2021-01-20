package ¹è´Þ;
import java.util.HashMap;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		String[][] roads={{"SEOUL","DAEJEON"},{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","ULSAN"},{"DAEJEON","BUSAN"},{"GWANGJU","BUSAN"}};
		HashMap<String,ArrayList<String>> tomap=new HashMap<>();
		HashMap<String,Integer> countmap=new HashMap<>();
		String start="ULSAN";
		String hub="SEOUL";
		String destination="BUSAN";
		countmap.put(destination,0);
		countmap.put(hub,0);
		for(int i=0; i<roads.length; i++) {
			String road1=roads[i][0];
			String road2=roads[i][1];
			if(tomap.containsKey(road1)) {
				ArrayList<String> list=tomap.get(road1);
				list.add(road2);
				tomap.put(road1,list);
			}else {
				ArrayList<String> list=new ArrayList<>();
				list.add(road2);
				tomap.put(road1,list);
			}
		}
		DFS(start,hub,tomap,countmap);
		int tohub=countmap.get(hub)%10007;
		if(tohub==0) System.out.println(-1);
		DFS(hub,destination,tomap,countmap);
		int todestination=countmap.get(destination)%10007;
		System.out.println(tohub*todestination);
	}
	private static void DFS(String start,String hub,HashMap<String,ArrayList<String>> map,HashMap<String,Integer> countmap){
		if(start.equals(hub)) {
			int num=countmap.get(start);
			countmap.put(hub,++num);
			return;
		}
		if(!map.containsKey(start))return;
		ArrayList<String> list=map.get(start);
		for(String next : list) {
			DFS(next,hub,map,countmap);
		}
	}
	
}
