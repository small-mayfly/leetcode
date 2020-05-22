package niuke.S2019;

import java.util.*;

/**
 * 动态规划，记事本，从前向后依次计算
 */
public class Tqid32842 {
    static long[] rems = new long[1001];

    public static long magic(int index){
        if(rems[index]>0){
            return rems[index];
        }
        long sum = 0;
        int start = 1;
        while(start<=index){
            sum += magic(index-start);
            sum %= 1000000003;   // 这是一个比较坑的地方，题目最下方写了要取余，不取余long类型也会溢出
            start <<= 1;
        }
        rems[index] = sum;
        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        rems[0] = 1;
        rems[1] = 1;
        rems[2] = 2;
        rems[3] = 3;
        rems[4] = 6;
        int m = in.nextInt();
        int index = 0;
        int n;
        while(index<m){
            n = in.nextInt();
            if(n==0){
                System.out.println(0);
            }else{
                System.out.println(magic(n));
            }
            index++;
        }


    }
}
