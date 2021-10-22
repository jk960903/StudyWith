package N번째큰수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			
			for(int i = 0; i <n; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine()," ");
				for(int j = 0; j< n; j++) {
					queue.add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i = 0; i<n-1; i++) {
				queue.poll();
			}
			int answer =queue.poll();
			System.out.println(answer);
		}catch(Exception e) {
			
		}
		
	}
}
