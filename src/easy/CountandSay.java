package easy;

public class CountandSay {
	/**
	 * ��ͷ��ʼ�����㵽n��ֹ
	 * @param n
	 * @return ��������ַ���
	 */
	public String countAndSay(int n) {
		if(n==0)   // ��0��ֱ�ӷ��ؿռ���
			return "";
		else if(n==1)
			return "1";   // ��Ŀ��������һ��Ϊ1
		else if(n==2)
			return "11";   // ��Ŀ�������ڶ���Ϊ11
		// ʣ�������ɼ���õ�
		// ����stringbuffer����Ҫ�����ڲ�֪���೤������ʹ����������䳤
		StringBuilder t = new StringBuilder();
		// ��ʼ��n==2�����
		t.append('1');
		t.append('1');
		int remLen = t.length();   // ��ȡ��ǰ�ַ�������
		int index = 0;   // ��ͷ��ʼ����
		char a='1';   // ���Ĵʣ����ڼ�¼
		int count;   // �����������ж��ٸ�
		for(int i=2;i<n;i++) {   // ��2��ʼ������
			a = t.charAt(0);   // ������¼��һ��ֵ��ʲô
			index = 1;   // ��1��ʼ��������Ϊ0�Ѿ���ֵ��a
			count = 1;   // ��ǰ�Ѿ���count��a����
			while(index<remLen) {   // ���������ַ��������м���
				if(t.charAt(index)==a) {   // �����ǰ�ʺ���һ����һ�������������
					count++;
				}else {   // �����һ��������Ҫ���µ�ǰ��¼�ʣ�Ҳ���Ǹ�������
					// �Ƚ���ǰ��¼��������ַ����ĺ���
					t.append((char)(count+'0'));   // ����ǰ����ֵ�����ַ�����ĩβ
					t.append(a);   // ����ǰ���ķ����ַ�����ĩβ
					// �޸�����
					a = t.charAt(index);
					count = 1;   // ���¿�ʼ����
				}
				index++;   // ����һ���ʣ���������ƶ�
			}
			// ���һ���ַ��ļ����϶�û�з����ַ�����ĩβ�����ԷŽ�ȥ
			t.append((char)(count+'0'));
			t.append(a);
			// ���ַ�����֮ǰ���ַ������
			t.delete(0, remLen);
			// ��¼�����ɵ��ַ����ĳ���
			remLen = t.length();
//			System.out.println(t.toString());   // �����ǰ�±����Ľ��������Ҫ���
		}
        return t.toString();   // ���ؽ��
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay cts = new CountandSay();
		System.out.println(cts.countAndSay(6));
	}

}
