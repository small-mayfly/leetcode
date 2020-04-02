package medium;

import java.util.Arrays;

/**
 * 
 * 1. 假设target共有F(target)种组合方法,这组数为A，数组长度问N，则目标为求max(F(target))
 * 2. F(X) = F(X-A[0])+F(X-A[1])+... +F(X-A[N-1]))
 * 3. 先计算出来较小值组成的方法，因为较大值都是由较小值组成的
 * 3. 从前往后依次计算出结果
 * @author mayfly
 *
 */
public class CombinationSumIV {

	public int dynamic_p(int[] nums, int target) {
		if(nums.length==0)   // 没有数字，不存在构成目标的可能
			return 0;
		else if(nums.length==1) {
			if(target%nums[0]==0) {
				return 1;
			}else {
				return 0;
			}
		}
		int result = 0;
		// 将元数据排序
		Arrays.sort(nums);
		int maxNum = nums[nums.length-1];
		int minNum = nums[0];
		// 用以记录计算的中间结果
		int[] remResult = new int[target+1];

		// 首先将已有数字位置赋为1，所有的方法都是一条条方法累加的
		for(int i=0;i<nums.length;i++)
			if(nums[i]<=target) {
				remResult[nums[i]] = 1;
			}
		// 从最小值开始，因为小于最小值的答案肯定为0，但大于最小值，小于给定数字最大值的数字可能由多个最小值构成
		for(int i=minNum; i<=target-minNum;i++) {
			if(remResult[i]>0) {
				for(int j=0;j<nums.length;j++) {
					if(nums[j]+i<=target)
						remResult[nums[j]+i] += remResult[i];
				}
			}
		}
		
		return remResult[target];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		int target = 10;
		CombinationSumIV cs = new CombinationSumIV();
		System.out.println(cs.dynamic_p(nums, target));

	}

}
