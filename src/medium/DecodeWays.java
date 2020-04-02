package medium;
/**
 * 1. Ŀ�꣺���һ�����ִ����ܽ������������ĸ��
 * 2. ���ƹ�ʽ��result(n) = judge(n-1) * result(n-1) + judge(n-2) * result(n-2)������judgeΪ�жϵ�ǰ��ĸ�ܷ�ƴ����ȥ�������������Ϊ0��������Ϊ1
 * 3. ���������е��ַ�������N���������
 * @author cloud
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if("".equals(s))   // ����ǿ��ַ������򲻴�������
			return 0;
		if(s.length()==1) {   // ����Ϊ1ʱ�������0�򷵻�0��������������ĸ���������0����һ������ĸ������1
			if("0".equals(s))
				return 0;
			else
				return 1;
		}
		// ������¼��������¼�м���
		int[] rem = new int[s.length()+1];
		if('0'==s.charAt(0))   // ����ַ�����ͷΪ0����һ���ǷǷ���
			return 0;
		else {   // ���ǷǷ����ַ�����ʼ����
			rem[0] = 1;   // ���±��ĵ�һ��λ�ò���¼ֵ��ֻ������ʼ��������Ϊ1��Ϊ�����ַ�������Ϊ2ʱ�õ��������
			rem[1] = 1;   // ��¼���ĵڶ���λ�ü�¼��һ����ĸ
		}
		int result1;
		int result2;
		int temp;
		for(int i=2;i<rem.length;i++) {
			// �����жϵ�i�������ܷ��Լ����һ����ĸ���������0���ܣ������0����
			result1 = '0'==s.charAt(i-1)?0:rem[i-1];   // �ܵ��������ĸ���������Ժ�ǰ���i-1����ĸ���һ����
			if('0'==s.charAt(i-2)) {   // ���ǰһ��������0����ǰ��i���������ܺ�ǰ���һ�������һ����ĸ
				result2 = 0;
			}else {
				// ���ǩ�����ַ�0��˵��������ϳ���ĸ�Ŀ���
				temp = Integer.parseInt(s.substring(i-2, i));
				// �������ĸ����ڶ��������ֵ
				if(temp>0 && temp<27) {
					result2 = rem[i-2];
				}else {   // ���������ĸ
					result2 = 0;
				}
			}
			// �ӿ�ͷ����ǰ������ɵ��ַ�����������ô������ϳ���ĸ�����
			rem[i] = result1 + result2;
		}
		return rem[rem.length-1];
    }
	public static void main(String[] args) {
		String data = "226";
		System.out.println(new DecodeWays().numDecodings(data));
	}
}
