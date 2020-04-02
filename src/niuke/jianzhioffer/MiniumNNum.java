package niuke.jianzhioffer;

import java.util.ArrayList;

/**
 * topk算法
 */
public class MiniumNNum {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> results = new ArrayList<>();
        if(input.length==0 || input.length<k || k==0)
            return results;
        else if(input.length==1){
            results.add(input[0]);
            return results;
        }
        else{
            int rem,temp;
            // 构建小顶堆
            for(int i=1;i<input.length;i++){
                rem = i+1;
                while (rem>1){
                    if(input[rem-1] < input[rem/2-1]){
                        temp = input[rem-1];
                        input[rem-1] = input[rem/2-1];
                        input[rem/2-1] = temp;
                        rem /= 2;
                    }else{
                        break;
                    }
                }
            }
            // 依次插入结果数组中，每次取堆顶最小值
            results.add(input[0]);
            int upper;
            for(int i=1;i<k;i++){
                upper = input.length-i;
                input[0] = input[upper];
                rem = 1;
                while(rem<upper){
                    if(rem*2<upper){
                        if(input[rem*2-1]<input[rem*2] && input[rem-1]>input[rem*2-1]){
                            temp = input[rem-1];
                            input[rem-1] = input[rem*2-1];
                            input[rem*2-1] = temp;
                            rem = rem * 2 - 1;
                        }else{
                            if(input[rem-1]>input[rem*2]){
                                temp = input[rem-1];
                                input[rem-1] = input[rem*2];
                                input[rem*2] = temp;
                                rem = rem * 2;
                            }else{
                                break;
                            }
                        }
                    }else if(rem*2-1<upper){
                        if(input[rem-1]>input[rem*2-1]){
                            temp = input[rem-1];
                            input[rem-1] = input[rem*2-1];
                            input[rem*2-1] = temp;
                            rem *= 2;
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                }
                results.add(input[0]);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        MiniumNNum miniumNNum = new MiniumNNum();
        int[] data = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> integers = miniumNNum.GetLeastNumbers_Solution(data, k);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }


}
