
class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();
        int[][] cost = new int[n][n];

        // Step 1: Calculate cost for every substring
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int len = j - i + 1;
                int min = n;

                // Try every valid divisor
                for (int d = 1; d < len; d++) {

                    if (len % d == 0) {

                        int count = 0;

                        // Compare mirror characters
                        for (int offset = 0; offset < d; offset++) {

                            int l = i + offset;
                            int r = j - d + 1 + offset;

                            while (l < r) {

                                if (s.charAt(l) != s.charAt(r)) {
                                    count++;
                                }

                                l += d;
                                r -= d;
                            }
                        }

                        min = Math.min(min, count);
                    }
                }

                cost[i][j] = min;
            }
        }

        // Step 2: DP
        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, 100000);
        }

        dp[0][0] = 0;

        // dp[i][j] = minimum cost to divide
        // first i characters into j substrings

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                for (int p = 0; p < i - 1; p++) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[p][j - 1] + cost[p][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
