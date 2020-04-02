package medium;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	/**
	 * 生成一个结果list的copy
	 * @param rem 当前计算出的结果
	 * @return 返回copy的对象
	 */
	public List<Integer> getList(List<Integer> rem){
		List<Integer> trem = new LinkedList<Integer>();
		for(Integer t: rem) {
			trem.add(t);
		}
		return trem;
	}
	/**
	 * 深度搜索结果，搜索到就插入到results中，搜索不到就不管
	 * @param candidates 候选集
	 * @param index 当前已经遍历到的索引
	 * @param value 当前已经减去的结果值，用于本次计算
	 * @param rem 当前已经计算出的中间结果引用
	 * @param results 结果的引用
	 */
	public void search(int [] candidates, int index, int value, List<Integer> rem, List<List<Integer>> results){
		int result;   // 记录减去当前索引位置值的结果
		if(index>=0 && value>=0) {
			result = value-candidates[index];   //上一轮结果减去当前索引位置值的结果
			if(result>0) {   // 如果结果>0继续下一轮计算
				rem.add(candidates[index]);   // 将当前索引值插入到中间list中
				for(int i=index;i>=0;i--) {   // 遍历所有可能计算出结果的情况
					search(candidates, i, result, rem, results);
				}
				rem.remove(rem.size()-1);   // 从list中移除当前索引值
			}else if(result==0) {   // 如果得到结果，直接插入到results中
				rem.add(candidates[index]);   // 将当前索引值插入到中间list中
				results.add(getList(rem));   // 得到结果，直接插入到results中
				rem.remove(rem.size()-1);   // 从list中移除当前索引值
				return;
			}
		}
	}
	/**
	 * 计算结果
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// 记录所有结果集
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		// 用于记录中间结果
		List<Integer> rem = new LinkedList<Integer>();
		// 遍历所有可能索引，调用深度搜索函数
		for(int i=candidates.length-1;i>=0;i--) {
			search(candidates, i, target, rem, results);
		}
		// 返回结果集
		return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum cs = new CombinationSum();
		int target = 7;
		int[] candidates = {2,3,5};
		List<List<Integer>> results = cs.combinationSum(candidates, target);
		for(List<Integer> result : results) {
			for(Integer t: result) {
				System.out.print(t);
				System.out.print(", ");
			}
			System.out.println();
		}
	}
}
