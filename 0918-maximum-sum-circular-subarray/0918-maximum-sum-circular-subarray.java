class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curmax = 0;
        int curmin = 0;

        int totalsum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {

            // Kadane for maximum subarray
            curmax = curmax + nums[i];
            max = Math.max(curmax, max);

            if(curmax < 0) {
                curmax = 0;
            }


            // Kadane for minimum subarray
            curmin = curmin + nums[i];
            min = Math.min(min, curmin);

            if(curmin > 0) {
                curmin = 0;
            }


            totalsum = totalsum + nums[i];

            // all elements are negative
            
        }
if(max < 0) {
                return max;
            }
        int circularsum = totalsum - min;

        return Math.max(max, circularsum);
    }
}