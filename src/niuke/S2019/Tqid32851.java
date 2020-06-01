package niuke.S2019;

import java.util.*;

public class Tqid32851 {
    public static int magic(int[] rems, int x){
        if(rems[x]>0){
            return rems[x];
        }
        if(x<3){
            return -1;
        }
        if(rems[x]==-1){
            return -1;
        }
        int max = -1;
        int t;
        if(x==7){
            max = 1;
        }else if(x-7>0){
            max = magic(rems, x-7);
            if(max>0)
                max += 1;
        }
        if(x==5){
            max = 1;
        }else if(x-5>0){
            t = magic(rems, x-5)+1;
            if(t>0){
                if(max>0){
                    max = max<t?max:t;
                }else{
                    max = t;
                }
            }
        }
        if(x==3){
            max = 1;
        }else if(x-3>0){
            t = magic(rems, x-3)+1;
            if(t>0){
                if(max>0){
                    max = max<t?max:t;
                }else{
                    max = t;
                }
            }
        }
        rems[x] = max;
        return max;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int[] rems = new int[10001];
        rems[3] = 1;
        rems[5] = 1;
        rems[7] = 1;
        System.out.println(magic(rems, x));
    }
}
