package niuke.jianzhioffer;

import java.util.LinkedList;

public class Tqid11214 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 按照层级结构序列化二叉树，遇到子节点为空的情况序列化为#
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder result = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        // 遇到节点就入队列
        result.append(root.val);
        while (queue.size()>0){
            // 首先取出队列的头部
            TreeNode tnode = queue.removeFirst();

            // 然后将左右节点入队列
            if(tnode.left!=null){
                queue.addLast(tnode.left);
                result.append(","+tnode.left.val);
            }else{
                result.append(",#");
            }
            if(tnode.right!=null){
                queue.addLast(tnode.right);
                result.append(","+tnode.right.val);
            }else{
                result.append(",#");
            }
        }

        return result.toString();
    }
    // 按照层次结构反序列化字符串生成二叉树
    TreeNode Deserialize(String str) {
        if("".equals(str)){
            return null;
        }

        String[] datas = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int index = 1;
        while (index<datas.length){
            TreeNode tnode = queue.removeFirst();
            if(!"#".equals(datas[index])){
                TreeNode left = new TreeNode(Integer.parseInt(datas[index]));
                tnode.left = left;
                queue.addLast(left);
            }
            if(!"#".equals(datas[index+1])){
                TreeNode right = new TreeNode(Integer.parseInt(datas[index + 1]));
                tnode.right = right;
                queue.addLast(right);
            }
            index += 2;
        }
        return root;
    }


}
