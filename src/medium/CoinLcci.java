package medium;

import java.util.HashMap;

public class CoinLcci {



    public int waysToChange(int n) {

        if(n<=0)
            return 0;

        // 用于记录所有结果
        int[] rems = new int[n+1];
        int[] coins = {1, 5, 10, 25};


        for(int i=0;i<=n;i++)
            rems[i] = 1;

        for(int i=1;i<4;i++){
            int start = n%coins[i];
            for(int j=start;j<=n;j+=coins[1]){
                if(j-coins[i]>=0){
                    rems[j] += rems[j-coins[i]];
                    rems[j] %= 1000000007;
                }

            }
        }

        return rems[n];




    }

    public static void main(String[] args) {
        CoinLcci coinLcci = new CoinLcci();
        int n = 76;
        System.out.println(coinLcci.waysToChange(n));
    }

}
