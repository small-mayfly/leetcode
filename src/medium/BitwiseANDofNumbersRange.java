package medium;

public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd3(int m, int n) {
		if(m==0 || n==0)
			return 0;
		// �������в�ͬ��λ
		int rem = m^n;
		// �������һ�����ֵĶ����Ʊ�ʾ����һ�����ֵĶ����Ʊ�ʾҪ�����������������֮���������ְ�λ��һ����0
		if(rem>m || rem>n)
			return 0;
		
		// ���ҵ�����������ͬλ�Ŀ�ʼλ��(�����Ʊ�ʾ����������)
		int start = 0;
		while(rem>0) {
			start++;
			rem>>=1;
		}	
		// ȡ�����ؽ��
		return m>>start<<start;
	}
	
	
	public int rangeBitwiseAnd2(int m, int n) {
		if(m==0 || n==0)
			return 0;
		int start = 0;
		while(m!=n && m>0 && n>0) {
			m>>=1;
			n>>=1;
			start++;
		}
		
		if(m>0 && n>0)
			return m<<start;
		else {
			return 0;
		}
	}
	
	
	public int rangeBitwiseAnd(int m, int n) {
		if(m==0 || n==0)
			return 0;
		
        int start = 0;
        int end = 0;
        int rem = m>n?n:m;
        while(n>0 && m>0) {
        	if((m%2)==(n%2)) {
        		end++;
        	}else {
        		end++;
        		start = end;
        	}
        	m/=2;
        	n/=2;
        }
        if(m==n) {
        	rem = rem>>start;
            rem = rem<<start;
    		
    		return rem;
        }else {
        	return 0;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseANDofNumbersRange bar = new BitwiseANDofNumbersRange();
		System.out.println(5&7);
		System.out.println(bar.rangeBitwiseAnd3(5,7));
	}

}
