class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // isPal[i][j] = true if s[i...j] is palindrome
        boolean[][] isPal = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 1) {
                        isPal[i][j] = true;
                    } 
                    else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }

        // dp[i] = maximum number of palindromes
        // using first i characters
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Don't take a palindrome ending here
            dp[i] = dp[i - 1];

            // Try every possible starting point
            for (int start = 0; start <= i - k; start++) {

                if (isPal[start][i - 1]) {

                    dp[i] = Math.max(
                        dp[i],
                        dp[start] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}