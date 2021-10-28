package 크게만들기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		Solution solution = new Solution();
		System.out.println(solution.solution(s, k));
	}
}
class Solution{
	public String solution(String num,int k) {
		StringBuilder sb=new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int count=0;
		stack.push(num.charAt(0));
		for(int i = 1 ; i<num.length(); i++) {
			char temp = num.charAt(i);
			while(!stack.isEmpty()&&stack.lastElement() < temp && count<k) {
				stack.pop();
				count++;
				if(count == k) break;
			}
			stack.push(temp);
		}
		int size = stack.size();
		if(count<k) {
			int gap = k - count;
			for(int i = 0 ; i< size - gap; i++) {
				sb.append(stack.get(i));
			}
		}
		else {
			for(int i = 0 ; i<size; i++) {
				sb.append(stack.get(i));
			}
		}
		
		return sb.toString();
	}
}
