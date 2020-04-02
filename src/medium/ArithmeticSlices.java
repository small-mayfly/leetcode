package medium;

public class ArithmeticSlices {
	/**
	 * 当长度不足为3的时候一定不存在算数列。所以计算从第三个数开始算起。
	 * 对于一个算数列，长度为3、4、5都是，所以可能会出现添加一个数字多了好多种的情况
	 * @param A
	 * @return
	 */
	public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3)
        	return 0;
        
        int len = 2;
        int dis = A[1] - A[0];
        int nowDis;
        int result = 0;
        for(int i=2;i<A.length;i++) {
        	nowDis = A[i]-A[i-1];   // 计算当前数字与前一个数字的差
        	if(nowDis==dis) {   // 如果数字和之前的数字相等，则开始计算
        		len++;   // 算上当前数字，当前数列一共有几个数了
        		result += (len-2);   // 将数组中新计算出来的算数列个数加到结果中
        	}else {   // 之前的数字对之后的没有影响，所以可以从头开始计算了
        		len = 2;
        		dis = nowDis;
        	}
        }
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas = {1, 3, 5, 7};
		System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(datas));
	}

}
