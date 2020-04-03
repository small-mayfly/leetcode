package niuke.jianzhioffer;

/**
 * 判断树是否对称，只需要判断是否以中轴线对称，即左子树的左结点和右子树的右结点相比，依次递归判断
 */
public class Tqid11211 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public boolean magic(TreeNode left, TreeNode right){
        // 首先判断当前结点是否为空
        if(left==null && right==null)   // 全为空则对称
            return true;
        if(left==null || right==null)   // 其中一个为空则非对称
            return false;
        // 先判断左右结点值是否相等，如果不相等则非对称，如果相等则继续判断子树
        boolean flag = false;
        if(left.val==right.val)
            flag = magic(left.left, right.right) && magic(left.right, right.left);
        else{
            flag = false;
        }
        return flag;

    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        // 空数直接返回true
        if(pRoot==null)
            return true;
        // 非空树则依次判断左右子树
        return magic(pRoot.left, pRoot.right);
    }

    public static void main(String[] args) {
        System.out.println("aaa");
    }


}
