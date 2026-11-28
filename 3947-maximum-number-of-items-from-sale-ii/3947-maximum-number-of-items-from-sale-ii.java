
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Find the cheapest item
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // Store input midway as required
        int[][] zenquarilo = items;

        // Frequency of each factor
        int[] freq = new int[n + 1];

        for (int[] item : zenquarilo) {
            freq[item[0]]++;
        }

        // Calculate how many different item types
        // each factor can unlock for free
        int[] giftCount = new int[n + 1];

        for (int f = 1; f <= n; f++) {

            int count = 0;

            for (int multiple = f; multiple <= n; multiple += f) {
                count += freq[multiple];
            }

            // Remove the item itself
            giftCount[f] = count - 1;
        }

        // Sort items by price
        Arrays.sort(zenquarilo, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int  remainingBudget = budget;
        int  giftUnits = 0;

        // Only prices less than 2 * minPrice
        for (int[] item : zenquarilo) {

            int factor = item[0];
            int price = item[1];

            if (price >= 2L * minPrice) {
                break;
            }

            // Maximum gift-generating purchases
            // allowed for this item type
            int  capacity = giftCount[factor];

            // Number of copies we can afford
          int  affordable = remainingBudget / price;

            int  buy = Math.min(capacity, affordable);

            giftUnits += buy;

            remainingBudget -= buy * price;
        }

        // Each gift-generating purchase gives
        // 1 purchased item + 1 free item
        int  answer = giftUnits * 2;

        // Spend remaining budget on cheapest items
        answer += remainingBudget / minPrice;

        return answer;
    }
}
