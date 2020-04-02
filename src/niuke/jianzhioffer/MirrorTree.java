package niuke.jianzhioffer;

public class MirrorTree {
	
	public void Mirror(TreeNodee root) {
        if(root==null)
        	return;
        else {
        	TreeNodee temp;
        	temp = root.left;
        	root.left = root.right;
        	root.right = temp;
        	Mirror(root.left);
        	Mirror(root.right);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNodee {
    int val = 0;
    TreeNodee left = null;
    TreeNodee right = null;

    public TreeNodee(int val) {
        this.val = val;

    }

}