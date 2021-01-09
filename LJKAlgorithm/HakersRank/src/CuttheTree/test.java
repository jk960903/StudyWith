package CuttheTree;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
public class test {
	static int max=100001;
	static int min=Integer.MAX_VALUE;
	static boolean[] visit=new boolean[max];
	static ArrayList<Integer> tree[]=new ArrayList[max];
	static int[] data=new int[max];
	
	static int totalsum=0;
	static int dfs(int start) {
		System.out.print(start + " ");
		int sum=0;
		sum+=data[start-1];
		for(int i=0; i<tree[start].size(); i++) {
			int next=tree[start].get(i);
			if(visit[next]==false) {
				sum+=dfs(next);
			}
		}
		System.out.println(" ");
		int rest=totalsum-sum;
		int dif=sum>rest?sum-rest:rest-sum;
		if(min>dif)min=dif;
		return sum;
	}
	static int solve() {
		dfs(1);
		return min;
	}
	private static final Scanner scan=new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		//BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		int n=scan.nextInt();
		scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for(int i=0; i<n; i++) {
			data[i]=scan.nextInt();
			totalsum+=data[i];
			tree[i]=new ArrayList<Integer>();
		}
		tree[n]=new ArrayList<Integer>();
		int[][] edges=new int[n-1][2];
		for(int i=0; i<n-1; i++) {
			for(int j=0;j<2; j++) {
				edges[i][j]=scan.nextInt();
			}
		
			int p0=edges[i][0];
			int p1=edges[i][1];
			tree[p0].add(p1);
			tree[p1].add(p0);
		}
		int result=solve();
		System.out.println(result);
		//bufferedWriter.write(String.valueOf(result));
		//bufferedWriter.newLine();
		//bufferedWriter.close();
		scan.close();
	}
}
class Ascending implements Comparator<Integer>{
	@Override
	public int compare(Integer o1,Integer o2) {
		return o1.compareTo(o2);
	}
}
