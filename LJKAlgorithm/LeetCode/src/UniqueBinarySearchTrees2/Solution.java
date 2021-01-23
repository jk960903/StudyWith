package UniqueBinarySearchTrees2;
import java.util.List;
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        
        return Solution(1,n);
    }
    private List<TreeNode> Solution(int m,int n){
        List<TreeNode> list=new ArrayList<>();
        if(m>n){
            list.add(null);
            return list;
        }
        for(int i=m; i<=n; i++){
            List<TreeNode> leftTree=Solution(m,i-1);
            List<TreeNode> rightTree=Solution(i+1,n);
            for(TreeNode leftNode : leftTree){
                for(TreeNode rightNode: rightTree){
                    TreeNode temp=new TreeNode(i);
                    temp.left=leftNode;
                    temp.right=rightNode;
                    list.add(temp);
                }
            }
        }
        return list;
    }
}