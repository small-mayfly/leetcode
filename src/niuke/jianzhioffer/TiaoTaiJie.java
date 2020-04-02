package niuke.jianzhioffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author mayfly
 *
 */
public class TiaoTaiJie {
	/**
	 * 思路类似计算斐波那契数列 f_n = f_(n-1) + f_(n-2),f_(n-1)跳一格+f_(n-2)跳两格
	 * @param target
	 * @return
	 */
	public int JumpFloor(int n) {
		if(n==1) {   // 第一项为1
			return 1;
		}else if(n==2) {   // 第二项是2
			return 2;
		}else {   // 之后依次向后遍历
			int start = 3;   // 此时n>=3，所以从3开始遍历
			int rem1 = 1;   // 第一项
			int rem2 = 2;   // 第二项
			int result = 0;   // 初始化结果
			while(start<=n) {
				result = rem1 + rem2;   // 计算第k项结果
				rem1 = rem2;   // 更新k-1项
				rem2 = result;   // 更新k项结果
				start++;   // 更新k
			}
			return result;   // 循环计算出结果，返回
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
