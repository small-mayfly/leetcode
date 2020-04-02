package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * �������ѽ��ȫ��������2
 * @author mayfly
 *
 */
public class Permutations2 {
	
	/**
	 * ���nums����С�ڵ���һ����ֱ�ӹ����ս����numsһ��������ؼ��ɣ�������ȴ���1�������ѳ����
	 * @param nums ��ȫ���е�����
	 * @return ȫ���н����ɵ�list
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
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
        	List<Integer> result = new LinkedList<Integer>();   //��ʱ�����¼
        	Map<Integer, Integer> numNums = new HashMap<Integer, Integer>();   // ���ڼ�¼ÿ�������Լ����ִ���
        	for(int i=0;i<nums.length;i++) {
        		if(numNums.containsKey(nums[i])) {
        			numNums.replace(nums[i], numNums.get(nums[i])+1);
        		}else {
        			numNums.put(nums[i], 1);
        		}
        	}
        	// ѭ�����ҽ��
        	rec(numNums, results, result, 0, nums.length);
        	return results;
        }
    }
	
	public void rec(Map<Integer, Integer> datas, List<List<Integer>> results, List<Integer> result, int num, int len) {
		if(num==len) {
			List<Integer> temp = new LinkedList<Integer>();
			for(Integer key: result) {
				temp.add(key);
			}
			results.add(temp);
			return;
		}
		// ����ÿ�����ֽ��б�������Ϊ�����һ�����ַŶ�ξͻ�����ظ�������
		for(Integer key: datas.keySet()) {
			if(datas.get(key)>0) {
				datas.replace(key, datas.get(key)-1);
				result.add(key);
				rec(datas, results, result, num+1, len);
				result.remove(result.size()-1);
				datas.replace(key, datas.get(key)+1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations2 p = new Permutations2();
		int[] nums = {1,1,2,2};
		List<List<Integer>> results = p.permuteUnique(nums);
		System.out.println(results.size());
		for(List<Integer> result: results) {
			System.out.println(result);
		}
	}

}
