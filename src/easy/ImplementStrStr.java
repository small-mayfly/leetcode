package easy;

public class ImplementStrStr {
	/**
	 * ���needle�Ӵ���haystack�е�һ�γ��ֵ����������û�г��ֹ��򷵻�-1
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		if(needle.length()>haystack.length())   // ���needle�ĳ��ȴ���haystack����needle�Ӵ�һ��������haystack�г���
			return -1;
		if("".equals(needle) && "".equals(haystack))   // ������߶�Ϊ�գ�����0
			return 0;
		else if("".equals(haystack))   // ���ֻ��haystackΪ�գ���һ����û��Ϣ
			return -1;
		else if("".equals(needle))   // ���needleΪ�գ�haystack��Ϊ�գ��򷵻�0����Ϊ��ֵ����������λ��
			return 0;
		// ʣ�µ����޷�ֱ���жϵ������ֻ�ܱ���
		int result = -1;   // ���ȼ���needle������haystack�г���
		int needleLen = needle.length();   // ��ȡneedle�ĳ���
		for(int i=0;i<=haystack.length()-needleLen;i++) {   // �ӿ�ʼλ�ñ���������п��ܵ�λ��
			if(haystack.subSequence(i, i+needleLen).equals(needle)) {   // ����ҵ������ѭ��
				result = i;
				break;
			}
		}
		return result;   // ���ز��ҵĽ��
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStrStr iss = new ImplementStrStr();
		String haystack = "hello";
		String needle = "hello";
		System.out.println(iss.strStr(haystack, needle));
	}

}
