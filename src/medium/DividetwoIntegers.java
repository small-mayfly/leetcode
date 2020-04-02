package medium;

public class DividetwoIntegers {
	public int divide(int dividend, int divisor) {
		// �ж����dividendΪ0����Ҫ���㣬���һ��Ϊ0
		if(dividend==0) {
			return 0;
		}
		// ���Ƚ�����ֵ��Ϊlong���Դ���ת��Ϊ�����󳬳�int��С�����
		// ���еڶ����������ǽ�����ת��Ϊ����������м�����Բ��ÿ�������������������ʱ��ı����������ɣ��˴�û��ʹ����������
		long myDividend = Math.abs((long)dividend);
		long myDivisor = Math.abs((long)divisor);
		// �ж����������ս�����������Ǹ�����flag==1����Ϊ����������Ϊ��
		int flag = 0;
		if(dividend>0 && divisor<0) {
			flag = 1;
		}
		else if(dividend<0 && divisor>0) {
			flag = 1;
		}
		// ���divisor==1Ҳ���Ƿ�ĸΪ1����ʱ���һ������dividend
		if(divisor==1) {
			return dividend;
		}
		// ���divisor==-1��Ҳ���Ƿ�ĸΪ-1����ʱ��Ҫ����flag==1���������Ϊ��ʱ���ܻ����-2^-1�Ĵ�С��ת��Ϊ����������
		if(divisor==-1) {
			if(flag==1)
				myDividend = 0-myDividend;   // ��Ҫת��Ϊ������ֱ���������
			
			if(myDividend>Integer.MAX_VALUE)   // ����(-2^31-1)/-1�������ת��Ϊ�����������������ֱ�ӷ������ֵ����
				return Integer.MAX_VALUE;
			return (int)myDividend;
		}
		// �ų����п���ֱ�ӷ��ؽ���������ʣ�µ����ֻ�ܽ���������
		// �˴�����������
		// һ����dividendѭ����ȥdivisor������ʱ�临�Ӷ�ΪO(myDividend/myDivisor)
		// ��һ���ǣ�ÿ�ν�divisor������λ����ȡ����ӽ���ǰdividend��ֵ���󣬽�dividend���и��£�����ʱ�临�Ӷ�ΪO(log(myDividend))
		long now_result = 0;   // ��¼���ս��
		long head;   // ���������λ���ٺ��ʵ��жϽ���
		long tail;   // ���������λ���ٺ��ʵ��жϽ���
		while(myDividend>=myDivisor) {   // ÿ�μ�ȥmyDividend�����С��myDivisor˵��ֻʣ��������ѭ�����Խ�ֹ
			// ��һ��������ÿ�μ�һ����myDividend = myDivisor*now_result
//			now_result++;
//			myDividend -= myDivisor;
			// �ڶ���������Ҳ���ǽ�myDividend���в��ΪmyDividend=myDivisor*(2^k1)+myDivisor*(2^k2)+myDivisor*(2^k3)+...
			// ���ս��Ϊ(2^k1)+(2^k2)+(2^k3)+...
			int rem = 0;   // ��¼��ǰλ��
			while(true) {   // �������������ڲ�����������ֻҪһֱѭ������
				// ���k
				head = myDivisor<<rem;   
				tail = myDivisor<<(rem+1);
				if((head <= myDividend) && (tail > myDividend)) {
					if(rem==0) {   // ��λ��Ϊ0��ʱ�򣬴�ʱ2<<-1==0,ʵ����Ӧ����1�����Ե�����ֵ
						now_result += 1;
					}else {   // now_result+=2^k
						now_result += 2<<(rem-1);
					}
					myDividend -= (myDivisor<<rem);   // ÿ�θ������ֵ
					break;
				}
				rem++;
			}
		}
		if(flag==1)   // ���flag==1��˵��Ӧ�����
			return (int)(0-now_result);
		else {   // ���ﲻ��Ҫ�ж��������Ϊmath.abs(now_result)<=2^31
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
