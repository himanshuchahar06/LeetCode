
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // dp[b] = maximum items obtained using at most b budget
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        // Step 1: Calculate the minimum price
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
        }

        // Step 2: 0/1 Knapsack
        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            // Count free items from buying this item first
            int freeCount = 0;

            for (int j = 0; j < n; j++) {

                if (i != j && items[j][0] % factor == 0) {
                    freeCount++;
                }
            }

            // First purchase gives 1 purchased + freeCount
            int value = 1 + freeCount;

            // 0/1 Knapsack: traverse backwards
            for (int b = budget; b >= price; b--) {

                dp[b] = Math.max(
                    dp[b],
                    dp[b - price] + value
                );
            }
        }

        // Step 3: Use remaining budget to buy cheapest items
        int answer = 0;

        for (int b = 0; b <= budget; b++) {

            int remaining = budget - b;

            int extraItems = remaining / minPrice;

            answer = Math.max(
                answer,
                dp[b] + extraItems
            );
        }

        return answer;
    }
}
