package niuke.S2019;

import java.util.*;

/**
 * 利用KMP算法
 */
public class Tqid32850{

    public static int magic(String ms, String ss){
        // 首先处理字符串等长的情况
        if(ms.length()==ss.length()){
            for(int i=0;i<ss.length();i++){
                if(ms.charAt(i)!=ss.charAt(i)){
                    return 0;
                }
            }
            return 1;
        }
        int index = 0;
        int indexs = 0;
        // 计算子串比较记录数组
        int[] rems = new int[ss.length()+1];
        rems[0] = -1;
        rems[1] = -1;
        for(int i=1;i<ss.length();i++){
            char c = ss.charAt(i);
            index = 0;
            for(int j=i-1;j>=0;j--){
                if(c==ss.charAt(j)){
                    index = j;
                    break;
                }
            }
            rems[i+1] = index - 1;
        }
        index = 0;
        indexs = 0;
        // 开始从头到尾比较
        for(int i=0;i<ms.length();i++){
            if(ms.charAt(i)==ss.charAt(indexs)){
                indexs++;
                // 如果子串遍历完毕，说明存在包含关系，直接返回
                if(indexs>=ss.length()){
                    return 1;
                }
            }else{
                // 处理回朔的情况
                indexs = rems[indexs];
                // 子串重新开始
                if(indexs<0){
                    indexs = 0;
                }else{   // 子串从匹配的地方开始
                    indexs++;
                    if(indexs>=ss.length()){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String[] strs = in.nextLine().split(" ");
            // 处理只有一个字符串或者是空的情况，一定是包含的，因为str包含空，空也包含空
            if(strs.length<2){
                System.out.println(1);
            }
            // 加个判断，找出长度较大的字符串，作为函数的第一个参数
            if(strs[0].length()>strs[1].length()){
                System.out.println(magic(strs[0], strs[1]));
            }else{
                System.out.println(magic(strs[1], strs[0]));
            }
        }

    }
}