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
    int PostI=0;
    public TreeNode FormTree(int[] preorder,int[] postorder,int left,int right,HashMap<Integer,Integer> map){
        if(left>right)
        return null;
        TreeNode root=new TreeNode(preorder[PostI]);
        PostI++;
        if (left==right) {
            return root;
        }
        int mid=map.get(preorder[PostI]);
        root.left=FormTree(preorder,postorder,left,mid,map);
        root.right=FormTree(preorder,postorder,mid+1,right-1,map);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=preorder.length;
        for(int i=0;i<n;i++){
            map.put(postorder[i],i);
        }
        TreeNode root=FormTree(preorder,postorder,0,n-1,map);
        return root;
    }
}