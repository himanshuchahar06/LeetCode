class Solution {
    public int minimumRecolors(String blocks, int k) {

        char[] arr = blocks.toCharArray();

        int count = 0;
        int x = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i] == 'W') {
                count++;
            }
        }

        int ans = count;

        for (int i = k; i < arr.length; i++) {

            if (arr[i - k] == 'W') {
                count--;
            }

            if (arr[i] == 'W') {
                count++;
            }

            ans = Math.min(ans, count);

            if (ans == 0) {
                return 0;
            }
        }

        return ans;
    }
}