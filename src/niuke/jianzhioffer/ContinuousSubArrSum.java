package niuke.jianzhioffer;

/**
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484
 */
public class ContinuousSubArrSum {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)
            return 0;
        // 首先初始化记录值
        // 从头开始遍历一遍
        int start = 0;
        // 以第一个值的结果为当前最大结果
        int result = array[start++];
        // 记录某一段子序列的和
        int nowResult = result;
        // 依次循环遍历
        while (start<array.length){
            // 如果之前的子序列和小于0，那么从当前位置开始计算
            if(nowResult<0){
                nowResult = array[start];
            }else{
                nowResult += array[start];
            }
            if(nowResult>result)
                result = nowResult;
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        ContinuousSubArrSum continuousSubArrSum = new ContinuousSubArrSum();
        int[] data = {-2,-8,-1,-5,-9};
        System.out.println(continuousSubArrSum.FindGreatestSumOfSubArray(data));
    }
}

