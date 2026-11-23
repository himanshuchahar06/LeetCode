
import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } 
            else {

                while (!st.isEmpty() && st.peek() > 0) {

                    if (Math.abs(asteroids[i]) > st.peek()) {
                        st.pop();
                    } 
                    else if (Math.abs(asteroids[i]) < st.peek()) {
                        asteroids[i] = 0;
                        break;
                    } 
                    else {
                        asteroids[i] = 0;
                        st.pop();
                        break;
                    }
                }

                if (asteroids[i] != 0) {
                    st.push(asteroids[i]);
                }
            }
        }

        int ans[] = new int[st.size()];

        for (int i = 0; i < st.size(); i++) {
            ans[i] = st.get(i);
        }

        return ans;
    }
}
