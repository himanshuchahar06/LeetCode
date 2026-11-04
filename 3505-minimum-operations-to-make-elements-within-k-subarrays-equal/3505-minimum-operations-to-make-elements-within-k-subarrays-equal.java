import java.util.*;

class Solution {

    TreeMap<Long, Integer> left = new TreeMap<>();
    TreeMap<Long, Integer> right = new TreeMap<>();

    long sumLeft = 0;
    long sumRight = 0;

    int sizeLeft = 0;
    int sizeRight = 0;

    void add(long val) {

        if (left.isEmpty() || val <= left.lastKey()) {
            left.put(val, left.getOrDefault(val, 0) + 1);
            sumLeft += val;
            sizeLeft++;
        } 
        else {
            right.put(val, right.getOrDefault(val, 0) + 1);
            sumRight += val;
            sizeRight++;
        }

        balance();
    }

    void remove(long val) {

        if (left.containsKey(val)) {
            removeValue(left, val);
            sumLeft -= val;
            sizeLeft--;
        } 
        else {
            removeValue(right, val);
            sumRight -= val;
            sizeRight--;
        }

        balance();
    }

    void removeValue(TreeMap<Long, Integer> map, long val) {

        int count = map.get(val);

        if (count == 1) {
            map.remove(val);
        } 
        else {
            map.put(val, count - 1);
        }
    }

    void balance() {

        int target = (sizeLeft + sizeRight + 1) / 2;

        while (sizeLeft > target) {

            long val = left.lastKey();

            removeValue(left, val);
            sumLeft -= val;
            sizeLeft--;

            right.put(val, right.getOrDefault(val, 0) + 1);
            sumRight += val;
            sizeRight++;
        }

        while (sizeLeft < target) {

            long val = right.firstKey();

            removeValue(right, val);
            sumRight -= val;
            sizeRight--;

            left.put(val, left.getOrDefault(val, 0) + 1);
            sumLeft += val;
            sizeLeft++;
        }
    }

    long getCost() {

        long median = left.lastKey();

        return median * sizeLeft - sumLeft
             + sumRight - median * sizeRight;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        // First window
        for (int i = 0; i < x; i++) {
            add(nums[i]);
        }

        cost[0] = getCost();

        // Sliding window
        for (int i = x; i < n; i++) {

            remove(nums[i - x]);
            add(nums[i]);

            cost[i - x + 1] = getCost();
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Skip current position
                dp[j][i] = dp[j][i - 1];

                // Take a window of size x
                if (i >= x && dp[j - 1][i - x] != INF) {

                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
    }
}