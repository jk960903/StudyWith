package SameTree;
import java.util.Queue;
import java.util.LinkedList;

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
 

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null)return false;
        return Solution(p,q);
    }
    private boolean Solution(TreeNode p, TreeNode q){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        
        queue1.add(p);
        queue2.add(q);
        
        while(!queue1.isEmpty()){
            TreeNode a = queue1.poll();
            TreeNode b = queue2.poll();
            
            if(a.val == b.val){
                if(a.left!=null && b.left!=null){
                    queue1.add(a.left);
                    queue2.add(b.left);
                }
                if(a.left == null && b.left!=null) return false;
                else if(a.left!=null && b.left==null) return false;
                if(a.right!=null && b.right!=null){
                    queue1.add(a.right);
                    queue2.add(b.right);
                }
                if(a.right==null && b.right!=null) return false;
                else if(a.right !=null && b.right==null) return false;
            }else{
                return false;
            }
        }
        return true;
    }
}
