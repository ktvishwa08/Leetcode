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
    int preI=0;
    public TreeNode FormTree(int[] preorder,int[] inorder,int left, int right,HashMap<Integer,Integer> map){
        if(right<left)
        return null;
        TreeNode root=new TreeNode(preorder[preI]);
        preI++;
        int mid=map.get(root.val);
        root.left=FormTree(preorder,inorder,left,mid-1,map);
        root.right=FormTree(preorder,inorder,mid+1,right,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=preorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=FormTree(preorder,inorder,0,n-1,map);
        return root;
    }
}