package niuke.S2019;

import java.util.*;



public class Tqid32828{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k  = in.nextInt();
        // 用以记录最终结果
        long result = 0;
        // 计算从k到num一共有多少个数字，要注意因为num从1开始，而k从0开始，所以要处理k==0的情况
        int num = k==0?(n - k):(n - k + 1);
        for(int i=k+1;i<=n;i++){
            int base = num;   // 记录从k到n共有多少个数字
            if(num/i>0){   // 如果k到n的数字数量大于k到i的数字数量，说明有多轮数字可以计算，则首先计算出每一轮有多少个数字，并记录进结果中，之后单独处理余数
                base = num % i;
                result += ((i-k)*(num/i));
            }
            // 处理数字数目中单一轮次的情况
            result += base>(i-k)?i-k:base;
        }
        System.out.println(result);
    }



}