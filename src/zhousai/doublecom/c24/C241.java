package zhousai.doublecom.c24;

/**
 * 确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue
 * 这句话换个说法就是，求出一组数连续和的最小值x，要求x+startValue>=1
 * 也就是startValue>=1-x
 */
public class C241 {
    public int minStartValue(int[] nums) {
        // 如果长度为0，则直接返回1
        if(nums.length==0){
            return 1;
        }else if(nums.length==1){   // 如果长度为1，只需要1-nums[0]即可
            return 1-nums[0];
        }
        // 遍历整个数组，找到连续和的最小值
        int minData = Integer.MAX_VALUE;
        int iter = 0;
        for (int num : nums) {
            iter += num;
            if(iter<minData){
                minData = iter;
            }
        }
        // 计算出结果
        minData = 1 - minData;
        // 题目要求求出的startValue是正数，所以返回之前加个判断
        return minData>0?minData:1;
    }

    public static void main(String[] args) {
        C241 c241 = new C241();
        int[] datas = {-3,2,-3,4,2};
        System.out.println(c241.minStartValue(datas));
    }
}
