package ž;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] array=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		Stack<Integer> stack=new Stack<>();
		HashMap<Integer,Integer> map=new HashMap<>();
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<n; i++) {
			array[i]=Integer.parseInt(st.nextToken());
			map.put(array[i],i+1);
			if(stack.isEmpty()) {
				stack.add(array[i]);
				sb.append(0+" ");
			}else {
				while(!stack.isEmpty()) {
					int temp=stack.peek();
					if(temp<array[i]) {
						stack.pop();
					}else {
						int index=map.get(temp);
						map.put(array[i],i+1);
						sb.append(index+" ");
						stack.add(array[i]);
						break;
					}
				}
				if(stack.isEmpty()) {
					sb.append(0+" ");
					stack.add(array[i]);
				}
			}
		}
		System.out.println(sb);
	}
}
