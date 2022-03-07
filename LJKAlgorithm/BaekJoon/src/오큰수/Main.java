package ¿ÀÅ«¼ö;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] array = new int[n];
		
		for(int i = 0 ; i < n ; i ++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer= new int[n];
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for(int i = 1; i < n; i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			while(!stack.isEmpty() && array[stack.peek()] < array[i]) {
				answer[stack.pop()] = array[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.empty()) {
			answer[stack.pop()] = -1;
		}
		
		for(int i = 0 ; i < n; i++) {
			System.out.print(answer[i]+" ");
		}
		
		br.close();
		
		
		
		
	}
}
