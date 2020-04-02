package medium;

public class NextPermutation {
	/**
	 * 组合数学全排列题
	 * 获取增序排列的某一个排列的下一个排列，如果是增序排列的最后一种排列情况，则返回增序排列的第一种情况
	 * 这种情况只需要从后向前依次超找，找出是否存在顺序递增的情况，如果存在则当前位置进行修改则一定影响总数最小，也就当前位置值a较小，和a后比a大的最小值交换位置，然后将a之后的所有数值顺序排列，此时数值一定是下一种排列
	 * 
	 * @param nums 当前排列数组
	 */
	public void nextPermutation(int[] nums) {
		int flag = -1;   // 用以标志出，当前数字是否是需要交换的第一个数字，如果是则改为任意非-1值
		int fIndex = nums.length-2;   // 记录当前遍历的开始位置
		int tIndex = 0;   // 临时记录当前向后查询位置
		int rem = 0;   // 记录比fIndex位置的值大的最小值的大小
		int remIndex = 0;  // 记录rem的位置
		while(fIndex>=0) {   // 从后向前，依次遍历，遍历到头部位置
			tIndex = fIndex + 1;   // 从findex后开始向后找比nums[fIndex]大的最小值
			while(tIndex<nums.length) {   // 到结尾处开始下一轮查找
				if(nums[fIndex]<nums[tIndex]) {   // 存在数字顺序增的情况，这一轮应该进行数字交换
					if(flag==-1) {   // 判断是否是找到的第一个大于nums[fIndex]的最小值
						rem = nums[tIndex];   // 记录当前已知的大于nums[fIndex]的最小值
						remIndex = tIndex;   // 记录rem位置
					}
					else {
						if(rem>nums[tIndex]) {   // 新的大于nums[fIndex]的最小值比已知的要小则进行更新
							rem = nums[tIndex];   // 更新当前已知的大于nums[fIndex]的最小值
							remIndex = tIndex;   // 更新rem位置
						}
					}
					flag = 0;   // 修改标志位
				}
				tIndex++;   // 依次向后找一遍，才能知道是否是fIndex之后大于nums[fIndex]的最小值
			}
			if(flag==0) {   // 当前轮次，已经找到下一个排列序的数值，不需要继续向下查找
				break;
			}
			fIndex--;   // 如果没有查找到下一个排列序的数值，继续向下查找
		}
		if(flag==-1) {   // 遍历一遍都是倒序的，说明已经是增序排列的最后一种情况，所以要返回增序排列的第一种情况
			// 因为增序排列的最后一种情况和增序排列的第一种情况，一个是1 to n，一个是n to 1 正好位置想替换，所以不需要排序，直接收尾换位置即可
			fIndex = 0;   // 记录头指针
			tIndex = nums.length-1;   // 记录尾指针
			while(fIndex<tIndex && tIndex-fIndex>0) {   // 当两个指针相撞，说明已经交换一遍，结束
				// 交换位置
				flag = nums[fIndex];
				nums[fIndex] = nums[tIndex];
				nums[tIndex] = flag;
				// 头指针向后走一步
				fIndex++;
				// 尾指针向前走一步
				tIndex--;
			}
		}else {
			tIndex = remIndex;   // 记录比fIndex大的最小值的位置
			// 首先交换第一位
			flag = nums[fIndex];
			nums[fIndex] = nums[tIndex];
			nums[tIndex] = flag;
			// 然后交换剩余位置,剩余位置排序，冒泡排序，不加注释了
			fIndex++;
			for(int i=fIndex;i<nums.length;i++) {
				for(int j=i+1;j<nums.length;j++) {
					if(nums[i]>nums[j]) {
						flag = nums[i];
						nums[i] = nums[j];
						nums[j] = flag;
					}
				}
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation np = new NextPermutation();
		int[] nums = {1, 3, 2};
		np.nextPermutation(nums);
		for(int i=0; i<nums.length; i++)
			System.out.println(nums[i]);
	}
}
