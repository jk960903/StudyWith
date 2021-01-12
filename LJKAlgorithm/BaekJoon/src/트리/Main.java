package Æ®¸®;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	private static StringBuilder sb;
	private static int[] preorder;
	private static int[] inorder;
	private static int[] index;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		for(int i=0; i<testcase; i++) {
			sb=new StringBuilder();
			int n=Integer.parseInt(br.readLine());
			preorder=new int[n+1];
			inorder=new int[n+1];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				preorder[j]=Integer.parseInt(st.nextToken());	
			}
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				inorder[j]=Integer.parseInt(st.nextToken());
			}
			
			PostOrder(0,n,0);
			System.out.println(sb);
		}
		
	}
	private static void PostOrder(int left,int end,int right) {
		for(int i=left; i<end; i++) {
			if(inorder[i]==preorder[right]) {
				PostOrder(left,i,right+1);
				PostOrder(i+1,end,right+i-left+1);
				sb.append(preorder[right]+" ");
			}
		}
	}
}
