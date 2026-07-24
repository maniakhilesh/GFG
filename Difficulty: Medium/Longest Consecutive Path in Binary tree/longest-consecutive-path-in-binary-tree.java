/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    int solve(Node root,int c)
    {
        if(root==null)return 0;
         
        int l=0;
        int r=0;
        if(root.left!=null)
        {
            if(root.left.data==(root.data+1))l=solve(root.left,c+1);
            else l=solve(root.left,1);
        }
        if(root.right!=null)
        {
            if(root.right.data==(root.data+1))r=solve(root.right,c+1);
            else r=solve(root.right,1);
        }
        
        return Math.max(c,Math.max(l,r));
    }
    public int longestConsecutive(Node root) {
        // code here
        int ans=solve(root,1);
        return ans>1?ans:-1;
    }
}