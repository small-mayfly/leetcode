package medium;
/**
 * ʵ��pow����
 * @author mayfly
 *
 */
public class Pow_x_n {
	/**
	 * ��nʹ����2Ϊ�׵Ķ���ʽ��ʾ
	 * @param n
	 * @return ����ʽָ����ɵ�����
	 */
	public int[] getNum(long n) {
		int[] result = new int[33];   // ����ʽ�����32��
		for(int i=0;i<33;i++)   // ��ʼ������ʽ
			result[i]=0;
		int index = 32;   // ��ʼ������
		long t;   // ��¼��ʱ����
		while(n>0) {
			t = (1L<<index);   // ��ȡ����ʽ��index��ĵĴ�С
			if(n>=t) {   
				result[index] = 1;
				n -= t;
			}
			index-=1;
		}
		return result;
	}
	/**
	 * ����
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if(x==0)   // ���x==0��ֱ�ӷ���0����
			return 0.0;
		else if(x==1 || n==0)   // ���x==1����ȡ��n==0�����һ����1
			return 1.0;
		else if(Math.abs(n)==1) {   
			if(n==1)   // ���n==1���������䱾��
				return x;
			else   // n==-1��������䵹��
				return 1/x;
		}
		else {
			long nn = (long)n;   // ����n=-2^31���������ֹȡ����ֵ֮�����
			if(n<0) {
				x = 1/x;
				nn *= -1;
			}
			int flag = 1;   // ��ǽ�����������Ǹ���
			if(x<0 && nn%2==1) {
				flag = -1;
			}
			x = Math.abs(x);
			int[] front = getNum(nn);   // ��ȡ��2Ϊ�׵Ķ���ʽ��ʾ��ʽ
			
			double result = 1.0;
			
			for(int i=0;i<33;i++) {
				if(front[i]==1) {   // ����ö���ʽ��ʾn�õ���ǰ������������������
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
	 * �ڶ��ַ������ǵ�һ�ַ������Ż�������Ҫ�ȼ������ʽ��ʾ���ڱ�������ʱ��ֱ�ӽ��м��㣬������
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
			// ʹ�����ƶ���ʽ�ķ�ʽ�������n=13=(2*(2*(2*1+1)))+1
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
