package medium;
public class SearchinRotatedSortedArray {
	/**
	 * 将数组分为经过旋转的，和未经过旋转的两类进行处理。
	 * 	未经过旋转的数组就是增序序列使用二分查找
	 * 	经过旋转的数组需要判断边界条件，经过旋转的增序数组有个特点就是nums[0]>nums[nums.length-1]，因此这是已经进行了一次天然的分隔
	 * 		如果target>nums[0]，则target范围为(nums[0], max(nums)]
	 * 		如果target<nums[nums.length-1]，则target的范围为[min(nums), nums[nums.length-1])
	 * 		这时虽然已经知道范围，但是不知道旋转了多少步，所以只能再次依靠mid数来进行判断
	 * @param nums 传入的数组
	 * @param target 目标数
	 * @return
	 */
	public int search(int[] nums, int target) {
		if(nums.length==0)   // 如果数组长度，则一定找不到目标
			return -1;
		if(nums.length==1) {   // 如果数组长度为1，只需要判断第一个数是否和target相等即可
			if(nums[0]==target)
				return 0;
			else
				return -1;
		}
		int result = -1;   // 假设找不到结果，找到结果就进行赋值
		int left = 0;   // 初始化二分左边界
		int right = nums.length-1;   // 初始化二分右边界
		int mid;   // 设置中间位置索引
		if(nums[left]>nums[right]) {   // 一定发生了旋转
			while(right>=left) {   // 只要边界还在就继续查找
				if(nums[left]==target) {   // 如果等于当前数组的子数组的左边界，直接赋值并停止
					result = left;
					break;
				}else if(nums[right]==target) {// 如果等于当前数组的子数组的右边界，直接赋值并停止
					result = right;
					break;
				}else if(nums[left]>nums[right]) {   // 判断当前子数组是否是增序的，如果不是则需要判断
					mid = (left+right)/2;   // 获取中间位置
					if(nums[mid]==target) {   // 找到target所在位置，赋值停止
						result = mid;
						break;
					}
					if(target>nums[left]) {   // 比左边界大
						// 如果中间数值比左边界还大，则最大值在(nums[left],nums[mid])之间，所以结果应该在(left,mid)之间
						if(nums[left]>nums[mid]) {   
							right = mid -1;
							left++;
						}else { // 否则最大值在mid的右边，此时有两种情况(相等的情况已经在之前排除)
							// 第一种情况，比nums[mid]还大，说明结果在(mid, right)之间
							if(target>nums[mid]) {
								left = mid + 1;
								right--;
							}else {   // 第二种情况，比nums[mid]小，此时结果在(left,mid)之间
								right = mid - 1;
								left++;
							}
						}
					}else {  // 此时比右边界小
						// 如果中间数值比右边界大，则最大值在(nums[mid],nums[right])之间，所以结果应该在(mid,right)之间
						if(nums[mid]>nums[right]) {
							left = mid +1;
							right--;
						}else {  // 有两种情况
							// 第一种情况，比nums[mid]大，说明结果在(mid, right)之间
							if(target>nums[mid]) {
								left = mid + 1;
								right--;
							}else {   // 第二种情况，比nums[mid]小，此时结果在(left,mid)之间
								right = mid - 1;
								left++;
							}
						}
					}
				}else {   // 当前小段是有序的，进行二分查找
					if(nums[left]==target) {
						result = left;
						break;
					}else if(nums[right]==target) {
						result = right;
						break;
					}else {
						mid = (left+right)/2;
						if(nums[mid]==target) {
							result = mid;
							break;
						}else {
							if(nums[mid]>target) {
								right = mid - 1;
								left++;
							}else {
								left = mid + 1;
								right--;
							}
						}
					}
				}
			}
		}else {   // 初始状态排序，可能已经旋转过，但是旋转回初始状态了
			// 顺序排序状态，只需要按照正常的二分查找即可
			while(right>=left) {
				// 出现相等结束程序
				if(nums[left]==target) {
					result = left;
					break;
				}else if(nums[right]==target) {
					result = right;
					break;
				}else {
					// 否则截取一半计算
					mid = (left+right)/2;
					if(nums[mid]==target) {
						result = mid;
						break;
					}else {
						// 比中心小，则在左半部分
						if(nums[mid]>target) {
							right = mid - 1;
							left++;
						}else {   // 比中心大，则在最又部分
							left = mid + 1;
							right--;
						}
					}
				}
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();
		int[] datas = {5,1,2,3,4};
		System.out.println(srsa.search(datas, 1));
	}
}
