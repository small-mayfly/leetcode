package niuke.S2019;

import java.util.*;

public class Tqid32847{

    public static boolean magic(int[] as, int w_s, int h_s, int p){
        long a = 0;
        for(int i=0;i<as.length;i++){
            if(as[i]%w_s>0){
                a+=1;
            }
            a += (as[i]/w_s);
        }
        long b = h_s * p;
        if(a<=b){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] nphw = in.nextLine().split(" ");
        int n = Integer.parseInt(nphw[0]);
        int p = Integer.parseInt(nphw[1]);
        int h = Integer.parseInt(nphw[2]);
        int w = Integer.parseInt(nphw[3]);

        String[] asd = in.nextLine().split(" ");
        int[] as = new int[asd.length];
        int asum = 0;
        for(int i=0;i<n;i++){
            as[i] = Integer.parseInt(asd[i]);
            asum += as[i];
        }
        // 首先计算出不小于上限的值
        long temp = 1;
        temp *=h;
        temp *= p;
        temp *= w;
        if(temp%asum==0){
            temp /= asum;
        }else{
            temp = temp / asum + 1;
        }
        int s = (int)Math.sqrt(temp);
        if(s*s<temp){
            s += 1;
        }
        // 从预计最大值开始，从大向小遍历
        for(;s>0;s--){
            if(magic(as, w/s, h/s, p)){
                System.out.println(s);
                break;
            }
        }


    }
}