package medium;

/**
 * 从左上角移动到右下角，每次移动一格，只能是向右或向下移动
 * @author mayfly
 *
 */
public class UniquePaths {
	/**
	 * 从1,1->m,n共需要走m+n-2步，其中有m-1向右走，n-1步向下走，故共有C_(M+N-2)^(N-1)种情况
	 * @param m 横坐标
	 * @param n 纵坐标
	 * @return 共多少种情况
	 */
	public int uniquePaths(int m, int n) {
		if(m==0 || n==0)   // 如果其中一个为0，说明有错误
			return 0;
		if(m==1 || n==1)   // 横纵坐标为1，则只能全部向右或只能向下走
			return 1;
		long result = 1;   // 记录结果，由于中间结果可能较大，所以用long类型
		int index = 2;   // 分母
		for(int i=0;i<n-1;i++) {   // 这里同时进行乘和除运算，原因很简单，对于过大的中间结果，long类型也无法承担，所以进行提前的消元操作
			result *= (i+m);   // 分子乘以
			while(index<n && result%index==0) {
				result /= index;   // 分母除
				index++;
			}
		}
		// 还没有计算的分母继续计算
		while(index<n && result%index==0) {
			result /= index;
			index++;
		}
		return (int)result;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(13,23));
	}

}
