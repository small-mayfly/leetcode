package medium;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] rems = new int[amount+1];
        for(int i=1;i<=amount;i++)
            rems[i] = -1;
        for (int coin : coins) {
            for(int j=coin;j<=amount;j++){
                if(j-coin>=0 && rems[j-coin]>=0){
                    if(rems[j]>=0){
                        rems[j] = Math.min(rems[j-coin]+1, rems[j]);
                    }else {
                        rems[j] = rems[j-coin] + 1;
                    }
                }
            }
        }
        return rems[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 3;
        System.out.println(coinChange.coinChange(coins, amount));
    }
}
