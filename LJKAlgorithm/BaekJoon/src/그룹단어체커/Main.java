package 그룹단어체커;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int count = 0 ;
			for(int i = 0 ; i<n; i++) {
				String s = br.readLine();
				HashMap<Character,Integer> map = new HashMap<>();
				boolean check = true;
				for(int j = 0 ; j<s.length(); j++) {
					if(map.containsKey(s.charAt(j))){
						int index = map.get(s.charAt(j));
						if(j- index !=1) {
							check=false;
							break;
						}else {
							map.put(s.charAt(j),j);
						}
					}else {
						map.put(s.charAt(j),j);
						
					}
				
				}
				if(check) {
					count++;
				}
				
			}
			System.out.println(count);
			br.close();
		}catch(Exception e) {
			
		}
		
	}
}
