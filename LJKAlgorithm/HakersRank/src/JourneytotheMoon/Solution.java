package JourneytotheMoon;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Solution {
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int p=Integer.parseInt(st.nextToken());
		
		int[][] astronaut=new int[p][2];
		for(int i=0; i<p; i++) {
			st=new StringTokenizer(br.readLine()," ");
			astronaut[i][0]=Integer.parseInt(st.nextToken());
			astronaut[i][1]=Integer.parseInt(st.nextToken());
			
		}
		long answer=JourneyToMoon(n,astronaut);
		System.out.println(answer);
	}
	public static long JourneyToMoon(int n,int[][] astronaut) {
		int index=1;
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
		int country=0;
		int[] visit=new int[n];
		for(int i=0; i<astronaut.length; i++) {
			int a=astronaut[i][0];
			int b=astronaut[i][1];
			if(visit[a]==0&&visit[b]==0) {
				visit[a]=index;
				visit[b]=index;
				ArrayList<Integer> temp=new ArrayList<>();
				temp.add(a);
				temp.add(b);
				map.put(index,temp);
				index++;
				country++;
			}
			else if(visit[a]==0&&visit[b]!=0) {
				ArrayList<Integer> temp=map.get(visit[b]);
				temp.add(a);
				map.put(visit[b],temp);
				visit[a]=visit[b];
			}else if(visit[a]!=0&&visit[b]==0) {
				ArrayList<Integer> temp=map.get(visit[a]);
				temp.add(b);
				map.put(visit[a],temp);
				visit[b]=visit[a];
			}else if(visit[a]!=0&&visit[b]!=0) {
				ArrayList<Integer> temp1=map.get(visit[a]);
				ArrayList<Integer> temp2=map.get(visit[b]);
				if(temp1.equals(temp2)) continue;
				temp1.addAll(temp2);
				int change=temp1.get(0);
				int remove=visit[b];
				for(int num : temp2) {
					visit[num]=visit[change];
				}
				map.remove(remove);
				temp2.clear();
				list.remove(temp2);
			}
		}
		for(int i=0; i<n; i++) {
			if(visit[i]==0) {
				visit[i]=index;
				ArrayList<Integer> temp=new ArrayList<>();;
				temp.add(i);
				map.put(index,temp);
				visit[i]=index;
				index++;
			}
		}
		long answer=0;
		ArrayList<Integer> maplist=new ArrayList<>();
		ArrayList<Integer> onelist=new ArrayList<>();
		for(int i=1; i<index; i++) {
			if(map.containsKey(i)) {
				int num=map.get(i).size();
				if(num==1) {
					onelist.add(num);
					continue;
				}
				maplist.add(num);
			}else {
				continue;
			}
		}
		for(int i=0; i<maplist.size()-1; i++) {
			for(int j=i+1; j<maplist.size(); j++) {
				answer+=(maplist.get(i)*maplist.get(j));
			}
		}
		long onesize=onelist.size();
		for(int i=0; i<maplist.size(); i++) {
			answer+=(maplist.get(i)*onesize);
		}
		long answer1=onesize*(onesize-1);
		answer1/=2;
		answer=answer+answer1;
		return answer;
		
	}
}
