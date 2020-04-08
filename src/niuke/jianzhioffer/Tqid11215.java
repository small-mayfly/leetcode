package niuke.jianzhioffer;

import java.util.LinkedList;

public class Tqid11215 {

    LinkedList<TreeNode> rem = new LinkedList<TreeNode>();

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void search(TreeNode root, int k){
        if(root==null){
            return;
        }
        if(rem.size()>=k){
            return;
        }
        search(root.left, k);
        rem.addLast(root);
        search(root.right, k);
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k==0)
            return null;
        search(pRoot, k);
        if(rem.size()>=k)
            return rem.get(k-1);
        else
            return null;
    }





}
