import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(s);
        visited.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (isValid(curr)) {
                    ans.add(curr);
                    found = true;
                }

                if (found) {
                    continue;
                }

                for (int j = 0; j < curr.length(); j++) {
                    char ch = curr.charAt(j);

                    if (ch != '(' && ch != ')') {
                        continue;
                    }

                    String next = curr.substring(0, j)
                                + curr.substring(j + 1);

                    if (visited.add(next)) {
                        q.add(next);
                    }
                }
            }

            if (found) {
                break;
            }
        }

        return ans;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}