package niuke.jianzhioffer;

import java.util.LinkedList;

public class NIUKE11191 {
	
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	/**
	 * 使用先进先出的队列，来依次判断即可
	 * @param root
	 * @return
	 */
	public int TreeDepth(TreeNode root) {
        if(root==null)
        	return 0;
        
        LinkedList<TreeNode> rems = new LinkedList<TreeNode>();
        int depth = 0;
        root.val = 1;
        rems.add(root);
        TreeNode temp;
		while(rems.size()>0) {
			temp = rems.removeFirst();
			if(temp.left!=null) {
				temp.left.val = temp.val+1;
				rems.add(temp.left);
			}
			if(temp.right!=null){
				temp.right.val = temp.val+1;
				rems.add(temp.right);
			}
			if(temp.val>depth)
				depth = temp.val;
		}
        
		return depth;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
