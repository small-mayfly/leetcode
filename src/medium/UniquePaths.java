package medium;

/**
 * �����Ͻ��ƶ������½ǣ�ÿ���ƶ�һ��ֻ�������һ������ƶ�
 * @author mayfly
 *
 */
public class UniquePaths {
	/**
	 * ��1,1->m,n����Ҫ��m+n-2����������m-1�����ߣ�n-1�������ߣ��ʹ���C_(M+N-2)^(N-1)�����
	 * @param m ������
	 * @param n ������
	 * @return �����������
	 */
	public int uniquePaths(int m, int n) {
		if(m==0 || n==0)   // �������һ��Ϊ0��˵���д���
			return 0;
		if(m==1 || n==1)   // ��������Ϊ1����ֻ��ȫ�����һ�ֻ��������
			return 1;
		long result = 1;   // ��¼����������м������ܽϴ�������long����
		int index = 2;   // ��ĸ
		for(int i=0;i<n-1;i++) {   // ����ͬʱ���г˺ͳ����㣬ԭ��ܼ򵥣����ڹ�����м�����long����Ҳ�޷��е������Խ�����ǰ����Ԫ����
			result *= (i+m);   // ���ӳ���
			while(index<n && result%index==0) {
				result /= index;   // ��ĸ��
				index++;
			}
		}
		// ��û�м���ķ�ĸ��������
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
