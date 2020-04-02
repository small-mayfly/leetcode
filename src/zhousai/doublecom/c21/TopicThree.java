package zhousai.doublecom.c21;

/**
 * 计算二叉树中最长的交错路径
 * 因为可能最长的交错路径并不是从根节点开始的，所以需要对每个节点分别遍历，所有节点遍历一遍即可得出结果
 */
public class TopicThree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // 用来记录最大交错长度
    int max = 0;

    public int magic(TreeNode root, int direct){
        if(root==null)
            return 0;
        // 获取当前节点的最大值
        int leftMax = magic(root.left, 0);
        int rightMax = magic(root.right, 1);
        int nowMax = leftMax>rightMax?leftMax:rightMax;
        // 如果当前节点的最长交错路径大于当前已知的最长交错路径，则覆盖原来的结果
        if(nowMax>this.max)
            this.max = nowMax;
        // 返回当前节点父节点的最长交错路径长度
        if(direct==0){
            return rightMax+1;
        }else{
            return leftMax+1;
        }
    }

    public int longestZigZag(TreeNode root) {
        if(root==null)
            return 0;
        // 对根节点，分别从左右子树出发进行判断
        int leftMax = magic(root.left, 0);
        int rightMax = magic(root.right, 1);
        int nowMax = leftMax>rightMax?leftMax:rightMax;

        if(nowMax>this.max)
            this.max = nowMax;
        // 返回全局最长交错路径长度
        return this.max;
    }
}
