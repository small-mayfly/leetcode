package niuke.jianzhioffer;

/**
 * ƽ����������κ�һ���ڵ����������߶Ȳ����1�����������жϼ���
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
	 * �ӵ��������μ���ڵ����������ĸ߶ȣ�����߶Ȳ����1��ֱ�ӷ���false
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
