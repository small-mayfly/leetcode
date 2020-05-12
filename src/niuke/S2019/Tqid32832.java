package niuke.S2019;

import java.util.*;

public class Tqid32832 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        // 记录每一列出现多少个方块
        int[] rem = new int[n+1];
        int t;
        for(int i=0;i<m;i++){
            t = in.nextInt();
            rem[t]++;
        }
        // 方块出现次数最小列就是分数
        t = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(t>rem[i]){
                t = rem[i];

            }
        }
        System.out.println(t);


    }
}
