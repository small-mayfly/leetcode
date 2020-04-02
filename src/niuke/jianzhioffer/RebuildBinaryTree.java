package niuke.jianzhioffer;

public class RebuildBinaryTree {
	/**
	 * ֪��������������+���������������+�������˳�����ɶ�����
	 * �����������������������ɶ�����
	 * @param pre �����������
	 * @param in �����������
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		
		return magic(pre, in, 0, pre.length-1, 0, in.length-1);
	}
	// �ݹ����ɶ�����
	public TreeNode magic(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
		// ���endС��pre˵�������е㶼�Ѿ��������ˣ�����
		if(preEnd-preStart<0)
			return null;
		// ���ɵ�ǰ�ڵ�
		TreeNode tn = new TreeNode(pre[preStart]);
		// ���������ҵ��������������λ�ã���������Ϊ�������ĵ㣬�ұ�Ϊ�������ĵ�
		int flag = 0;
		for(flag=0;flag<pre.length;flag++) {
			if(pre[preStart]==in[(inStart+flag)])
				break;
		}
		// ���ɵ�ǰ���������
		tn.left = magic(pre, in, preStart+1, preStart+flag, inStart, inStart+flag-1);
		// ���ɵ�ǰ���������
		tn.right = magic(pre, in, preStart+flag+1, preEnd, inStart+flag+1, inEnd);
		// ���ɵ�ǰ�㼰��������ϣ����ص�ǰ��
		return tn;
	}
	// �������
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