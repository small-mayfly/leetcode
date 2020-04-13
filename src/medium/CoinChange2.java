package medium;

import java.util.Arrays;

public class CoinChange2 {

    public int change2(int amount, int[] coins){
        Arrays.sort(coins);
        int[] rems = new int[amount+1];
        rems[0] = 1;
        for(int i=1;i<coins.length+1;i++) {
            for (int j = 1; j < amount + 1; j++) {
                if(j-coins[i-1]>=0){
                    rems[j] += rems[j-coins[i-1]];
                }
            }
        }
        return rems[amount];
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] rems = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            rems[i][0] = 1;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j-coins[i-1]>=0){
                    rems[i][j] = rems[i-1][j] + rems[i][j-coins[i-1]];
                }else{
                    rems[i][j] = rems[i-1][j];
                }
            }
        }
        return rems[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(coinChange2.change2(amount, coins));


    }
}
