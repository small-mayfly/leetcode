package niuke.S2019;

import java.util.Scanner;

public class Tqid32838 {
    public static void magic(int[] rems, long k, int n, int m){
        int index = 0;
        int mt;
        k--;
        while(k>0){
            index = n+m-1;
            while(index>0){
                if(rems[index]>rems[index-1]){
                    index--;
                    break;
                }
                index--;
            }
            if(rems[index]<rems[index+1]){
                rems[index] = 1;
                rems[index+1] = 0;
                mt = 0;
                for(int i=index+1;i<n+m;i++){
                    mt += rems[i];
                }
                for(int i=n+m-1;i>index;i--){
                    if(mt>0){
                        rems[i] = 1;
                        mt--;
                    }else{
                        rems[i] = 0;
                    }
                }
            }
            k--;
        }
        char[] tresults = {'a', 'z'};
        for(int i=0;i<m+n;i++){
            System.out.print(tresults[rems[i]]);
        }
        System.out.println();
    }

    public static long cmn(int n, int m){

        long allNum = 1;
        if(n>m){
            for(int i=n+1;i<=m+n;i++){
                allNum *= i;
                allNum /= (i-n);
            }
        }else{
            for(int i=m+1;i<=m+n;i++){
                allNum *= i;
                allNum /= (i-m);
            }
        }

        return allNum;

    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        long allNum = cmn(n, m);
        if(allNum<k){
            System.out.println("-1");
            return;
        }
        int[] rems = new int[n+m];

        if(k==1){
            for(int i=m+n-1;i>=n;i--)
                rems[i] = 1;
            for(int i=0;i<m+n;i++){
                System.out.print(rems[i]);
            }
            System.out.println();
            return;
        }

        int index = 1;
        k--;
        for(;index<=n;index++){
            long t = cmn(m-1+index, index);
            k -= t;
            if(k<=0){
                break;
            }
        }
        int tindex = 0;
        while (tindex<n-index){
            rems[tindex++] = 0;
        }
        rems[tindex++] = 1;
        for(int i=0;i<index;i++){
            rems[tindex++] = 0;
        }
        for(int i=0;i<m-1;i++){
            rems[tindex++] = 1;
        }
        k += cmn(m-1+index, index);






    }
}
