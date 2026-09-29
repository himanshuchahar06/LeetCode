class Solution {
    private boolean[][][] visited;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // 1. Path length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // 2. Must start with '(' and end with ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // Max possible balance is (m + n) / 2
        int maxBal = (m + n) / 2;
        visited = new boolean[m][n][maxBal + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int bal) {
        // Update balance
        bal += (grid[r][c] == '(') ? 1 : -1;

        // Balance cannot drop below 0
        if (bal < 0) {
            return false;
        }

        // Pruning: bal cannot exceed remaining steps to the end
        int remainingSteps = (m - 1 - r) + (n - 1 - c);
        if (bal > remainingSteps) {
            return false;
        }

        // Base case: reached bottom-right cell
        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }

        // Already explored this state and it failed
        if (visited[r][c][bal]) {
            return false;
        }
        visited[r][c][bal] = true;

        // Move right
        if (c + 1 < n && dfs(grid, r, c + 1, bal)) {
            return true;
        }

        // Move down
        if (r + 1 < m && dfs(grid, r + 1, c, bal)) {
            return true;
        }

        return false;
    }
}