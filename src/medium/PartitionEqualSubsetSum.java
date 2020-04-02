package medium;

/**
 * 整个问题可以拆分为两步
 * 第一步：对所有数字求和allsum，判断和是偶数还是奇数，如果是奇数则不可能将数字平均分为两组直接返回false，如果为偶数才存在平均分的可能性
 * 第二步：所有数字求和allsum/2得到的数字subsum是均分过后一组数字的和，此时只需要判断整个数组中是否存在一组数相加等于这个subsum
 * 
 * 求subsum可以看做一个动态规划问题，如果某个数字n应该在这组数中，则subsum-n的结果应该可以由这组数剩下的数字相加得到
 * 假设组成subsum的一组数共有N个数字，第k个数字可以由Ak表示，前k个数字的和为sum(k)可以得到递推公式如下：
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
		// 记录本，用以记录当前值是否被探测过，探测过则不再探测了
		int[] rem = new int[(int) (sum+1)];
		return magic(nums, rem, nums.length-1, sum);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas = {1, 5, 11, 5};
		System.out.println(new PartitionEqualSubsetSum().canPartition(datas));

	}

}
