package medium;
/**
 * 实现pow函数
 * @author mayfly
 *
 */
public class Pow_x_n {
	/**
	 * 将n使用以2为底的多项式表示
	 * @param n
	 * @return 多项式指数组成的数组
	 */
	public int[] getNum(long n) {
		int[] result = new int[33];   // 多项式最多有32项
		for(int i=0;i<33;i++)   // 初始化多项式
			result[i]=0;
		int index = 32;   // 初始化索引
		long t;   // 记录临时变量
		while(n>0) {
			t = (1L<<index);   // 获取多项式第index项的的大小
			if(n>=t) {   
				result[index] = 1;
				n -= t;
			}
			index-=1;
		}
		return result;
	}
	/**
	 * 计算
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if(x==0)   // 如果x==0，直接返回0即可
			return 0.0;
		else if(x==1 || n==0)   // 如果x==1，获取这n==0，结果一定是1
			return 1.0;
		else if(Math.abs(n)==1) {   
			if(n==1)   // 如果n==1，则结果是其本身
				return x;
			else   // n==-1，结果是其倒数
				return 1/x;
		}
		else {
			long nn = (long)n;   // 处理n=-2^31的情况，防止取绝对值之后溢出
			if(n<0) {
				x = 1/x;
				nn *= -1;
			}
			int flag = 1;   // 标记结果是正数还是负数
			if(x<0 && nn%2==1) {
				flag = -1;
			}
			x = Math.abs(x);
			int[] front = getNum(nn);   // 获取以2为底的多项式表示方式
			
			double result = 1.0;
			
			for(int i=0;i<33;i++) {
				if(front[i]==1) {   // 如果用多项式表示n用到当前索引的项，则将其加入结果中
					result *= x;
				}
				x = x*x;
			}
			if(flag==-1)
				result *= -1;
			return result;
		}
        
    }
	/**
	 * 第二种方法，是第一种方法的优化，不需要先计算多项式表示，在遍历到的时候直接进行计算，类似于
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow2(double x, int n) {
		if(x==0)
			return 0.0;
		else if(x==1 || n==0)
			return 1.0;
		else if(Math.abs(n)==1) {
			if(n==1)
				return x;
			else
				return 1/x;
		}
		else {
			// 使用类似多项式的方式计算比如n=13=(2*(2*(2*1+1)))+1
			if(n%2==0) {   
				double tx = myPow2(x, n/2);
				return tx*tx;
			}else {
				double tx = myPow2(x, n-1);
				return x*tx;
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow_x_n pxn = new Pow_x_n();
		double x = 2;
		int n = 13;
		System.out.println(pxn.myPow(x, n));
		System.out.println(pxn.myPow2(x, n));

	}

}
