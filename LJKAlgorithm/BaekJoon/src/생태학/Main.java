package ปýลยวะ;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		int total=0;
		try {
			String input = br.readLine();
			while(true) {
				
				if(map.containsKey(input)) {
					map.put(input,map.get(input)+1);
				}else {
					map.put(input,1);
					list.add(input);
				}
				total++;
				input = br.readLine();
				if(input==null || input.length()==0) {
					break;
				}
			}
			Collections.sort(list);
			for(int i = 0; i<list.size(); i++) {
				int num = map.get(list.get(i));
				double percent = (double)num*100.0/(double)total;
				System.out.printf(list.get(i)+" %.4f\n",percent);
			}
			br.close();
		}catch(Exception e) {
			
		}
		
		
	}
}
