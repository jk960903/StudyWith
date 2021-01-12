package 트리의순회;
import java.util.StringTokenizer;
import java.io.*;
public class Main {
	public static int[] preorder=new int[100001];
	public static int[] postorder=new int[100001];
	public static int[] inorder=new int[100001];
	public static int[] index=new int[100001];
	private static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=n; i++) {
			inorder[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=n; i++) {
			postorder[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			index[inorder[i]]=i;
		}
		preorder(0,n,0,n);
		System.out.println(sb);
	}
	public static void preorder(int in_begin,int in_end,int post_begin,int post_end) {
		if(in_begin>in_end||post_begin>post_end || post_end==0) return;
		int root=postorder[post_end];
		sb.append(root+" ");
		int inroot=index[root];
		int left=inroot-in_begin;
		preorder(in_begin,inroot-1,post_begin,post_begin+left-1);//좌
		preorder(inroot+1,in_end,post_begin+left,post_end-1);//우
	}
}
