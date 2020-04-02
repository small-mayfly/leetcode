package niuke.jianzhioffer;

/**
 * 0的补码为全0
 * 整数的补码为原码，所以只需要计算
 * @author mayfly
 *
 */
public class NumberOf1 {
	
	public int numberOf1(int n) {
		// 0的补码全为0
		if(n==0)
			return 0;
		else if(n>0) {    //正数的补码为原码，所以只需要统计转换为二进制后，序列中1的个数
			int result=0;
			while(n>0) {
				result += (n%2);
				n /= 2;
			}
			return result;
		}else {   // 负数的补码，第一位为1，之后的31位为其正数的二进制数，取反+1
			if(n==Integer.MIN_VALUE)
				return 1;
			else {
				int result=1;
				int[] rem = new int[31];
				n *= -1;
				int index = 0;
				while(n>0) {
					rem[index++] = (n%2);
					n /= 2;
				}
				for(int i=0;i<31;i++) {
					rem[i] = 1-rem[i];
				}
				index = 0;
				rem[0]++;
				for(int i=0;i<31;i++) {
					result = index + rem[i];
					if(result>1) {
						rem[i] = result - 2;
						index = 1;
					}else {
						rem[i] = result;
						break;
					}
				}
				result = 1;
				for(int i=0;i<31;i++) {
					result += rem[i];
				}
				return result;
			}
		}
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOf1 no = new NumberOf1();
		System.out.println(no.numberOf1(-2));
	}

}
