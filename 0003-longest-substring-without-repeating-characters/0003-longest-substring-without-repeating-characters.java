class Solution {
    public int lengthOfLongestSubstring(String s) {

       
        char arr[]= s.toCharArray();

        int ans=0;



        for(int i=0;i<arr.length;i++){
                String sub=" ";
                 int freq[]=new int [256];

            for(int j=i;j<arr.length;j++){

                char ch= arr[j];
                if(freq[ch]>0){
                    break;


                }
                    freq[ch]++;
              sub=sub+arr[j];

              ans=Math.max(ans,sub.length()-1);





            }
        }
        return ans ;

    }
}