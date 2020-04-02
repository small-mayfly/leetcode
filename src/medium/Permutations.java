package medium;

import java.util.LinkedList;
import java.util.List;
/**
 * �������ѽ��ȫ��������
 * @author mayfly
 *
 */
public class Permutations {
	
	/**
	 * ���nums����С�ڵ���һ����ֱ�ӹ����ս����numsһ��������ؼ��ɣ�������ȴ���1�������ѳ����
	 * @param nums ��ȫ���е�����
	 * @return ȫ���н����ɵ�list
	 */
	public List<List<Integer>> permute(int[] nums) {
		// ���ɽ��list
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        // �������Ϊ0��˵��û�����֣�ֱ�ӷ��ؼ���
        if(nums.length<1)
        	return results;
        // �������Ϊ1����ֻ��һ�������������list����
        else if(nums.length==1) {
        	List<Integer> temp = new LinkedList<Integer>();
        	temp.add(nums[0]);
        	results.add(temp);
        	return results;
        }else {
        	// ������ȴ���1����ʹ�����Ѳ��ҽ��
        	rec(nums, results, 0);
        	return results;
        }
    }
	/**
	 * ����Ϊn������ȫ���У����Կ���n������Ϊn-1������ȫ���еĽ�����Դ�����
	 * @param nums �������飬���������鳤��Ϊ4��˵��
	 * @param results ȫ���н��
	 * @param index ��ǰ�ӵڼ������ֿ�ʼ����ȫ����
	 */
	public void rec(int[] nums, List<List<Integer>> results, int index) {
		// ����Ѿ��ҵ����һ��ֵ��˵���Ѿ�����һ��ȫ���н�����������list��ȥ
		if(index+1 == nums.length) {
			List<Integer> temp = new LinkedList<Integer>();
			for(int i=0;i<nums.length;i++) {
				temp.add(nums[i]);
			}
			results.add(temp);
			return;
		}
		// �������鱾�������
		rec(nums, results, index+1);
        int start;
		int end;
		int t;
		//����һ�ν���ʱ�����Կ�������4���������ֵ�ȫ���У��ֱ��Ӧ��һ������Ϊ(1,2,3,4)�������������������Ϊ4������ʣ�������
		// ���ڶ��ν���ʱ�������ʱ��һ������Ϊ1�����Կ�������3���������ֵ�ȫ���У��ֱ��Ӧ��һ������Ϊ(2,3,4)�������������������Ϊ3������ʣ���2��
		// �������ֵ�ȫ����ֻ��Ҫ����λ�ü���
		// ͬ���������ֵ�ȫ���п��Կ���������������λ�ú���������λ�û���
		// �Ӻ���ǰ��nλ������Ҫ����n-1
		for(int i=0;i<nums.length-index-1;i++) {
			// ���ȵ�ǰλ���Լ��������е�����ȫ����λ����
			start = index;
			end = nums.length - 1;
			while(end>start) {
				t= nums[start];
				nums[start] = nums[end];
				nums[end] = t;
				end--;
				start++;
			}
			// Ȼ���������
			rec(nums, results, index+1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		int[] nums = {1,1,2,2};
		List<List<Integer>> results = p.permute(nums);
		System.out.println(results.size());
		for(List<Integer> result: results) {
			System.out.println(result);
		}
	}
}
