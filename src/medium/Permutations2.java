package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 万能深搜解决全排列问题2
 * @author mayfly
 *
 */
public class Permutations2 {
	
	/**
	 * 如果nums长度小于等于一，则直接构建空结果和nums一个结果返回即可，如果长度大于1，则深搜出结果
	 * @param nums 待全排列的数组
	 * @return 全排列结果组成的list
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		// 生成结果list
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        // 如果长度为0，说明没有数字，直接返回即可
        if(nums.length<1)
        	return results;
        // 如果长度为1，则只有一个结果，加入结果list返回
        else if(nums.length==1) {
        	List<Integer> temp = new LinkedList<Integer>();
        	temp.add(nums[0]);
        	results.add(temp);
        	return results;
        }else {
        	// 如果长度大于1，则使用深搜查找结果
        	List<Integer> result = new LinkedList<Integer>();   //临时结果记录
        	Map<Integer, Integer> numNums = new HashMap<Integer, Integer>();   // 用于记录每个数字以及出现次数
        	for(int i=0;i<nums.length;i++) {
        		if(numNums.containsKey(nums[i])) {
        			numNums.replace(nums[i], numNums.get(nums[i])+1);
        		}else {
        			numNums.put(nums[i], 1);
        		}
        	}
        	// 循环查找结果
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
		// 对于每个数字进行遍历，因为如果将一个数字放多次就会出现重复的问题
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
