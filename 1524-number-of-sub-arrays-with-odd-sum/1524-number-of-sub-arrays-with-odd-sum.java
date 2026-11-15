class Solution {
    public int numOfSubarrays(int[] arr) {

        int mod = 1000000007;

        long even = 1;
        long odd = 0;
        long count = 0;

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum % 2 == 0) {

                count = (count + odd) % mod;
                even++;

            } else {

                count = (count + even) % mod;
                odd++;

            }
        }

        return (int) count;
    }
}