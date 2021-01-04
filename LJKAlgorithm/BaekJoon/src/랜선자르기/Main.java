package 랜선자르기;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int k=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		long[] line=new long[k];
		for(int i=0; i<k; i++) {
			line[i]=Integer.parseInt(br.readLine());
		}
		Arrays.parallelSort(line);
		long left=1;
		long right=line[line.length-1];
		long max=0;
		while(left<=right) {
			long mid=(left+right)/2;
			long result=0;
			for(int i=0; i<line.length; i++) {
				result+=(line[i]/mid);
			}
			if(result<n) {
				right=mid-1;
			}else {
				left=mid+1;
				max=Math.max(mid, max);
			}
		}
		System.out.println(max);
	}
}
