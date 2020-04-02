package niuke.jianzhioffer;

import java.util.LinkedList;

/**
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5
 * 二叉搜索树与双向链表
 * 首先按照中序遍历将二叉搜索树获取顺序序列，并将treenode按照顺序存到list中
 * 接着依次向后遍历list，即可获得结果
 */
public class BianrySearchTreeAndDoubleDirectList {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void sortList(TreeNode root, LinkedList<TreeNode> rem){
        if(root==null)
            return;
        else{
            if(root.left!=null){
                sortList(root.left, rem);
            }
            rem.addLast(root);
            if(root.right!=null){
                sortList(root.right, rem);
            }
        }
    }


    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        // 获取有序node
        LinkedList<TreeNode> rem = new LinkedList<>();
        sortList(pRootOfTree, rem);
        // 遍历list，重新生成指针
        if(rem.size()==1){
            return rem.getFirst();
        }else{
            TreeNode start = rem.getFirst();
            TreeNode point;
            for(int i=1;i<rem.size();i++){
                point = rem.get(i);
                start.right = point;
                point.left = start;
                start = point;
            }
        }

        return rem.getFirst();
    }
}
