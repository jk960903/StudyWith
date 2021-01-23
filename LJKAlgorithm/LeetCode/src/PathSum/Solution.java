package PathSum;
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        DFS(result,list,targetSum,0,root);
        return result;
    }
    private void DFS(List<List<Integer>> result,ArrayList<Integer> list,int targetSum,int nowSum,TreeNode root){
        if(root==null){
            return;
        }
        else{
            nowSum+=root.val;
            list.add(root.val);
            if(root.left!=null){
                DFS(result,list,targetSum,nowSum,root.left);    
            }
            if(root.right!=null){
                DFS(result,list,targetSum,nowSum,root.right);
            }
            if(root.left==null&&root.right==null&&nowSum==targetSum){
                ArrayList<Integer> newlist=new ArrayList<>();
                for(int i=0; i<list.size(); i++){
                    newlist.add(list.get(i));
                }
                result.add(newlist);
            }
            list.remove(list.size()-1);
        }
        return;
    }
}