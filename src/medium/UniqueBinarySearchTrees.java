package medium;

public class UniqueBinarySearchTrees {
	
	
	public int numTrees(int n) {
        if(n<1) {   // 没有节点的时候，不存在二叉搜索树
        	return 0;
        }else if(n==1) {   // 只有一个节点
        	return  1;
        }else if(n==2) {   // 两个节点的时候，有两种二叉搜索树
        	return 2;
        }else {
        	// 用于记录有k个节点时，二叉搜索树有多少种邢台
        	int[] rem = new int[n+1];
        	rem[0] = 1;
        	rem[1] = 1;
        	rem[2] = 2;
        	// 依次向后迭代计算
        	for(int i=3;i<=n;i++) {
        		// 长度为n的数字，假设中间节点为第k个数，则左边有k-1个节点，右边有n-k个节点，所以左右各有rem[k-1] rem[n-k]种二叉搜索树形态
        		for(int j=1;j<=i;j++) {
        			rem[i] += (rem[j-1]*rem[i-j]);
        		}
        	}
        	return rem[n];
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UniqueBinarySearchTrees().numTrees(5));
	}

}
