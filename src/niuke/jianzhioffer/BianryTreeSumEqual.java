package niuke.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class BianryTreeSumEqual {
	
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	// 进行递归的计算，主要是要注意链表引用在递归的深入和返回时要进行修改
	public void magic(TreeNode root, int target, ArrayList<Integer> nowPath, ArrayList<ArrayList<Integer>> results){
		if(root==null) {
			return;
		}
		if(root.val>target) {
			return;
		}else if(root.val<target) {
			nowPath.add(root.val);
			magic(root.left, target-root.val, nowPath, results);
			magic(root.right, target-root.val, nowPath, results);
			nowPath.remove(nowPath.size()-1);
		}else {
			if(root.left==null && root.right==null) {
				ArrayList<Integer> result = new ArrayList<Integer>();
				for (Integer integer : nowPath) {
					result.add(integer);
				}
				result.add(root.val);
				
				results.add(result);
			}
		}
	}
	// 首先进行初步判断，将不需要计算的结果直接返回
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(root==null) {
			return results;
		}
		if(root.val>target) {
			return results;
		}else {
			ArrayList<Integer> tnowPath = new ArrayList<Integer>();
//			tnowPath.add(root.val);
			magic(root, target, tnowPath, results);
			return results;
		}
		
		
    }
	
	public TreeNode generalTree(int[] datas) {
		LinkedList<TreeNode> tree = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(datas[0]);
		tree.add(root);
		int flag = 0;
		for(int i=1;i<datas.length;i++) {
			TreeNode temp = new TreeNode(datas[i]);
			if(flag==0) {
				tree.getFirst().left = temp;
			}else {
				TreeNode top = tree.removeFirst();
				top.right = temp;
			}
			flag = 1 - flag;
			tree.addLast(temp);
		}
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas = {10,5,12,4,7};
		int target = 22;
		BianryTreeSumEqual b = new BianryTreeSumEqual();
		ArrayList<ArrayList<Integer>> results = b.FindPath(b.generalTree(datas), target);
		System.out.println("");
	}

}
