import java.util.*;
public class AllElementsinTwoBinarySearchTrees {
	public static List<Integer> list;
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        if(root1 !=null){
            inorder(root1);
        }
        if(root2 !=null){
            inorder(root2);
        }
        Collections.sort(list);
        return list;
    }
    
    public void inorder(TreeNode node){
        list.add(node.val);
        if(node.left != null){
            inorder(node.left);
        }
        if(node.right!=null){
            inorder(node.right);
        }
    }
}
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