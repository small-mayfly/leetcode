package medium;

import java.util.LinkedList;
import java.util.List;
/**
 * 万能深搜解决全排列问题
 * @author mayfly
 *
 */
public class Permutations {
	
	/**
	 * 如果nums长度小于等于一，则直接构建空结果和nums一个结果返回即可，如果长度大于1，则深搜出结果
	 * @param nums 待全排列的数组
	 * @return 全排列结果组成的list
	 */
	public List<List<Integer>> permute(int[] nums) {
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
        	rec(nums, results, 0);
        	return results;
        }
    }
	/**
	 * 长度为n的数组全排列，可以看做n个长度为n-1的数组全排列的结果，以此类推
	 * @param nums 输入数组，我们以数组长度为4来说明
	 * @param results 全排列结果
	 * @param index 当前从第几个数字开始计算全排列
	 */
	public void rec(int[] nums, List<List<Integer>> results, int index) {
		// 如果已经找到最后一个值，说明已经生成一种全排列结果，添加入结果list中去
		if(index+1 == nums.length) {
			List<Integer> temp = new LinkedList<Integer>();
			for(int i=0;i<nums.length;i++) {
				temp.add(nums[i]);
			}
			results.add(temp);
			return;
		}
		// 先找数组本身的排列
		rec(nums, results, index+1);
        int start;
		int end;
		int t;
		//当第一次进入时，可以看做是求4种三个数字的全排列，分别对应第一个数字为(1,2,3,4)的情况，其余三个数字为4个数中剩余的三个
		// 当第二次进入时，假设此时第一个数字为1，可以看做是求3种三个数字的全排列，分别对应第一个数字为(2,3,4)的情况，其余两个数字为3个数中剩余的2个
		// 两个数字的全排列只需要交换位置即可
		// 同理三个数字的全排列可以看做，后两个交换位置后，三个数字位置互换
		// 从后向前第n位数字需要交换n-1
		for(int i=0;i<nums.length-index-1;i++) {
			// 首先当前位置以及后面所有的数字全部首位交换
			start = index;
			end = nums.length - 1;
			while(end>start) {
				t= nums[start];
				nums[start] = nums[end];
				nums[end] = t;
				end--;
				start++;
			}
			// 然后进入深搜
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
