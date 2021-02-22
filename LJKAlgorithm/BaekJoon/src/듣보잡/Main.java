package µË∫∏¿‚;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		String[] hear=new String[n];
		String[] see=new String[m];
		Solution solution=new Solution();
		for(int i=0; i<hear.length; i++) {
			hear[i]=br.readLine();
		}
		for(int i=0; i<see.length; i++) {
			see[i]=br.readLine();
		}
		
		List<String> answer=solution.solution(hear, see);
		System.out.println(answer.size());
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		br.close();
	}
}
class Solution{
	public List<String> solution(String[] hear,String[] see) {
		HashSet<String> set=new HashSet<>();
		ArrayList<String> list=new ArrayList<>();
		for(int i=0; i<hear.length; i++) {
			set.add(hear[i]);
		}
		for(int i=0; i<see.length; i++) {
			if(set.contains(see[i])) {
				list.add(see[i]);
			}
		}
		Collections.sort(list);
		return list;
	}
}
