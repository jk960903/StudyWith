package µ¿Àü2;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] array=new int[n];
		int[] dp=new int[100001];
		Queue<Integer> queue=new LinkedList<>();
		for(int i=0; i<n; i++) {
			array[i]=Integer.parseInt(br.readLine());
			queue.add(array[i]);
			dp[array[i]]=1;
		}
		while(!queue.isEmpty()) {
			int now=queue.poll();
			for(int i=0; i<n; i++) {
				if(now+array[i]<=k) {
					if(dp[now+array[i]]==0) {
						dp[now+array[i]]=dp[now]+1;
						queue.add(now+array[i]);
					}
					if(now+array[i]==k) {
						break;
					}
					
				}
			}
		}
		if(dp[k]==0) {
			System.out.println(-1);
		}else {
			System.out.print(dp[k]);
		}	
			
		
		
		
	}
}
