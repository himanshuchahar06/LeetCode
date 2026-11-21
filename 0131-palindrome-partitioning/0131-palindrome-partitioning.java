
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        Stack<Integer> index = new Stack<>();
        Stack<List<String>> listStack = new Stack<>();

        index.push(0);
        listStack.push(new ArrayList<>());

        while (!index.isEmpty()) {

            int i = index.pop();
            List<String> list = listStack.pop();

            if (i == s.length()) {
                ans.add(list);
                continue;
            }

            for (int j = i; j < s.length(); j++) {

                String sub = s.substring(i, j + 1);

                boolean flag = true;

                int l = 0;
                int r = sub.length() - 1;

                while (l < r) {

                    if (sub.charAt(l) != sub.charAt(r)) {
                        flag = false;
                        break;
                    }

                    l++;
                    r--;
                }

                if (flag) {

                    List<String> temp = new ArrayList<>(list);
                    temp.add(sub);

                    index.push(j + 1);
                    listStack.push(temp);
                }
            }
        }

        return ans;
    }
}
