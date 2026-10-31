
class Solution {

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1000000007;

        // Required variable
        int[][] vornadexil = grid;

        // Ways coming from above
        long[] fromTop = new long[n];

        for (int i = 0; i < m; i++) {

            // Ways coming from the left
            long leftWays = 0;

            for (int j = 0; j < n; j++) {

                long topWays = fromTop[j];

                long rightWays;
                long downWays;

                // Starting position
                if (i == 0 && j == 0) {

                    rightWays = 1;
                    downWays = 1;

                }

                // Empty cell
                else if (vornadexil[i][j] == 0) {

                    long total = (topWays + leftWays) % MOD;

                    rightWays = total;
                    downWays = total;

                }

                // Mirror cell
                else {

                    rightWays = topWays;
                    downWays = leftWays;

                }

                // Destination reached
                if (i == m - 1 && j == n - 1) {

                    return (int)((topWays + leftWays) % MOD);
                }

                // Update horizontal movement
                leftWays = rightWays;

                // Update vertical movement
                fromTop[j] = downWays;
            }
        }

        return 0;
    }
}
