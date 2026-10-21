
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Check whether the string is already sorted
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // Cannot sort a reversed string of length 2
        // because the entire string cannot be selected
        if (n == 2) {
            return -1;
        }

        char min = s.charAt(0);
        char max = s.charAt(0);

        // Find minimum and maximum characters
        for (int i = 1; i < n; i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        // One operation is enough
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Check the middle characters
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        return 3;
    }
}
