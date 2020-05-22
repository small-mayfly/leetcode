package niuke.S2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class JM{
    int w,h;
    public JM(String init){
        String[] s = init.split(" ");
        w = Integer.valueOf(s[0]);
        h = Integer.valueOf(s[1]);
    }



}

/**
 * 首先将所有积木，按照h的大小顺序排列，之后去所有w，则只要按照当前顺序后面的w大于前面的w即可，转化为求最长非降序子序列长度即可
 */
public class Tqid32841 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        JM[] jms = new JM[n];
        for(int i=0;i<n;i++){
            jms[i] = new JM(in.nextLine());
        }
        Arrays.sort(jms, new Comparator<JM>() {
            @Override
            public int compare(JM o1, JM o2) {
                if(o1.h!=o2.h){
                    return o1.h - o2.h;
                }else{
                    return o1.w - o2.w;
                }
            }
        });
        int[] rems = new int[n+1];
        rems[0] = jms[0].w;
        int count = 1;
        int t;
        boolean flag;
        for(int i=1;i<n;i++){
            t = count-1;
            if(rems[t]<=jms[i].w){
                rems[count++] = jms[i].w;
            }else{
                t--;
                flag = true;
                while(t>=0){
                    if(rems[t]<=jms[i].w){
                        rems[t+1] = jms[i].w;
                        flag = false;
                        break;
                    }
                    t--;
                }
                if(flag){
                    rems[0] = jms[i].w;
                }
            }

        }
        System.out.println(count);

    }
}
