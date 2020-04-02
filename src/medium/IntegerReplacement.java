package medium;

// https://leetcode.com/problems/integer-replacement/discuss/87920/A-couple-of-Java-solutions-with-explanations
public class IntegerReplacement {
	public int integerReplacement(int n) {
		if(n==0)
			return 0;
		else if(n==1)
			return 0;
		else if(n==2)
			return 1;
		else if(n==Integer.MAX_VALUE)
			return 32;
		else {
			int rem = 0;
			while(n!=1) {
				if(n%2==0) {
					n>>=1;
				}else {
					if(((n>>>1)&1) == 0 || n==3) {
						n--;
					}else {
						n++;
					}
				}
				rem++;
			}
			return rem;
		}
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IntegerReplacement().integerReplacement(2147483647));

	}

}
