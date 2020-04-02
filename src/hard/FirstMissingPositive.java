package hard;

/**
 * 总体思路为每次都把能找到的正数k放在对应的位置k-1上
 * 解题思路是一种深度搜索
 * 	每次找到一个可以深入的情况深入搜索，如果找不到了就结束
 * 	虽然这样看似复杂度为O(n^2)，但是由于位置正确就不需要遍历，而且1，n个无序连续数组放到对应位置最多只需要交换n次，所以总的交换次数不大于n次
 * @author mayfly
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		// 如果数组为空，则缺失的最小值为1
		if(nums.length==0)
			return 1;
		int temp=-1;   // 记录临时变量
		int nowIndex;   // 记录内循环时，所在位置
		// 依次向后遍历，每次找到位置与数字不对应的情况就进行循环修改位置
		for(int i=0;i<nums.length;i++) {
			nowIndex=i;   // 当前在第i个位置
			// 如果当前位置的值不在1~nums.length之间，则无法放在对应位置，结束循环
			while(nums[nowIndex]>0 && nums[nowIndex]<=nums.length) {
				// 防止出现位置k和位置m数字都是k+1，导致死循环的情况
				if(nums[nowIndex]==temp) {
					break;
				}
				// 找到一个位置不对应的数字，直接交换
				if(nums[nowIndex]-1!=i) {
					temp = nums[nowIndex];
					nums[nowIndex] = nums[nums[nowIndex]-1];
					nums[temp-1] = temp;
				}else {
					break;   // 当前位置与数字对应，则进入下一个循环，判断下一个index
				}
			}
		}
		for(int i = 0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
		
	}

	public static void main(String[] args) {
		
		FirstMissingPositive fmp = new FirstMissingPositive();
		int[] data = {1,1};
		
		System.out.println(fmp.firstMissingPositive(data));

	}

}
