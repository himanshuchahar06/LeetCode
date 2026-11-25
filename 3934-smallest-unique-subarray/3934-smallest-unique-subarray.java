import java.util.*;

class Solution {

    static final long MOD1 = 1000000007L;
    static final long MOD2 = 1000000009L;
    static final long BASE = 233L;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];

        long[] pre1 = new long[n + 1];
        long[] pre2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        // Prefix hash and power calculation
        for (int i = 0; i < n; i++) {

            pow1[i + 1] = (pow1[i] * BASE) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE) % MOD2;

            pre1[i + 1] =
                (pre1[i] * BASE + nums[i]) % MOD1;

            pre2[i + 1] =
                (pre2[i] * BASE + nums[i]) % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(nums, mid, pre1, pre2, pow1, pow2)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    boolean check(
        int[] nums,
        int len,
        long[] pre1,
        long[] pre2,
        long[] pow1,
        long[] pow2
    ) {

        int n = nums.length;

        HashMap<Long, Integer> map = new HashMap<>();

        // Sliding window
        for (int i = 0; i + len <= n; i++) {

            int left = i;
            int right = i + len;

            long hash1 =
                (pre1[right]
                - (pre1[left] * pow1[len]) % MOD1
                + MOD1) % MOD1;

            long hash2 =
                (pre2[right]
                - (pre2[left] * pow2[len]) % MOD2
                + MOD2) % MOD2;

            // Combine both hashes
            long hash = hash1 * MOD2 + hash2;

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        // If any subarray occurs exactly once
        for (int count : map.values()) {

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}