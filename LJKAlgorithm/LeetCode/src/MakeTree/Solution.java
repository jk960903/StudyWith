package MakeTree;

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {//in /post
        int instart=0;
        int inend=inorder.length-1;
        int poststart=0;
        int postend=postorder.length-1;
        
        return BuildNode(instart,inend,poststart,postend,inorder,postorder);
    }
    private TreeNode BuildNode(int instart,int inend,int poststart,int postend,int[] inorder,int[] postorder){
        if(instart>inend||poststart>postend)return null;
        int rootvalue=postorder[postend];
        int rootindex=0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==rootvalue){
                rootindex=i;
                break;
            }
        }
        TreeNode root=new TreeNode(rootvalue);
        
        root.left=BuildNode(instart,rootindex-1,poststart,poststart+rootindex-instart-1,inorder,postorder);
        root.right=BuildNode(rootindex+1,inend,poststart+rootindex-instart,postend-1,inorder,postorder);
        
        return root;
    }
    public TreeNode buildTreePreorder(int[] preorder, int[] inorder) {
        int prestart=0;
        int preend=preorder.length-1;
        int instart=0;
        int inend=inorder.length-1;
        
        TreeNode root=BuildRoot(prestart,preend,instart,inend,preorder,inorder);
        
        return root;
        
    }
    private TreeNode BuildRoot(int prestart,int preend,int instart,int inend,int[] preorder,int[] inorder){
        if(prestart>preend||instart>inend)return null;
        int rootvalue=preorder[prestart];
        TreeNode root=new TreeNode(rootvalue);
        
        int rootindex=0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==rootvalue){
                rootindex=i;
            }
        }
        root.left=BuildRoot(prestart+1,preend-instart+rootindex,instart,rootindex-1,preorder,inorder);
        root.right=BuildRoot(rootindex+1+prestart-instart,preend,rootindex+1,inend,preorder,inorder);
        
        return root;
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
