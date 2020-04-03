package niuke.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class CongShangWangXiaDaYinShu {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> results = new ArrayList<>();
        if(root==null)
            return results;
        LinkedList<TreeNode> rems = new LinkedList<>();
        rems.addLast(root);
        results.add(root.val);
        while (!rems.isEmpty()){
            TreeNode treeNode = rems.removeFirst();
            if(treeNode.left!=null){
                rems.addLast(treeNode.left);
                results.add(treeNode.left.val);
            }
            if(treeNode.right!=null){
                rems.addLast(treeNode.right);
                results.add(treeNode.right.val);
            }
        }

        return results;

    }

    public static void main(String[] args) {

    }
}
