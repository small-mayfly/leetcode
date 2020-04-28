package niuke.S2019;

import java.util.Arrays;

public class Tqid33422 {


    public long magic1(int[] nums){

        Arrays.sort(nums);
        long result = 0;
        int len = nums.length;
        int remIndex = 0;
        for(int i=0;i<len;i++){
            long tresult = nums[i] * (len-i);
            if(tresult>result){
                result = tresult;
                remIndex = i;
            }
        }
        System.out.println(remIndex);
        return remIndex;
    }


    /**
     * 返回两次操作后，数组元素之和的最小值
     * @param nums int整型一维数组 这你你需要操作的数组
     * @return long长整型
     */
    public long minimumValueAfterDispel (int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length<3){
            long result = 0;
            for (int num : nums) {
                result += num;
            }
            return result;
        }
        return magic1(nums);
    }

    public static void main(String[] args) {
        Tqid33422 tqid33422 = new Tqid33422();
        int[] datas = {2,1,3};
        System.out.println(tqid33422.minimumValueAfterDispel(datas));
    }
}
