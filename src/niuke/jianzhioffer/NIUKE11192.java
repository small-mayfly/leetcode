package niuke.jianzhioffer;

/**
 * 平衡二叉树的任何一个节点左右子树高度差不超过1，所以依次判断即可
 * @author mayfly
 *
 */
public class NIUKE11192 {
	
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	/**
	 * 从底向上依次计算节点左右子树的高度，如果高度差大于1，直接返回false
	 * @param root
	 * @return
	 */
	public int writeHeight(TreeNode root) {
		
		if(root==null)
			return 0;
		
		int leftHeight = writeHeight(root.left);
		if(leftHeight==-1)
			return -1;
		int rightHeight = writeHeight(root.right);
		if(rightHeight==-1)
			return -1;
		if(Math.abs(leftHeight-rightHeight)>1){
			return -1;
		}
		root.val = Math.max(leftHeight, rightHeight) + 1;
		return root.val;
		
	}
	
	public boolean IsBalanced_Solution(TreeNode root) {
		if(writeHeight(root)==-1)
			return false;
		return true;
    }
	
	public TreeNode generalTree(char[] datas) {
		
		
		
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
