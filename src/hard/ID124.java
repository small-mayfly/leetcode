package hard;

/**
 * 深搜，然后回朔
 * 之所以使用magic函数，是因为，返回值需要是单条路径的最大值，而maxpath可能需要用到两条子路线，所以和maxPathSum函数有些许差别
 */
public class ID124 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxPath = Integer.MIN_VALUE;

    public int magic(TreeNode root){
        if(root==null){
            return 0;
        }else if(root.left==null && root.right==null){
            if(root.val>maxPath){
                maxPath = root.val;
            }
            return root.val;

        }
        int left = magic(root.left);
        int right = magic(root.right);
        if(left<0){
            left = 0;
        }
        if(right<0){
            right = 0;
        }

        int val = left+right+root.val;
        if(val>maxPath){
            maxPath = val;
        }
        val = left>right?left:right;
        val += root.val;
        if(val>maxPath){
            maxPath = val;
        }
        return val;

    }

    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }else if(root.left==null && root.right==null){
            return root.val;
        }
        int left = magic(root.left);
        int right = magic(root.right);
        if(left<0){
            left = 0;
        }
        if(right<0){
            right = 0;
        }
        int val = left+right+root.val;
        if(val>maxPath){
            maxPath = val;
        }
        return maxPath;


    }
}