package SumRootToLeafNodes;
import java.util.ArrayList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class Solution {
    ArrayList<String> list=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        int num=0;
        for(int i=0; i<list.size(); i++){
            String temp=list.get(i);
            num+=Integer.parseInt(temp);
        }
        return num;
    }
    public void preorder(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        else{
            sb.append(root.val);
            if(root.left!=null){
                preorder(root.left,sb);
            }
            if(root.right!=null){
                preorder(root.right,sb);    
            }
            if(root.left==null&&root.right==null){
                list.add(sb.toString());
                sb.deleteCharAt(sb.length()-1);
                return;
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }
}