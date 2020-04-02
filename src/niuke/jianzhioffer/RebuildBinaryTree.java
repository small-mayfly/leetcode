package niuke.jianzhioffer;

public class RebuildBinaryTree {
	/**
	 * 知道二叉树的先序+中序遍历或者中序+后序遍历顺序生成二叉树
	 * 根据先序遍历，中序遍历生成二叉树
	 * @param pre 先序遍历数组
	 * @param in 中序遍历数组
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		
		return magic(pre, in, 0, pre.length-1, 0, in.length-1);
	}
	// 递归生成二叉树
	public TreeNode magic(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
		// 如果end小于pre说明，所有点都已经遍历过了，结束
		if(preEnd-preStart<0)
			return null;
		// 生成当前节点
		TreeNode tn = new TreeNode(pre[preStart]);
		// 根据先序，找到点在中序遍历的位置，中序点左边为左子树的点，右边为右子树的点
		int flag = 0;
		for(flag=0;flag<pre.length;flag++) {
			if(pre[preStart]==in[(inStart+flag)])
				break;
		}
		// 生成当前点的左子树
		tn.left = magic(pre, in, preStart+1, preStart+flag, inStart, inStart+flag-1);
		// 生成当前点的右子树
		tn.right = magic(pre, in, preStart+flag+1, preEnd, inStart+flag+1, inEnd);
		// 生成当前点及其子树完毕，返回当前点
		return tn;
	}
	// 先序输出
	public void printTree(TreeNode tn) {
		if(tn==null)
			return;
		System.out.println(tn.val);
		printTree(tn.left);
		printTree(tn.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {1,2,4,8,9,5,3,6,7};
		int[] in = {8,4,9,2,5,1,6,3,7};
		
		RebuildBinaryTree bbt = new RebuildBinaryTree();
		TreeNode result = bbt.reConstructBinaryTree(pre, in);
		bbt.printTree(result);
		System.out.println();
		
	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}