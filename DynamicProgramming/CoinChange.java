package DynamicProgramming;

public class CoinChange {

    // Driver Program
    public static void main(String[] args) {

        int amount = 12;
        int[] coins = {2, 4, 5};

        System.out.println("Number of combinations of getting change for " + amount + " is: " + change(coins, amount));
        System.out.println("Minimum number of coins required for amount :" + amount + " is: " + minimumCoins(coins, amount));

    }

    /*This method finds the number of combinations of getting change for a given amount and change coins*/
    public static int change(int[] coins, int amount) {

        int[] combinations = new int[amount + 1];
        combinations[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                combinations[i] += combinations[i - coin];
            }
            // Uncomment the below line to see the state of combinations for each coin
            // printAmount(combinations);
        }

        return combinations[amount];
    }

    /*This method finds the minimum number of coins needed for a given amount.*/
    public static int minimumCoins(int[] coins, int amount) {
        //minimumCoins[i] will store the minimum coins needed for amount i
        int[] minimumCoins = new int[amount + 1];

        minimumCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            minimumCoins[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int sub_res = minimumCoins[i - coin];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < minimumCoins[i])
                        minimumCoins[i] = sub_res + 1;
                }
            }
        }
        // Uncomment the below line to see the state of combinations for each coin
        //printAmount(minimumCoins);
        return minimumCoins[amount];
    }

    // A basic print method which prints all the contents of the array
    public static void printAmount(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
