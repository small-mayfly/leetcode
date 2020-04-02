package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 	没有很好的思路，只能暴力排查
 * 	 但考虑到可能会有剪枝的现象，所以实际复杂度应该低于O(n^4)
 * 	先对数组排序，复杂度n^2
 * 	然后暴力循环n^4
 * @author mayfly
 *
 */

public class Leetcode_4sum {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> tresult;
		Arrays.parallelSort(nums);
//		System.out.println(nums);
		int[] indexs = {0, 1, 2, 3};
		int now_result = 0;
		int[] flag= {0, 0};
		while(indexs[0]<nums.length-3) {
			while(indexs[1]<nums.length-2) {
				while(indexs[2]<nums.length-1) {
					while(indexs[3]<nums.length) {
						now_result = nums[indexs[0]]+nums[indexs[1]]+nums[indexs[2]]+nums[indexs[3]];
						if(now_result==target) {
							tresult = new LinkedList<Integer>();
							tresult.add(nums[indexs[0]]);
							tresult.add(nums[indexs[1]]);
							tresult.add(nums[indexs[2]]);
							tresult.add(nums[indexs[3]]);
							flag[1] = 0;
							for(int i=0;i<result.size();i++) {
								flag[0] = 0;
								for(int j=0; j<4; j++) {
									if(tresult.get(j) - result.get(i).get(j)==0) {
										flag[0]++;
									}else {
										break;
									}
								}
								if(flag[0]==4) {
									flag[1] = 1;
									break;
								}
							}
							if(flag[1]==0)
								result.add(tresult);
							else{
								tresult = null;
							}
						}else if(now_result>target) {
							indexs[2]++;
							indexs[3] = indexs[2]+1;
							continue;
						}
						indexs[3]++;
					}
					indexs[2]++;
					indexs[3] = indexs[2]+1;
				}
				indexs[1]++;
				indexs[2] = indexs[1]+1;
				indexs[3] = indexs[2]+1;
			}
			indexs[0]++;
			indexs[1] = indexs[0]+1;
			indexs[2] = indexs[1]+1;
			indexs[3] = indexs[2]+1;
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492};
		int target = 1682;
		Leetcode_4sum l4 = new Leetcode_4sum();
		List<List<Integer>> result = l4.fourSum(nums, target);
		System.out.println(result.size());
		System.out.println(result);
	}

}
