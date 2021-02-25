package 요세푸스문제;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		Solution solution=new Solution();
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		List<Integer> list=solution.solution(n, k);
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i));
			sb.append(", ");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append(">");
		System.out.println(sb.toString());
	}
}
class Solution{
	public List<Integer> solution(int n,int k){
		ArrayList<Integer> list=new ArrayList<>();
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		while(!queue.isEmpty()) {
			for(int i=0; i<k-1; i++) {
				int a=queue.poll();
				queue.add(a);
			}
			int delete=queue.poll();
			list.add(delete);
		}
		return list;
	}
}
