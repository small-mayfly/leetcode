package medium;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
	
	/**
	 * 对于数组中的每个值，都有选择和不选择两种情况，所以可以利用二进制进位的想法来进行数字的选择
	 * 对于长度为n的nums中的n个值，选择置为1，不选置为0，则共有：0000...0~1111...1这么多种情况，且无重复
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		// 当nums为空，直接返回空即可
		if(nums.length==0)
			return null;
		// 000...0~111...1共有2^n种情况
		int numsCount = 1<<nums.length;
		// 记录最终结果
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		// 生成数组用于记录01
		int[] rems = new int[nums.length];
		// 记录进位
		int front = 0;
		for(int i=0;i<numsCount;i++) {
			// 每次+1，然后进位
			front = 1;
			for(int j=nums.length-1;j>-1;j--) {
				if(rems[j]+front>1) {
					rems[j] = 0;
				}else {
					rems[j]++;   // 遇到不再需要进位的时候，直接退出即可，再前面的值不会再改变
					break;
				}
			}
			// 记录选择的值
			List<Integer> result = new LinkedList<Integer>();
			// 如果不为0，说明要选择它
			for(int j=0;j<nums.length;j++) {
				if(rems[j]>0) {
					result.add(nums[j]);
				}
			}
			// 将当前选择的结果添加到最终结果中
			results.add(result);
		}
		return results;
    }
	/**
	 * 利用递归的思想，从空集合开始，每次将一个数字添加到要计算的结果中
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
			// 记录当前已经有了多少个结果
			nowLen = results.size();
			// 对每个结果，都加上当前值
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
