class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        for (int i = 0; i < 26; i++) {
            first[i] = n;
            last[i] = -1;
        }

        // first and last occurrence
        for (int i = 0; i < n; i++) {

            int ch = s.charAt(i) - 'a';

            first[ch] = Math.min(first[ch], i);
            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // find all valid intervals
        for (int ch = 0; ch < 26; ch++) {

            if (first[ch] == n) {
                continue;
            }

            int left = first[ch];
            int right = last[ch];

            int i = left;
            boolean valid = true;

            while (i <= right) {

                int current = s.charAt(i) - 'a';

                // occurrence exists before left
                if (first[current] < left) {
                    valid = false;
                    break;
                }

                right = Math.max(right, last[current]);

                i++;
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // IMPORTANT:
        // choose interval which ends earliest
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (left > prevEnd) {

                ans.add(s.substring(left, right + 1));

                prevEnd = right;
            }
        }

        return ans;
    }
}