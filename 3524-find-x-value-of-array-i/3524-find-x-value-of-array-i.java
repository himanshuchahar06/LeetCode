class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at current index
        // having product % k == r
        long[] dp = new long[k];

        for (int i = 0; i < nums.length; i++) {

            int mod = nums[i] % k;

            long[] newDp = new long[k];

            // Start a new subarray with nums[i]
            newDp[mod] = 1;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                int newMod = (int)(((long) r * mod) % k);

                newDp[newMod] += dp[r];
            }

            // Add current subarrays to final answer
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            dp = newDp;
        }

        return ans;
    }
}