package ��������ؿ�;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> min = new PriorityQueue<>();
			PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			
			for(int i = 0 ; i < n; i++) {
				int a = Integer.parseInt(br.readLine());
				
				if(max.size() == min.size()) {
					max.add(a);
					
					if(!min.isEmpty() && max.peek() > min.peek()) {
						min.add(max.poll());
						max.add(min.poll());
					}
				}else {
					min.add(a);
					
					if(max.peek() > min.peek()) {
						min.add(max.poll());
						max.add(min.poll());
					}
				}
				
				System.out.println(max.peek());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
