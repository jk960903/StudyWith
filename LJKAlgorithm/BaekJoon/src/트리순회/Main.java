package 트리순회;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		TreeNode root;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		root=new TreeNode(st.nextToken(),st.nextToken(),st.nextToken());
		for(int i=1; i<n; i++) {
			st=new StringTokenizer(br.readLine()," ");
			String temp1=st.nextToken();
			String temp2=st.nextToken();
			String temp3=st.nextToken();
			TreeNode node=root.getNode(temp1, root);
			if(!temp2.equals(".")) {
				node.left=new TreeNode(temp2);
				
			}
			if(!temp3.equals(".")) {
				node.right=new TreeNode(temp3);
			}
		}
		Preorder(root);
		System.out.println(sb);
		sb=new StringBuilder();
		Inorder(root);
		System.out.println(sb);
		sb=new StringBuilder();
		Postorder(root);
		System.out.println(sb);
		return;
	}
	public static void Preorder(TreeNode next) {
		if(next!=null) {
			sb.append(next.value);
			Preorder(next.left);
			Preorder(next.right);
		}
	}
	public static void Inorder(TreeNode next) {
		if(next!=null) {
			Inorder(next.left);
			sb.append(next.value);
			Inorder(next.right);
		}
	}
	public static void Postorder(TreeNode next) {
		if(next!=null) {
			Postorder(next.left);
			Postorder(next.right);
			sb.append(next.value);
		}
	}
}

class TreeNode{
	String value;
	TreeNode left;
	TreeNode right;
	public TreeNode(String node){
		if(node.equals(".")) return;
		this.value=node;
		this.left=null;
		this.right=null;
	}
	public TreeNode(String node,String left,String right) {
		this.value=node;
		if(!left.equals(".")) {
			this.left=new TreeNode(left);
		}else {
			this.left=null;
		}
		if(!right.equals(".")) {
			this.right=new TreeNode(right);
		}else {
			this.right=null;
		}
		
	}
	public TreeNode getNode(String node,TreeNode next) {
		TreeNode temp=next;
		TreeNode result=null;
		if(temp!=null) {
			if(temp.value.equals(node)) {
				result=next; 
				return result;
			}
			result=getNode(node,temp.left);
			if(result!=null) {
				return result;
			}
			result=getNode(node,temp.right);
			if(result!=null) {
				return result;
			}
			
			
		}
		return result;
	}
}
