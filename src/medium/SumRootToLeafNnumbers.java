package medium;

public class SumRootToLeafNnumbers {
	
	public int cul(SRTLNTreeNode root, int nowVal) {
		int rem = nowVal*10+root.val;
		if(root.left!=null && root.right!=null) {
			return cul(root.left, rem) + cul(root.right, rem);
			
		}else if(root.left==null && root.right!=null) {
			return cul(root.right, rem);
		}else if(root.left!=null && root.right==null) {
			return cul(root.left, rem);
		}else {
			return rem;
		}
	}
	
	public int sumNumbers(SRTLNTreeNode root) {
		if(root==null) {
			return 0;
		}else {
			return cul(root, 0);
		}
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SRTLNTreeNode {
	int val;
	SRTLNTreeNode left;
	SRTLNTreeNode right;
	SRTLNTreeNode(int x) { val = x; }
}