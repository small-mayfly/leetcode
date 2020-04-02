package zhousai.weeklycom.c180;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TopicThree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayList<TreeNode> nodes = new ArrayList<>();


    public TreeNode magic(ArrayList<TreeNode> nodes, int left, int right){
        if(right-left<0)
            return null;
        int mid = (int)Math.ceil((left+right)/2);
        TreeNode root = nodes.get(mid);
        root.left = magic(nodes, left, mid-1);
        root.right = magic(nodes, mid+1, right);
        return root;
    }


    public void searchTree(TreeNode root){
        if(root!=null){
            nodes.add(root);
            searchTree(root.left);
            searchTree(root.right);
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        if(root==null)
            return null;
        searchTree(root);
        Collections.sort(nodes, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val-o2.val;
            }
        });
        int nodeNum = nodes.size();
        root = magic(nodes, 0, nodeNum-1);
        return root;
    }

    public static void main(String[] args) {

    }
}
