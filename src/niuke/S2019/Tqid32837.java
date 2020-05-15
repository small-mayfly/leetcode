package niuke.S2019;

import java.util.Scanner;

public class Tqid32837 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] as = new int[n];
        for(int i=0;i<n;i++){
            as[i] = in.nextInt();
        }
        int high, low, hindex, lindex;
        int min = Integer.MAX_VALUE;
        int opeNum = 0;
        int[] remx = new int[k];
        int[] remy = new int[k];
        for(int i=0;i<=k;i++){
            high = 0;
            low = 100000;
            hindex = -1;
            lindex = -1;
            // 找到最大最小值，同时记录index
            for(int j=0;j<n;j++){
                if(high<as[j]){
                    high = as[j];
                    hindex = j;
                }
                if(low>as[j]){
                    low = as[j];
                    lindex = j;
                }
            }
            // 如果当前稳定值比已知的所有稳定值都要小，则更新最小稳定值，同时记录获取当前稳定值操作的次数
            if(high-low<min){
                min = high - low;
                // 只是为了在末尾处
                opeNum = i;
            }
            // 除了最后一次不操作数组
            if(i<k){
                // 每次记录当前操作，同时最高塔高度-1，最低塔高度+1
                remx[i] = hindex+1;
                remy[i] = lindex+1;
                as[hindex]--;
                as[lindex]++;
            }
        }

        System.out.println(min + " " + opeNum);
        for(int i=0;i<opeNum;i++){
            System.out.println(remx[i]+" "+remy[i]);
        }



    }
}
