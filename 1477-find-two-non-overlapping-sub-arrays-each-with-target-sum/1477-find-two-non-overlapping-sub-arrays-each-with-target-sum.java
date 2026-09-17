class Solution {

    public int binarySearch(int[] prefix, int target, int l) {

        int r = prefix.length - 1;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(prefix[mid] == target) {
                return mid;
            }

            if(prefix[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }


    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        int[] prefix = new int[n + 1];

        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int INF = 1000000;

        // best[i] = shortest valid subarray
        // whose ending position is before i
        int[] best = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            best[i] = INF;
        }

        int ans = INF;

        for(int i = 0; i < n; i++) {

            int needed = prefix[i] + target;

            // prefix[j] - prefix[i] = target
            int j = binarySearch(prefix, needed, i + 1);

            if(j != -1) {

                int len = j - i;

                // best[i] contains a subarray completely
                // before the current subarray
                if(best[i] != INF) {
                    ans = Math.min(ans, best[i] + len);
                }

                // Current subarray ends at j
                best[j] = Math.min(best[j], len);
            }

            // Carry previous best forward
            if(i + 1 <= n) {
                best[i + 1] = Math.min(best[i + 1], best[i]);
            }
        }

        if(ans == INF) {
            return -1;
        }

        return ans;
    }
}