package niuke.jianzhioffer;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * @author mayfly
 *
 */
public class TiaoTaiJie {
	/**
	 * ˼·���Ƽ���쳲��������� f_n = f_(n-1) + f_(n-2),f_(n-1)��һ��+f_(n-2)������
	 * @param target
	 * @return
	 */
	public int JumpFloor(int n) {
		if(n==1) {   // ��һ��Ϊ1
			return 1;
		}else if(n==2) {   // �ڶ�����2
			return 2;
		}else {   // ֮������������
			int start = 3;   // ��ʱn>=3�����Դ�3��ʼ����
			int rem1 = 1;   // ��һ��
			int rem2 = 2;   // �ڶ���
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

	}

}
