package 카드정렬하기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Long> queue = new PriorityQueue<>();
			for(int i = 0 ; i < n; i++) {
				queue.add(Long.parseLong(br.readLine()));
			}
			long result = 0 ;
			long count = 0;
			long temp = 0;
			while(!queue.isEmpty()) {
				long num = queue.poll();
				if(count==0) {
					count++;
					temp += num;
				}else if(count==1) {
					count++;
					temp += num;
					result += temp;
					queue.add(temp);
					temp = 0;
					count = 0;
				}
			}
			System.out.println(result);
		}catch(Exception e) {
			
		}
		
	}
}
