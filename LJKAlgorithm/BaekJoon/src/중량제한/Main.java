package 중량제한;

import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			City[] cities = new City[n+1];
			//ArrayList<City>[] list = new ArrayList[n+1];
			for(int i = 1; i < cities.length; i++) {
				cities[i] = new City(i);
			}
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				int price = Integer.parseInt(st.nextToken());
				City city1 = cities[first];
				City city2 = cities[second];
				if(city1.map.containsKey(second)) {
					int tempprice = city1.map.get(second);
					city1.map.put(second,Math.max(price,tempprice));
				}else {
					city1.map.put(second,price);
					city1.set.add(second);
				}
				if(city2.map.containsKey(first)) {
					int tempprice = city2.map.get(first);
					city2.map.put(first,Math.max(tempprice, price));
				}else {
					city2.map.put(first,price);
					city2.set.add(first);
				}
			}
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			Queue<City> queue = new LinkedList<>();
			boolean[] visit = new boolean[n+1];
			queue.add(cities[start]);
			int max = 0 ;
			
			visit[start] = true;
			
			while(!queue.isEmpty()) {
				City city = queue.poll();
				
				
			}
		}catch(Exception e) {
			
		}
	}
}

class City{
	int num;
	HashMap<Integer,Integer> map;
	HashSet<Integer> set;
	
	public City(int num) {
		this.num = num;
		this.map = new HashMap<>();
		this.set = new HashSet<>();
	}
}
