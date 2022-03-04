package 단어정렬;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Set<String>[] sets = new HashSet[51];
		
		for(int i = 0 ; i <= 50; i++) {
			sets[i] = new HashSet<>();
		}
		
		for(int i = 0 ; i < n ; i++) {
			String s = br.readLine();
			
			sets[s.length()].add(s);
		}
		
		for(int i = 0; i <= 50; i ++) {
			List<String> list = new ArrayList<>();
			
			for(String s : sets[i]) {
				list.add(s);
			}
			Collections.sort(list);
			for(String s: list) {
				System.out.println(s);
			}
		}
		
		
	}
}
