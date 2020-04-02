package medium;

public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd3(int m, int n) {
		if(m==0 || n==0)
			return 0;
		// 查找所有不同的位
		int rem = m^n;
		// 如果存在一个数字的二进制表示比另一个数字的二进制表示要长的情况，则两个数之间所有数字按位与一定是0
		if(rem>m || rem>n)
			return 0;
		
		// 查找到两个数字相同位的开始位置(二进制表示从右向左数)
		int start = 0;
		while(rem>0) {
			start++;
			rem>>=1;
		}	
		// 取整返回结果
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
