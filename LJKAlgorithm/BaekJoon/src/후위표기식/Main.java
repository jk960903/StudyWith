package 후위표기식;
import java.io.*;
import java.util.Stack;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Stack<Character> stack=new Stack<>();
		char[] input=br.readLine().toCharArray();
		for(char c : input) {
			if(c>='A'&&c<='Z') {
				sb.append(c);
			}
			else if(c=='(') {
				stack.push('(');
			}
			else if(c==')') {
				while(!stack.isEmpty()) {
					char temp=stack.pop();
					if(temp=='(')break;
					sb.append(temp);
				}
			}else {
				while(!stack.isEmpty()&&rank(stack.peek())>=rank(c)){
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty()) sb.append(stack.pop());
		System.out.println(sb);
		
	}
	public static int rank(char c) {
		if(c=='(') return 0;
		else if(c=='+'||c=='-')return 1;
		else return 2;
	}
}
