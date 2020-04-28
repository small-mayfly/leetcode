package medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        if(target==nums[0])
            return 0;
        else if(target>nums[0]){
            int index = 1;
            while (index<nums.length && nums[index]>nums[index-1]){
                if(target==nums[index]){
                    return index;
                }
                if(target<nums[index])
                    return -1;
                index++;
            }
            return -1;
        }else if(target<nums[0]){
            if(target==nums[nums.length-1]){
                return nums.length-1;
            }
            int index = nums.length-2;
            while (index>0 && nums[index]<nums[index+1]){
                if(target==nums[index])
                    return index;
                if(target>nums[index])
                    return -1;
                index--;
            }
            return -1;
        }

        return 0;
    }
}
