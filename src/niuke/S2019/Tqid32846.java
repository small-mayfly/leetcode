package niuke.S2019;


import java.util.*;

/**
 * 动态规划
 * 两个指针，一个从前向后，一个从后向前，依次深搜
 * 当从前向后的指针不小于从后向前的指针时，深搜结束
 */
public class Tqid32846{
    public static int[][] rems;
    public static int magic(String str, int index1, int index2, int max){
        // 遇到边界，直接返回
        if(index1>=max || index2<0){
            return 0;
        }
        // 两个指针相遇，则为中间值
        if(index1==index2){
            return 1;
        }else if(index1>index2){   // 指针擦肩而过，结束深搜
            return 0;
        }
        // 如果已经记录当前值，则直接返回
        if(rems[index1+1][index2+1]>0){
            return rems[index1+1][index2+1];
        }
        // 深搜查找最大值
        int a;
        if(str.charAt(index1)==str.charAt(index2)){
            a = magic(str, index1+1, index2-1, max)+1;
        }else{
            a = magic(str, index1+1, index2, max);
            int b = magic(str, index1, index2-1, max);
            if(a<b){
                a = b;
            }
        }
        rems[index1+1][index2+1] = a;
        return a;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        rems = new int[str.length()+1][str.length()+1];
        System.out.println(magic(str, 0, str.length()-1, str.length()));


    }
}