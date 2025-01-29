/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> hm = new HashMap<>();
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        postorderIndex = postorder.length-1;
        return helper(postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] postorder,int start,int end){
        if(start > end){
            return null;
        }
        int rootval = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootval);
        int inorderIndex = hm.get(rootval);
        root.right = helper(postorder,inorderIndex+1,end);
        root.left = helper(postorder,start,inorderIndex-1);
        return root;
    }
}