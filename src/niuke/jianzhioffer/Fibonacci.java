package niuke.jianzhioffer;

/**
 * ���쳲��������еĵ�N��
 * @author mayfly
 *
 */
public class Fibonacci {
	public int fibonacci(int n) {
		if(n==1) {   // ��һ��Ϊ1
			return 1;
		}else if(n==2) {   // �ڶ���Ҳ��1
			return 1;
		}else {   // ֮������������
			int start = 3;   // ��ʱn>=3�����Դ�3��ʼ����
			int rem1 = 1;   // ��һ��
			int rem2 = 1;   // �ڶ���
			int result = 0;   // ��ʼ�����
			while(start<=n) {
				result = rem1 + rem2;   // �����k����
				rem1 = rem2;   // ����k-1��
				rem2 = result;   // ����k����
				start++;   // ����k
			}
			return result;   // ѭ����������������
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(4));
	}
}
