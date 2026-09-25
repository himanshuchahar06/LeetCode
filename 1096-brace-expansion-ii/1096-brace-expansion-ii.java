class Solution {

    TreeSet<String> set = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {

        dfs(expression);

        return new ArrayList<>(set);
    }

    public void dfs(String exp) {

        // No braces left
        if (!exp.contains("}")) {
            set.add(exp);
            return;
        }

        // Find first closing brace
        int j = exp.indexOf('}');

        // Find matching opening brace
        int i = exp.lastIndexOf('{', j);

        // Before { 
        String left = exp.substring(0, i);

        // After }
        String right = exp.substring(j + 1);

        // Inside braces
        String middle = exp.substring(i + 1, j);

        // Split by comma
        String[] parts = middle.split(",");

        for (String part : parts) {

            String newExp = left + part + right;

            dfs(newExp);
        }
    }
}