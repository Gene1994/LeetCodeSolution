package dynamicProgramming;

/**
 * @author: create by Gene1994
 * @date:2018/12/31
 */

import java.util.Arrays;

/**
 * No.322 Coin Change
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null)
            return -1;
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        if (amount < coins[0])
            return -1;
//        for (int i = coins[0]; i <= amount; i++) {
//            dp[i] = amount+1;
//        }
        Arrays.fill(dp,amount+1);
//        for (int i = 0; i < coins.length; i++) {
//            dp[coins[i]] = 1;
//        }
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            int tmp = dp[i];
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] i = {2};
        System.out.println(c.coinChange(i,3));
    }
}
