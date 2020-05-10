package niuke.S2019;

import java.util.*;

public class Tqid32830 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // 获取闹钟数量
        int n = in.nextInt();
        int x,ab;
        int[] clocks = new int[n];
        int h,m;
        for(int i=0;i<n;i++){
            // 轮训获取闹钟时间，并直接转换为以当天时间0点起的分钟
            h = in.nextInt();
            m = in.nextInt();
            clocks[i] = h * 60 + m;
        }
        // 获取到教室所需时间
        x = in.nextInt();
        // 获取上课时间
        h = in.nextInt();
        m = in.nextInt();
        ab = h * 60 + m;
        // 计算出最晚起床时间
        ab -= x;
        // 将闹钟按照时间排序
        Arrays.sort(clocks);
        // 从最迟的闹钟开始向前遍历，找到闹钟时间不迟于最晚起床时间的闹钟即可
        for(int i=n-1;i>=0;i--){
            if(clocks[i]<=ab){
                h = clocks[i] / 60;
                m = clocks[i] % 60;
                System.out.println(h+" "+m);
                break;
            }
        }

    }
}
