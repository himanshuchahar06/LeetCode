class Solution {
    public int compress(char[] chars) {

        String ans = "";

        for(int i = 0; i < chars.length; i++){
            int count = 1;

            while(i + 1 < chars.length && chars[i] == chars[i + 1]){
                count++;
                i++;
            }

            ans = ans + chars[i];

            if(count > 1){
                ans = ans + count;
            }
        }

        int k = 0;

        for(int i = 0; i < ans.length(); i++){
            chars[k] = ans.charAt(i);
            k++;
        }

        return k;
    }
}