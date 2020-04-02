package easy;

public class RemoveDuplicatesfromSortedArray {
	/**
	 * 传入非递减的数组，所以如果后一个元素和当前元素相同，则是重复值，只需要将后面的值前移即可
	 * @param nums 传入非递减的数组
	 * @return 返回无重元素个数，并将无重元素按需放在nums的前几个位置
	 */
	public int removeDuplicates(int[] nums) {
		int result = nums.length;    // 首先假设数组无重，可以有重复再减
		if(result==0)   // 如果数组长度为0，则结果一定为0，直接返回即可
			return 0;
		// 因为无重元素需要放到数组前面，所以用一个标识位来记录当前确认到了第几个位置
		// 其实这个值执行到最后所在位置就是数组中非重复元素的个数，直接返回这个值即可
		int confirmIndex = 1;   
		int now_num = nums[0];   // 首先设定当前已经确定的第一个数为数组的第一个数
		for(int i=1; i<nums.length; i++) {   // 依次向后遍历一遍
			if(nums[i]>now_num) {   // 如果当前位置比前面的数字大，则一定是非重复的，移动到确认的位置
				nums[confirmIndex] = nums[i];   // 移动到确认的位置
				confirmIndex++;   // 获取下一个要确认的位置
				now_num = nums[i];   // 更新当前已经确定的数字
			}else {
				result--;   // 出现重复数字，非重复元素个数-1
			}
		}
        return result;   // 返回非重元素个数
    }
	
	public int removeDuplicates2(int[] nums) 
	{
        if(nums.length==0)
			return 0;
		int confirmIndex = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i]>nums[i-1]) {
				nums[confirmIndex++] = nums[i];
			}
		}
        return confirmIndex;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray rdfsa = new RemoveDuplicatesfromSortedArray();
		int[] datas = {0,0,1,1,1,2,2,3,3,4};
		int result = rdfsa.removeDuplicates(datas);
		System.out.println(result);
		System.out.println("----------------");
		for(int i=0;i<result;i++) {
			System.out.println(datas[i]);
		}

	}

}
