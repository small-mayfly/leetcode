package niuke.S2019;

import java.util.*;

public class Tqid32834 {
    /**
     * 对所有询问按照从小到大排序后依次计算，复杂度O(n)
     * @param args
     */
    public static void main(String[] args){


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] as = new int[n];
        for(int i=0;i<n;i++){
            as[i] = in.nextInt();
        }
        int m = in.nextInt();
        // hashmap.keySet()获取到的key是无序的，不是按照从小到大排序
        HashMap<Integer, Integer> qs = new HashMap<Integer, Integer>();
        int[] qst = new int[m];
        int[] qsrem = new int[m];
        for(int i=0;i<m;i++){
            qst[i] = in.nextInt();
            qsrem[i] = qst[i];
            qs.put(qst[i], 0);
        }

        Arrays.sort(qst);

        int tq = qst[0];
        int tindex = 1;
        int rem = tq;

        int index = 0;
        while(index<=n){
            if(tq>0){
                tq -= as[index];
                index++;
            }else{
                qs.put(rem, index);
                if(tindex<m){
                    int now = qst[tindex++];
                    tq += (now-rem);
                    rem = now;
                }else{
                    break;
                }
            }

        }

        for(int i=0;i<m;i++){
            System.out.println(qs.get(qsrem[i]));
        }


    }
}
