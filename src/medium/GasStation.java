package medium;

public class GasStation {
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        // ��¼ѭ��������ʼ��λ��
		int startIndex = 0;
		// ��¼ÿһ����ǰ������
		int nowGas = 0;
		// ��¼��ǰ���˶��ٲ�
		int index = 0;
		while(index<gas.length) {
			// ����״̬Ϊ�ռ����ͣ���ǰ״̬Ϊ���״̬
			nowGas += gas[(startIndex+index)%gas.length];
			// �ӹ���֮��ʼ�ƶ�
			nowGas -= cost[(startIndex+index)%gas.length];
			// ����߲�����һ������վ�������¿�ʼ�ж�
			if(nowGas<0) {
				// ���ÿ�ʼλ��
				startIndex = startIndex+index+1;
				// ת��һȦ�ˣ���Ȼ���У��򷵻��޽��
				if(startIndex>gas.length)
					return -1;
				// û�г�������������������㣬���¿�ʼ����
				index = 0;
				// ����������ʼ��
				nowGas = 0;
			}else {   // �ߵõ��ͼ�����
				index++;
			}
		}
		return startIndex%gas.length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}

}
