
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] temp = dq.removeLast();

                int nextNum = temp[0];
                int nextCount = temp[1];

                count += nextCount;

                cost += (long) (num - nextNum) * nextCount;
            }

            dq.addLast(new int[]{num, count});

            while (cost > k) {

                int[] temp = dq.removeFirst();

                int rightNum = temp[0];
                int rightCount = temp[1];

                cost -= (long) (rightNum - nums[j]);
                j--;

                if (rightCount > 1) {
                    dq.addFirst(new int[]{rightNum, rightCount - 1});
                }
            }

            ans += j - i + 1;
        }

        return ans;
    }
}
