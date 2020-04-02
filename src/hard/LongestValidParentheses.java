package hard;

public class LongestValidParentheses {
	/**
	 *	�ҳ��ַ����кϷ���()�Ӵ��ǵ���󳤶ȣ�����())()�Ϸ��Ӵ�����Ϊ2����Ϊ�м��и��Ƿ��ַ��������Ӵ�������
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		// ������Ȳ���2��һ�������ںϷ�ƥ��
        if(s.length()<2)
        	return 0;
        // ����ȥ������ߵķǷ��Ӵ�����ʵ���ұߵķǷ�(((Ҳ���������ַ���ȥ����������û����
        int startIndex = 0;   // ������߿�ʼ����
        for(startIndex=0;startIndex<s.length();startIndex++) {
        	if(s.charAt(startIndex) != ')')
        		break;
        }
        s = s.substring(startIndex);   // ��ȡ������ߵ�)))�Ƿ��Ӵ�
        // ��¼�ַ�����ĳ���ַ��Ƿ�Ϸ�
        int[] cul = new int[s.length()];
        for(startIndex=0;startIndex<s.length();startIndex++) {   // ������Ϊ0������Ϊ���Ϸ�
        	cul[startIndex]=0;
        }
        int rem = 0;   // ʹ��rem��ģ����ջ��ջ��������Ϊ()�������ԣ����������ջ��û��ʣ��һ���ǺϷ���
        for(startIndex=0;startIndex<s.length();startIndex++) {
        	if(s.charAt(startIndex)=='(') {   // ���������(����ջ��rem--
        		rem--;
        		cul[startIndex]++;   // ���赱ǰ�ǺϷ��ģ�����+1
        	}else {   // )��ջ
        		rem++;   // ģ���ջ����
        		if(rem<=0) {   // ���rem>0˵��)���࣬��)һ���ǷǷ��ģ����Ե�rem<=0ʱ�����Լ���Ϸ�
        			cul[startIndex]++;   // �Ϸ��ģ�����+1
        		}else {   // ���Ϸ�
        			rem=0;   // ���Ϸ�ֱ�ӽ�ջ�ÿգ����¿�ʼ��ջ
        			cul[startIndex]--;   // ��ǰλ��һ���Ƿ������ԣ�����-1
        		}
        	}
        }
        // ���ֻ�Ǵ�������һ�飬��Ϊ�кܶ�ط�ֻ���Ǽ���Ϸ�������(()������ߵķǷ��ַ�Ҳ������Ϊ�Ϸ������Ƕ���())���ұߵ�)һ����ʶ����Ƿ�
        // ����ʹ����ͬ��˼·�����������һ�ߣ������ų�һЩ֮ǰ�������ұ����޷�ȷ�������
        rem = 0;   // ���ջ
        for(startIndex=0;startIndex<s.length();startIndex++) {
        	if(s.charAt(s.length()-startIndex-1)==')') {   // ���������)����ջ��rem--
        		rem--;
        		cul[s.length()-startIndex-1]++;   // ���赱ǰ�ǺϷ��ģ�����+1
        	}else {   // )��ջ
        		rem++;   // ģ���ջ����
        		if(rem<=0) {   // ���rem>0˵��)���࣬��)һ���ǷǷ��ģ����Ե�rem<=0ʱ�����Լ���Ϸ�
        			cul[s.length()-startIndex-1]++;   // �Ϸ��ģ�����+1
        		}else {   // ���Ϸ�
        			rem=0;   // ���Ϸ�ֱ�ӽ�ջ�ÿգ����¿�ʼ��ջ
        			cul[s.length()-startIndex-1]--;   // ��ǰλ��һ���Ƿ������ԣ�����-1
        		}
        	}
        }
        // �������α������󣬺Ϸ����ַ���Ӧcul�����е�����һ��Ϊ2������ֻ��Ҫ�ҳ�cul���������2�ĸ���������Ϸ�ƥ���Ӵ�����
        rem = 0;   // ʹ��rem������ʶλ��Ϊ0��ʾ��һ���ַ��ǷǷ��ַ�����Ҫ�ӵ�ǰλ�ÿ�ʼ����
        int tresult = 0;   // ��¼��ǰ���ҵ��Ӵ��ĺϷ�����
        int result = 0;   // ��¼��Ϸ��Ӵ�����
        for(startIndex=0;startIndex<s.length();startIndex++) {
        	if(rem==0) {   // rem==0�ӵ�ǰλ�ÿ�ʼ��������һ��������λ�ò��ںϷ��Ӵ���
        		if(tresult>result)   // �����һ���Ϸ��Ӵ����ȴ���Ŀǰ��֪�Ϸ��Ӵ���������и�ֵ
        			result=tresult;
        		tresult = 0;   // ��ʼ׼������һ���Ϸ��Ӵ����ȼ���
        	}
        	if(cul[startIndex]==2) {   // ��ǰλ�úϷ�
        		tresult++;   // ��������+1
        		rem++;   // �޸ı�ʶλ��������һ�α�����ǰ�ַ��Ϸ�
        	}else {
        		rem=0;   // ���Ϸ������־��ǰλ�÷Ƿ�
        	}
        }
        if(tresult>result)   // �������ĺϷ��Ӵ�û�и�ֵ�����
			result=tresult;
        return result;   // ���ؽ��
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses lvp = new LongestValidParentheses();
		String s = "()(()";
		System.out.println(lvp.longestValidParentheses(s));
	}
}
