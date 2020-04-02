package medium;

public class FindFirstandLastPositionofElementinSortedArray {
	/**
	 * 找到target第一次出现的地方
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public int getLeft(int[] nums, int left, int right) {
		if(left == right)  // 如果left==right说明这就是边界，直接返回
			return left;
		else {
			int target = nums[right];   // 此时左右边就是目标
			int result = left;   //假设左边界为left
			int mid=left;  // 设置中间位置
			while(left<right) {   // 使用二分法找到左边界
				mid = (left+right)/2;   // 中间位置
				if(nums[mid]<target) {   // 如果中间<target说明左边界在mid右边，更新当前可能的左边界
					left = mid + 1;
				}else {
					// 这里与顺序二分有点区别就是相等条件的判断上
					if(mid>0 && nums[mid-1]==target) {   // 如果不是最左边，并且现在中间位置仍然==target，所以继续向左查找
						right = mid - 1;
					}else if(mid>0 && nums[mid-1]<target) {   // 这种条件就是左边界直接返回
						break;
					}else{   // 只剩下mid==0的情况，直接返回
						break;
					}
				}
			}
			if(left==right)
				return left;
			return mid;
		}
	}
	/**
	 * 与寻找左边界思路一样，不过是对称操作
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public int getRight(int[] nums, int left, int right) {
		if(left == right) {
			return left;
		}else {
			int target = nums[left];
			int result = left;
			int mid = left;
			while(left<right) {
				mid = (left+right)/2;
				if(nums[mid]>target) {
					right = mid - 1;
				}else {
					if(mid<right && nums[mid+1]==target) {
						left = mid + 1;
					}else if(mid<right && nums[mid+1]<target) {
						break;
					}else {
						break;
					}
				}
			}
			if(left==right)
				return left;
			return mid;
		}
	}
	
	/**
	 * 按照常规思路来进行查找，先通过二分法找到目标所在位置之一，然后通过二分法来确定左右边界
	 * @param nums 数组
	 * @param target 目标
	 * @return 边界数组
	 */
	public int[] searchRange(int[] nums, int target) {
		if(nums.length==0) {   // 如果长度为0，则target一定不存在数据中
			int[] result = {-1, -1};
			return result;
		}else if(nums.length==1) {   // 如果数据长度为1，则只需要判断是否等于target即可
			if(target==nums[0]) {
				int[] result = {0, 0};
				return result;
			}else {
				int[] result = {-1, -1};
				return result;
			}
		}else {   // 开始查找
			int left = 0;   // 初始化左边界
			int right = nums.length-1;   // 初始化右边界
			int mid=0;   // 设置mid，用于超找中间位置
			int flag = 0;   // 用于标记是否找到target
			while(right>=left) {   // 使用二分法找到target位置中的一个
				mid = (right+left)/2;
				if(nums[mid]==target) {
					flag = 1;
					break;
				}else if(nums[mid]>target) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}
			if(flag==0) {   // 如果没有找到target，直接返回找不到即可
				int[] result = {-1, -1};
				return result;
			}else {
				left = getLeft(nums, left, mid);   // 找到左边界，也就是target第一次出现的地方
				right = getRight(nums, mid, right);   // 找到右边界，也就是target最后一次出现的地方
				int[] result = {left, right};
				return result;
			}
		}
			
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstandLastPositionofElementinSortedArray fflpes = new FindFirstandLastPositionofElementinSortedArray();
		int[] datas = {2,2};
		int target = 2;
		int[] result = fflpes.searchRange(datas, target);
		System.out.println(result[0]);
		System.out.println(result[1]);
		

	}

}
