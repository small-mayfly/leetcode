package medium;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
	
	/**
	 * ���������е�ÿ��ֵ������ѡ��Ͳ�ѡ��������������Կ������ö����ƽ�λ���뷨���������ֵ�ѡ��
	 * ���ڳ���Ϊn��nums�е�n��ֵ��ѡ����Ϊ1����ѡ��Ϊ0�����У�0000...0~1111...1��ô��������������ظ�
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		// ��numsΪ�գ�ֱ�ӷ��ؿռ���
		if(nums.length==0)
			return null;
		// 000...0~111...1����2^n�����
		int numsCount = 1<<nums.length;
		// ��¼���ս��
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		// �����������ڼ�¼01
		int[] rems = new int[nums.length];
		// ��¼��λ
		int front = 0;
		for(int i=0;i<numsCount;i++) {
			// ÿ��+1��Ȼ���λ
			front = 1;
			for(int j=nums.length-1;j>-1;j--) {
				if(rems[j]+front>1) {
					rems[j] = 0;
				}else {
					rems[j]++;   // ����������Ҫ��λ��ʱ��ֱ���˳����ɣ���ǰ���ֵ�����ٸı�
					break;
				}
			}
			// ��¼ѡ���ֵ
			List<Integer> result = new LinkedList<Integer>();
			// �����Ϊ0��˵��Ҫѡ����
			for(int j=0;j<nums.length;j++) {
				if(rems[j]>0) {
					result.add(nums[j]);
				}
			}
			// ����ǰѡ��Ľ����ӵ����ս����
			results.add(result);
		}
		return results;
    }
	/**
	 * ���õݹ��˼�룬�ӿռ��Ͽ�ʼ��ÿ�ν�һ��������ӵ�Ҫ����Ľ����
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets2(int[] nums) {
		if(nums.length==0)
			return null;
		
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		
		List<Integer> result = new LinkedList<Integer>();
		results.add(result);
		
		int nowLen;
		for(int i=0;i<nums.length;i++) {
			// ��¼��ǰ�Ѿ����˶��ٸ����
			nowLen = results.size();
			// ��ÿ������������ϵ�ǰֵ
			for(int j=0;j<nowLen;j++) {
				List<Integer> tresult = new LinkedList<Integer>();
				tresult.addAll(results.get(j));
				tresult.add(nums[i]);
				results.add(tresult);
			}
		}
		return results;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		List<List<Integer>> results = new Subsets().subsets2(nums);
		for (List<Integer> result : results) {
			for (Integer data : result) {
				System.out.print(data+" ,");
			}
			System.out.println();
		}
		System.out.println("ed");

	}

}
