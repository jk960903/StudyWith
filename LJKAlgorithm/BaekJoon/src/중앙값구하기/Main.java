package 중앙값구하기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int T = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int t = 0 ; t < T; t++) {
				
				int n = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				ArrayList<Integer> list = new ArrayList<>();
				sb.append((n+1) /2 +"\n");
				int count = 0 ;
				for(int i = 0 ; i < n ; i++) {
					if(i!= 0 && i % 10 == 0) {
						st = new StringTokenizer(br.readLine(), " ");
					}
					list.add(Integer.parseInt(st.nextToken()));
					if(list.size() % 2 == 1) {
						Collections.sort(list);
						sb.append(list.get(list.size()/2)+" ");
						count++;
						if(count % 10 == 0) {
							sb.deleteCharAt(sb.length()-1);
							sb.append("\n");
						}
					}
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append("\n");
				
			}
			
			System.out.println(sb.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
