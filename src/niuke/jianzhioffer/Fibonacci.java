package niuke.jianzhioffer;

/**
 * 求出斐波那契数列的第N项
 * @author mayfly
 *
 */
public class Fibonacci {
	public int fibonacci(int n) {
		if(n==1) {   // 第一项为1
			return 1;
		}else if(n==2) {   // 第二项也是1
			return 1;
		}else {   // 之后依次向后遍历
			int start = 3;   // 此时n>=3，所以从3开始遍历
			int rem1 = 1;   // 第一项
			int rem2 = 1;   // 第二项
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
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(4));
	}
}
