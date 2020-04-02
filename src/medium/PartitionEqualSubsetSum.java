package medium;

/**
 * ����������Բ��Ϊ����
 * ��һ�����������������allsum���жϺ���ż����������������������򲻿��ܽ�����ƽ����Ϊ����ֱ�ӷ���false�����Ϊż���Ŵ���ƽ���ֵĿ�����
 * �ڶ����������������allsum/2�õ�������subsum�Ǿ��ֹ���һ�����ֵĺͣ���ʱֻ��Ҫ�ж������������Ƿ����һ������ӵ������subsum
 * 
 * ��subsum���Կ���һ����̬�滮���⣬���ĳ������nӦ�����������У���subsum-n�Ľ��Ӧ�ÿ�����������ʣ�µ�������ӵõ�
 * �������subsum��һ��������N�����֣���k�����ֿ�����Ak��ʾ��ǰk�����ֵĺ�Ϊsum(k)���Եõ����ƹ�ʽ���£�
 * sum(k)=judge*sum(k-1)
 * @author mayfly
 *
 */
public class PartitionEqualSubsetSum {
	
	public boolean magic(int[] nums, int[] rem, int index, long nowValue) {
		if(index<0)
			return false;
		boolean flag;
		while(index>-1) {
			if(nowValue-nums[index]>0) {
				if(rem[(int) (nowValue-nums[index])]==0) {
					flag = magic(nums, rem, index-1, nowValue-nums[index]);
					if(flag)
						return true;
					else {
						rem[(int) (nowValue-nums[index])] = -1;
					}
				}
			}else if(nowValue-nums[index]==0) {
				return true;
			}
			index--;
		}
		return false;
	}
	
	public boolean canPartition(int[] nums) {
		if(nums.length<2)
			return false;
		long sum = 0;
		for(int i=0;i<nums.length;i++)
			sum += nums[i];
		if(sum%2==1)
			return false;
		
		sum /= 2;
		// ��¼�������Լ�¼��ǰֵ�Ƿ�̽�����̽�������̽����
		int[] rem = new int[(int) (sum+1)];
		return magic(nums, rem, nums.length-1, sum);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas = {1, 5, 11, 5};
		System.out.println(new PartitionEqualSubsetSum().canPartition(datas));

	}

}
