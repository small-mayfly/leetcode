package medium;

public class ArithmeticSlices {
	/**
	 * �����Ȳ���Ϊ3��ʱ��һ�������������С����Լ���ӵ���������ʼ����
	 * ����һ�������У�����Ϊ3��4��5���ǣ����Կ��ܻ�������һ�����ֶ��˺ö��ֵ����
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
        	nowDis = A[i]-A[i-1];   // ���㵱ǰ������ǰһ�����ֵĲ�
        	if(nowDis==dis) {   // ������ֺ�֮ǰ��������ȣ���ʼ����
        		len++;   // ���ϵ�ǰ���֣���ǰ����һ���м�������
        		result += (len-2);   // ���������¼�������������и����ӵ������
        	}else {   // ֮ǰ�����ֶ�֮���û��Ӱ�죬���Կ��Դ�ͷ��ʼ������
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
