package zhousai.doublecom.c21;

/**
 * 对于一个节点，首先判断它是不是二叉搜索树，如果不是则直接返回
 *  如果是叶子节点，返回当前节点的值
 *  如果是二叉搜索树，则将总和加上当前节点的值返回
 */
public class TopicFour {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // 用于记录全局的二叉搜索子树最大键值和
    int maxResult = 0;

    // 计算某一局部键值和是否大于当前已知的局部键值和，如果大于则由当前局部最大键值和暂时充当全局最大键值和
    public void culMax(int data){
        if(data>this.maxResult)
            this.maxResult = data;
    }

    /**
     * 返回结果数组
     * @param root
     * @return 是否是二叉搜索树，最小值，最大值，如果是二叉搜索树则返回集合
     */
    public int[] magic(TreeNode root){
        // 如果当前节点是空节点，则直接返回null
        if(root==null){
            return null;
        }
        // 首先计算左右子树
        int[] leftResults = magic(root.left);
        int[] rightResults = magic(root.right);
        // 如果当前节点是叶子节点，首先判断是否是最大键值和，然后构造一个返回结果，当前叶子节点自己构成一个二叉搜索树，最小值、最大值、二叉搜索树键值和都为当前值
        if(leftResults==null && rightResults==null){
            int[] results = {1, root.val, root.val, root.val};
            culMax(root.val);
            return results;
        }else if(leftResults==null && rightResults!=null){
            if(rightResults[0]==1){   // 如果右子树是二叉搜索树，且左子树为空
                if(rightResults[1]>root.val){   // 如果右子树的最小值大于当前值，说明结合本节点也是二叉搜索树
                    rightResults[1] = root.val;   // 则新的二叉搜索树的最小值为当前节点的值
                    rightResults[3] += root.val;   // 新的二叉搜索树的键值和加上当前节点的值
                    culMax(rightResults[3]);   // 更新局部最大二叉搜索树键值和
                    return rightResults;   // 向上返回局部
                }else{   // 构不成二叉搜索树
                    int[] results = {-1};   // 不直接返回null是为了区别于当前节点为空节点的情况
                    return results;
                }
            }else{
                int[] results = {-1};
                return results;
            }
        }else if(leftResults!=null && rightResults==null){
            if(leftResults[0]==1){   // 如果左子树是二叉搜索树，且右子树为空
                if(leftResults[2]<root.val){
                    leftResults[2] = root.val;
                    leftResults[3] += root.val;
                    culMax(leftResults[3]);
                    return leftResults;
                }else{   // 构不成二叉搜索树
                    int[] results = {-1};
                    return results;
                }
            }else{
                int[] results = {-1};
                return results;
            }
        }else{
            if(leftResults[0]==1 && rightResults[0]==1){   // 如果左右都不是空节点，则需要左右子树都是二叉搜索树
                if(leftResults[2]<root.val && rightResults[1]>root.val){   // 并且左子树的最大值小于当前节点值，右子树的最小值大于当前节点值
                    leftResults[2] = rightResults[2];   // 如果条件都满足，则更新二叉搜索树键值和
                    leftResults[3] += rightResults[3];
                    leftResults[3] += root.val;
                    culMax(leftResults[3]);
                    return leftResults;

                }else{
                    int[] results = {-1};
                    return results;
                }
            }else{
                int[] results = {-1};
                return results;
            }

        }
    }

    public int maxSumBST(TreeNode root) {
        magic(root);
        return this.maxResult;
    }

}
