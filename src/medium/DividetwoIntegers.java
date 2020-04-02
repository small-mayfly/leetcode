package medium;

public class DividetwoIntegers {
	public int divide(int dividend, int divisor) {
		// 判断如果dividend为0则不需要计算，结果一定为0
		if(dividend==0) {
			return 0;
		}
		// 首先将所有值变为long型以处理转换为整数后超出int大小的情况
		// 还有第二种做法就是将数字转换为负数过后进行计算可以不用考虑这种情况，做运算的时候改变下条件即可，此处没有使用这种做法
		long myDividend = Math.abs((long)dividend);
		long myDivisor = Math.abs((long)divisor);
		// 判断两数的最终结果是正数还是负数，flag==1则结果为负，否则结果为正
		int flag = 0;
		if(dividend>0 && divisor<0) {
			flag = 1;
		}
		else if(dividend<0 && divisor>0) {
			flag = 1;
		}
		// 如果divisor==1也就是分母为1，此时结果一定等于dividend
		if(divisor==1) {
			return dividend;
		}
		// 如果divisor==-1，也就是分母为-1，此时需要处理flag==1的情况，因为此时可能会出现-2^-1的大小，转换为正数后会溢出
		if(divisor==-1) {
			if(flag==1)
				myDividend = 0-myDividend;   // 需要转换为负，则直接相减即可
			
			if(myDividend>Integer.MAX_VALUE)   // 考虑(-2^31-1)/-1的情况，转换为正数过后溢出，所以直接返回最大值即可
				return Integer.MAX_VALUE;
			return (int)myDividend;
		}
		// 排除所有可以直接返回结果的情况，剩下的情况只能进行运算解决
		// 此处有两种做法
		// 一种是dividend循环减去divisor，这样时间复杂度为O(myDividend/myDivisor)
		// 另一种是，每次将divisor进行移位，获取到最接近当前dividend的值过后，将dividend进行更新，这样时间复杂度为O(log(myDividend))
		long now_result = 0;   // 记录最终结果
		long head;   // 用于求出移位多少合适的判断界限
		long tail;   // 用于求出移位多少合适的判断界限
		while(myDividend>=myDivisor) {   // 每次减去myDividend，如果小于myDivisor说明只剩下余数，循环可以截止
			// 第一种做法，每次减一个，myDividend = myDivisor*now_result
//			now_result++;
//			myDividend -= myDivisor;
			// 第二种做法，也就是将myDividend进行拆分为myDividend=myDivisor*(2^k1)+myDivisor*(2^k2)+myDivisor*(2^k3)+...
			// 最终结果为(2^k1)+(2^k2)+(2^k3)+...
			int rem = 0;   // 记录当前位移
			while(true) {   // 当满足条件从内部跳出，这里只要一直循环即可
				// 求出k
				head = myDivisor<<rem;   
				tail = myDivisor<<(rem+1);
				if((head <= myDividend) && (tail > myDividend)) {
					if(rem==0) {   // 当位移为0的时候，此时2<<-1==0,实际上应该是1，所以单独赋值
						now_result += 1;
					}else {   // now_result+=2^k
						now_result += 2<<(rem-1);
					}
					myDividend -= (myDivisor<<rem);   // 每次更新这个值
					break;
				}
				rem++;
			}
		}
		if(flag==1)   // 如果flag==1，说明应该异号
			return (int)(0-now_result);
		else {   // 这里不需要判断溢出，因为math.abs(now_result)<=2^31
			return (int)now_result;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DividetwoIntegers dti = new DividetwoIntegers();
		int result = dti.divide(7, -2);
		System.out.println(result);
	}
}
