package 이진검색트리;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Tree root=new Tree(Integer.parseInt(br.readLine()));
		String read=null;
		while((read=br.readLine())!=null&&read.length()!=0) {
			root.AddNode(Integer.parseInt(read));
		}
		root.PostOrder(root);
		System.out.println(root.sb);
	}
}
class Tree{
	int num;
	Tree left;
	Tree right;
	StringBuilder sb=new StringBuilder();
	protected Tree(int x) {
		this.num=x;
		this.left=null;
		this.right=null;
	}
	protected void AddNode(int x) {
		Tree temp=this;
		while(temp!=null) {
			if(x<temp.num) {
				if(temp.left==null) {
					temp.left=new Tree(x);
					break;
				}
				temp=temp.left;
			}else {
				if(temp.right==null) {
					temp.right=new Tree(x);
					break;
				}
				temp=temp.right;
			}
		}
	}
	protected void PostOrder(Tree node) {
		if(node.left!=null) PostOrder(node.left);
		if(node.right!=null)PostOrder(node.right);
		if(node!=null)sb.append(Integer.toString(node.num)+"\n");
		
	}
}
