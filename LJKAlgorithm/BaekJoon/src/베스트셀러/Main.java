package º£½ºÆ®¼¿·¯;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			Map<String,Integer> map = new HashMap<>();
			Set<String> set = new HashSet<>();
			for(int i = 0 ; i < n ; i++) {
				String s = br.readLine();
				if(map.containsKey(s)) {
					map.put(s,map.get(s)+1);
				}else {
					map.put(s,1);
					set.add(s);
				}
				
			}
			ArrayList<String> list = new ArrayList<>();
			int max = 0;
			for(String s : set) {
				int num = map.get(s);
				max = Math.max(num, max);
			}
			for(String s : set) {
				int num = map.get(s);
				if(num == max) {
					list.add(s);
				}
			}
			Collections.sort(list);
			System.out.println(list.get(0));
			
		}catch(Exception e) {
			
		}
	}
}
