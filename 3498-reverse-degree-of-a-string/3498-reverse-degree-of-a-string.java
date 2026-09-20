class Solution {
    public int reverseDegree(String s) {
        char arr[]= s.toCharArray();


   int sum=0;

  for(int i=0;i<s.length();i++){
    char ch = s.charAt(i);

    int rev=26- (ch-'a');
    sum=sum+ rev*(i+1);




  }
   
        
        
        return sum;
    }
}