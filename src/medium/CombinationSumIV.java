package medium;

import java.util.Arrays;

/**
 * 
 * 1. ����target����F(target)����Ϸ���,������ΪA�����鳤����N����Ŀ��Ϊ��max(F(target))
 * 2. F(X) = F(X-A[0])+F(X-A[1])+... +F(X-A[N-1]))
 * 3. �ȼ��������Сֵ��ɵķ�������Ϊ�ϴ�ֵ�����ɽ�Сֵ��ɵ�
 * 3. ��ǰ�������μ�������
 * @author mayfly
 *
 */
public class CombinationSumIV {

	public int dynamic_p(int[] nums, int target) {
		if(nums.length==0)   // û�����֣������ڹ���Ŀ��Ŀ���
			return 0;
		else if(nums.length==1) {
			if(target%nums[0]==0) {
				return 1;
			}else {
				return 0;
			}
		}
		int result = 0;
		// ��Ԫ��������
		Arrays.sort(nums);
		int maxNum = nums[nums.length-1];
		int minNum = nums[0];
		// ���Լ�¼������м���
		int[] remResult = new int[target+1];

		// ���Ƚ���������λ�ø�Ϊ1�����еķ�������һ���������ۼӵ�
		for(int i=0;i<nums.length;i++)
			if(nums[i]<=target) {
				remResult[nums[i]] = 1;
			}
		// ����Сֵ��ʼ����ΪС����Сֵ�Ĵ𰸿϶�Ϊ0����������Сֵ��С�ڸ����������ֵ�����ֿ����ɶ����Сֵ����
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
