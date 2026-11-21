
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] newParent = parent.clone();

        int[] last = new int[26];
        Arrays.fill(last, -1);

        // Find nearest ancestor with same character
        dfs1(0, adj, s, last, newParent);

        // Build modified tree
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] ans = new int[n];

        dfs2(0, tree, ans);

        return ans;
    }

    void dfs1(int node, List<Integer>[] adj, String s,
              int[] last, int[] newParent) {

        int ch = s.charAt(node) - 'a';

        int old = last[ch];

        if (old != -1) {
            newParent[node] = old;
        }

        last[ch] = node;

        for (int child : adj[node]) {
            dfs1(child, adj, s, last, newParent);
        }

        last[ch] = old;
    }

    int dfs2(int node, List<Integer>[] tree, int[] ans) {

        int size = 1;

        for (int child : tree[node]) {
            size += dfs2(child, tree, ans);
        }

        ans[node] = size;

        return size;
    }
}
