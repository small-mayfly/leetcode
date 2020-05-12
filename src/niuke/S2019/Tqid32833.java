package niuke.S2019;


import java.util.Scanner;

public class Tqid32833 {
    public static void main(String[] args){
        // 获取输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] as = new int[n];
        int[] ts = new int[n];
        for(int i=0;i<n;i++){
            as[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            ts[i] = in.nextInt();
        }
        // 记录最终结果
        int result = 0;
        // 如果叫醒一次，正堂课都可以清醒，则在开始上课时叫一次即可获得正堂课的全部知识点分值
        if(n<=k){
            for(int i=0;i<n;i++){
                result += (as[i]);
            }
        }else{
            // 获取最大的知识点分值，等价于求在叫醒后的k分钟内，新增的知识点分值的最大值+自己清醒时获得的知识点分值
            int tresult = 0;
            // 计算出新增的知识点分值的最大值
            for(int i=0;i<k;i++){
                result += (as[i]*(1-ts[i]));
            }
            tresult = result;
            for(int i=k;i<n;i++){
                tresult -= (as[i-k]*(1-ts[i-k]));
                tresult += (as[i]*(1-ts[i]));
                if(tresult>result){
                    result = tresult;
                }
            }
            // 计算出自己清醒时获得的知识点分值
            tresult = 0;
            for(int i=0;i<n;i++){
                tresult += (as[i]*ts[i]);
            }
            // 获取最终的总的知识点分值
            result += tresult;
        }
        System.out.println(result);

    }
}
